import streamlit as st
import pandas as pd
import numpy as np
import joblib
# Importing Dataset-
import pandas as pd
df = pd.read_csv("Dataset.csv")
# Loading Model and trained features -
model = joblib.load("bike_rent_model.pkl")
features = joblib.load("model_features.pkl")
# Title and Description
st.title("Bike Rental Demand Prediction")
st.markdown("""
<style>

/* Page background */
.stApp {
    background: linear-gradient(135deg, #f5f7fa, #e4ecf7);
}

/* Main title */
h1 {
    color: #FF7A00 !important;
    text-align: center;
    font-weight: 700;
}

/* Subheaders */
h2, h3 {
    color: black !important;
}

/* Sidebar styling */
section[data-testid="stSidebar"] {
    background-color: #1f4e79;
    color: white;
}


section[data-testid="stSidebar"] p,
section[data-testid="stSidebar"] span,
section[data-testid="stSidebar"] label,
section[data-testid="stSidebar"] h1,
section[data-testid="stSidebar"] h2,
section[data-testid="stSidebar"] h3 {
    color: white !important;
}
/* Main page text */
section.main p,
section.main span,
section.main label,
section.main div {
    color: black !important;
}


/* Sidebar title */
section[data-testid="stSidebar"] h1,
section[data-testid="stSidebar"] h2,
section[data-testid="stSidebar"] h3 {
    color: #f1f1f1 !important;
}


/* Input widgets */
div[data-baseweb="slider"] {
    padding: 10px 0;
}

/* Buttons */
.stButton>button {
    background: linear-gradient(90deg, #1f77b4, #4fa3f7);
    color: white;
    font-size: 18px;
    border-radius: 12px;
    padding: 12px 28px;
    border: none;
    transition: all 0.3s ease;
}

.stButton>button:hover {
    background: linear-gradient(90deg, #155a8a, #1f77b4);
    transform: scale(1.05);
}

/* Success message */
div[data-testid="stAlert"] {
    border-radius: 10px;
    font-size: 18px;
}

/* Info box */
div[data-testid="stInfo"] {
    background-color: #e8f4fd;
    border-left: 6px solid #1f77b4;
    border-radius: 8px;
}
/* Subtitles */
h4, h5, h6 {
    color: black !important;
}

/* Model info / description text */
div[data-testid="stMarkdownContainer"] {
    color: black !important;
}

</style>
""", unsafe_allow_html=True)

# Form
st.sidebar.header("Input Parameters")
hour = st.sidebar.slider("Hour of Day", 0, 23, 12)
temp = st.sidebar.slider("Temperature (Normalized)", 0.0, 1.0, 0.5)
hum = st.sidebar.slider("Humidity", 0.0, 1.0, 0.5)
windspeed = st.sidebar.slider("Wind Speed", 0.0, 1.0, 0.2)
workingday = st.sidebar.selectbox("Working Day", ["Yes", "No"])
season = st.sidebar.selectbox("Season", ["spring", "summer", "fall", "winter"])
st.subheader("Selected Conditions")
st.write({
    "Hour": hour,
    "Temperature": temp,
    "Humidity": hum,
    "Wind Speed": windspeed,
    "Working Day": workingday,
    "Season": season
})

# User Input to Model Format Conversion
input_dict = {
    'hr': hour,
    'temp': temp,
    'hum': hum,
    'windspeed': windspeed,
    'workingday_workingday': 1 if workingday == "Yes" else 0,
    'season_spring': 1 if season == "spring" else 0,
    'season_summer': 1 if season == "summer" else 0,
    'season_fall': 1 if season == "fall" else 0
}
input_df = pd.DataFrame([input_dict])
for col in features:
    if col not in input_df.columns:
        input_df[col] = 0

input_df = input_df[features]
# Output Button
if st.button("Predict Demand"):
    prediction = model.predict(input_df)
    st.success(f"Estimated Bike Demand: {int(prediction[0])}")
# EDA Button
st.divider()
st.subheader("Exploratory Data Analysis (EDA)")

if st.button("Show EDA Report"):
    st.write("### Dataset Overview")
    st.write("Shape of dataset:", df.shape)
    st.write(df.head())

    st.write("### Missing Values")
    st.write(df.isnull().sum())

    st.write("### Statistical Summary")
    st.write(df.describe())

# Output of EDA report-
import matplotlib.pyplot as plt
import seaborn as sns

if st.button("Show EDA Visualizations"):
    st.write("### Demand Distribution")
    fig, ax = plt.subplots()
    sns.histplot(df['cnt'], kde=True, ax=ax)
    st.pyplot(fig)

    st.write("### Correlation Heatmap")
    fig, ax = plt.subplots(figsize=(10,6))
    sns.heatmap(df.corr(numeric_only=True), annot=False, cmap="coolwarm", ax=ax)
    st.pyplot(fig)

# Model Info-
# Model Info Section
st.info("""
**Model Used:** XGBoost Regression  
**Best R² Score:** 0.96  
**Outliers:** Retained for real-world robustness
""")
# View Report-
if st.button("View EDA Summary"):
    st.info("""
    • Dataset contains hourly bike rental data  
    • Demand is right-skewed with peak usage during working hours  
    • Weather and season significantly influence demand  
    • Strong correlation between registered users and total demand  
    • Outliers were retained to reflect real-world demand behavior
    """)
# Footer-
st.divider()
st.markdown(
    "<p class='custom-footer'>Developed as part of a Data Science Project | Bike Demand Forecasting</p>",
    unsafe_allow_html=True
)




