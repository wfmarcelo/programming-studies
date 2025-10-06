import streamlit as st
from langchain_google_genai import ChatGoogleGenerativeAI
from langchain.memory import ConversationBufferMemory
from langchain.chains import ConversationChain
import os


st.set_page_config(page_title="Gemini Chatbot with Langchain and Streamlit")


api_key = os.getenv("GOOGLE_API_KEY")

st.title("Gemini Chatbot")

llm = ChatGoogleGenerativeAI(model="gemini-2.5-flash", temperature=0.7, google_api_key=api_key)
memory = ConversationBufferMemory(return_messages=True)
conversation_chain = ConversationChain(
    llm=llm,
    memory=memory
)

if "messages" not in st.session_state:
    st.session_state.messages = []

for message in st.session_state.messages:
    with st.chat_message(message["role"]):
        st.markdown(message["content"])

if prompt := st.chat_input("Ask me a question..."):
    st.session_state.messages.append({"role": "user", "content": prompt})

    with st.chat_message("user"):
        st.markdown(prompt)

    with st.chat_message("assistant"):
        with st.spinner("Thinking..."):
            response = conversation_chain.invoke({"input": prompt})
            st.session_state.messages.append({"role": "assistant", "content": response['response']})
            st.markdown(response['response'])
