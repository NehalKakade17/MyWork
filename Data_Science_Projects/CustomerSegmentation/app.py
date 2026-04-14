import streamlit as st
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
import joblib

# Load model
model = joblib.load("model.pkl")
df = pd.read_csv("final_data.csv")


# Sidebar
st.sidebar.title("About")
st.sidebar.info("This app predicts customer segments based on behavior and demographics.")

st.set_page_config(layout="wide")

st.title("🧠 Customer Segmentation Dashboard")

# Create two sections
left_col, right_col = st.columns([1, 2])  

# ---------------- LEFT SIDE (INPUT) ---------------- #
with left_col:
    st.header("📋 Enter Customer Details")

    income = st.number_input("💰 Income", min_value=0)
    spending = st.number_input("🛍️ Total Spending", min_value=0)
    recency = st.number_input("⏳ Recency", min_value=0)
    store = st.number_input("🏬 Store Purchases", min_value=0)

    web = st.number_input("🌐 Web Purchases", min_value=0)
    catalog = st.number_input("📖 Catalog Purchases", min_value=0)
    age = st.number_input("🎂 Age", min_value=0)
    children = st.number_input("👶 Children", min_value=0)

    prediction = None
    if st.button("🔍 Predict"):
     input_data = np.array([[income, spending, recency, store, web, catalog, age, children]])
     prediction = model.predict(input_data)[0]

     segment_names = {
        0: "Low Value Families",
        1: "Premium Customers",
        2: "Store-Oriented Customers",
        3: "Online Customers"
     }

     st.success(f"🎯 {segment_names[prediction]}")

   

# ---------------- RIGHT SIDE (CHARTS) ---------------- #
with right_col:
    st.header("📊 Insights")

    col1, col2 = st.columns(2)

    with col1:
        st.subheader("👥 Segment Distribution")
        fig1, ax1 = plt.subplots(figsize=(8,6))
        sns.countplot(x='Customer_Segment', data=df)
        plt.xticks(rotation=30)
        plt.title("Segments")
        st.pyplot(fig1)
        plt.tight_layout()

    with col2:
         # (Dynamic Graph)
         st.subheader("📍 Your Position in Customer Segments")

         import plotly.express as px
         import plotly.graph_objects as go

         fig = px.scatter(
          df,
          x="Income",
          y="Total_Spending",
          color="Customer_Segment"
         )

         # Highlight user input
         fig.add_trace(go.Scatter(
          x=[income],
          y=[spending],
          mode='markers',
          marker=dict(size=18, color='yellow',symbol='star'),
          name="Your Input"
         ))
         fig.update_layout(height=650)
         st.plotly_chart(fig, use_container_width=True)
     