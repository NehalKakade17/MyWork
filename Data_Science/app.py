import streamlit as st
import numpy as np
import joblib

model = joblib.load('diabetes_model.pkl')

st.title("Diabetes Prediction App")
st.write("This app predicts the likelihood of a person having diabetes based on health parameters.")


pregnancies = st.number_input("Number of Pregnancies", min_value=0, max_value=20, value=0)
glucose = st.number_input("Glucose Level", min_value=0, max_value=300, value=120)
bp = st.number_input("Blood Pressure", min_value=0, max_value=200, value=70)
skin = st.number_input("Skin Thickness", min_value=0, max_value=100, value=20)
insulin = st.number_input("Insulin Level", min_value=0, max_value=900, value=80)
bmi = st.number_input("BMI (Body Mass Index)", min_value=0.0, max_value=70.0, value=25.0)
dpf = st.number_input("Diabetes Pedigree Function", min_value=0.0, max_value=2.5, value=0.5)
age = st.number_input("Age", min_value=1, max_value=120, value=33)


features = np.array([[pregnancies, glucose, bp, skin, insulin, bmi, dpf, age]])


if st.button("Predict Diabetes Risk"):
    prediction = model.predict(features)[0]
    probability = model.predict_proba(features)[0][1]

    if prediction == 1:
        st.error(f" High Risk: The person is likely diabetic. (Probability: {probability:.2f})")
    else:
        st.success(f" Low Risk: The person is not diabetic. (Probability: {probability:.2f})")
