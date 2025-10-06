import streamlit as st
import pandas as pd


df = pd.DataFrame({
    'first column': [1, 2, 3, 4],
    'second column': [10, 20, 30, 40]
})

st.write("He's our first attempt at using data to create a table:")
st.write(df)

st.table(df)