import streamlit as st
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import joblib
from statsmodels.tsa.statespace.sarimax import SARIMAXResults

st.markdown(
    """
    <style>
    .block-container {
        padding-top: 1rem;  /* default is ~2rem, reduce to 1rem or 0.5rem */
        padding-bottom: 0rem;
    }
    </style>
    """,
    unsafe_allow_html=True
)



st.set_page_config(page_title="Apple Stock Forecast", layout="wide")
st.title("Apple Stock Price Forecast")

# -----------------------------
# Load Data & Model
# -----------------------------
@st.cache_data
def load_data():
    df = pd.read_csv("P639 DATASET.csv", parse_dates=['Date'])
    df.set_index('Date', inplace=True)

    # Feature Engineering
    df['MA_7'] = df['Adj Close'].rolling(7).mean()
    df['MA_21'] = df['Adj Close'].rolling(21).mean()
    df['MA_50'] = df['Adj Close'].rolling(50).mean()
    df['Volatility_7'] = df['Adj Close'].rolling(7).std()
    df['Volatility_21'] = df['Adj Close'].rolling(21).std()
    df['Market_Trend'] = df['Adj Close'].rolling(30).mean()
    df.dropna(inplace=True)
    return df

@st.cache_resource
def load_model():
    model = SARIMAXResults.load("arimax_model.pkl")
    adj_scaler = joblib.load("adj_scaler.pkl")
    exog_scaler = joblib.load("exog_scaler.pkl")
    return model, adj_scaler, exog_scaler

df = load_data()
arimax_model, adj_scaler, exog_scaler = load_model()
exog_features = ['MA_7', 'MA_21', 'Volatility_7', 'Market_Trend']

# -----------------------------
# Sidebar Inputs
# -----------------------------
st.sidebar.header("Forecast Settings")
# Get min and max dates from dataset
min_date = df.index.min().date()
max_date = df.index.max().date()

last_date = st.sidebar.date_input(
    "Select Last Available Date",
    value=max_date,
    min_value=min_date,
    max_value=max_date
)
forecast_days = st.sidebar.slider("Forecast Days", 1, 30, 30)
# -----------------------------
# Dynamic Data Filtering
# -----------------------------
selected_date = pd.to_datetime(last_date)

# Filter dataset up to selected date
filtered_df = df[df.index <= selected_date]

if filtered_df.empty:
    st.error("No data available for selected date.")
    st.stop()


# -----------------------------
# Prepare Exogenous Features for Forecast
# -----------------------------
last_exog = filtered_df[exog_features].iloc[-1].values.reshape(1, -1)

last_exog_scaled = exog_scaler.transform(last_exog)

future_exog_scaled = np.repeat(last_exog_scaled, forecast_days, axis=0)

# Add tiny daily trend to simulate realistic rise
for i in range(forecast_days):
    future_exog_scaled[i, exog_features.index('Market_Trend')] *= (1 + 0.001*(i+1))
    future_exog_scaled[i, exog_features.index('MA_7')] *= (1 + 0.0005*(i+1))
    future_exog_scaled[i, exog_features.index('MA_21')] *= (1 + 0.0003*(i+1))

# -----------------------------
# Forecast
# -----------------------------
forecast_scaled = arimax_model.get_forecast(steps=forecast_days, exog=future_exog_scaled)
forecast_mean_scaled = forecast_scaled.predicted_mean

# Inverse transform
forecast_real = adj_scaler.inverse_transform(forecast_mean_scaled.values.reshape(-1,1)).flatten()

forecast_df = pd.DataFrame({
    'Date': pd.date_range(start=pd.to_datetime(last_date)+pd.Timedelta(days=1),
                          periods=forecast_days, freq='B'),
    'Forecasted Price': forecast_real
})
forecast_df.set_index('Date', inplace=True)

# -----------------------------
# UI-Improved Layout: Plot + Forecast Table
# -----------------------------
st.subheader("Apple Stock Forecast Overview")

# Create two columns: left for plot, right for table
col1, col2 = st.columns([2, 1])  # 2:1 ratio for more space to plot

with col1:
    st.markdown("**Historical vs Forecasted Prices**")
    plt.figure(figsize=(10,5))
    plt.plot(filtered_df['Adj Close'], label='Historical', color='blue')

    plt.plot(
    pd.concat([filtered_df['Adj Close'].iloc[-1:], forecast_df['Forecasted Price']]),
    label='Forecast',
    color='red'
)

    plt.fill_between(forecast_df.index,
                     forecast_df['Forecasted Price']*0.98,
                     forecast_df['Forecasted Price']*1.02,
                     color='gray', alpha=0.3, label="Approx. CI")
    plt.xlabel("Date")
    plt.ylabel("Price")
    plt.title("Apple Stock Forecast (ARIMAX)")
    plt.legend()
    plt.grid(True)
    st.pyplot(plt)

with col2:
    st.markdown(f"**Forecast Table (Next {forecast_days} Days)**")

    # Prepare table with Daily Change
    table_df = forecast_df[['Forecasted Price']].copy()
    table_df['Daily Change'] = table_df['Forecasted Price'].diff().fillna(0)
    table_df['Daily Change'] = table_df['Daily Change'].apply(
        lambda x: f"{x:.2f} ↑" if x >= 0 else f"{abs(x):.2f} ↓"
    )

    # CSS styling for up/down
    def highlight_change_css(row):
        color = 'color: green;' if '↑' in str(row['Daily Change']) else 'color: red;'
        return [color]*len(row)

    # Display styled table
    st.dataframe(
        table_df.style
        .apply(highlight_change_css, axis=1)
        .format({'Forecasted Price': '{:.2f}'})
        .set_table_styles([
            {'selector': 'th', 'props': [('background-color', '#f0f0f0'), ('font-weight', 'bold')]}
        ])
    )


# -----------------------------
# Block 8A: Trend / MA / Volatility Plots
# -----------------------------
st.subheader("Trend, Moving Averages, and Volatility")
if st.checkbox("Show Moving Averages & Volatility Plots"):
    plt.figure(figsize=(12,5))
    plt.plot(filtered_df['Adj Close'], label='Adj Close', color='blue')
    plt.plot(filtered_df['MA_7'], label='MA 7', color='orange')
    plt.plot(filtered_df['MA_21'], label='MA 21', color='green')
    plt.plot(filtered_df['MA_50'], label='MA 50', color='red')

    plt.title("Apple Stock Price & Moving Averages")
    plt.xlabel("Date")
    plt.ylabel("Scaled Price")
    plt.legend()
    plt.grid(True)
    st.pyplot(plt)

    plt.figure(figsize=(12,4))
    plt.plot(filtered_df['Volatility_7'],label='V 7', color='orange' )
    plt.plot(filtered_df['Volatility_21'], label='V 21', color='green')

    plt.title("Apple Stock Volatility")
    plt.xlabel("Date")
    plt.ylabel("Volatility")
    plt.legend()
    st.pyplot(plt)


# -----------------------------
# Block 6A: Model Info
# -----------------------------
st.subheader("Model Information")
st.markdown(f"""
- **Model Used:** ARIMAX  
- **Training Data Range:** {df.index.min().date()} to {df.index.max().date()}  
- **Exogenous Features:** {', '.join(exog_features)}  
- **Scaling Method:** MinMaxScaler  
- **Forecast Horizon:** {forecast_days} days  
""")

