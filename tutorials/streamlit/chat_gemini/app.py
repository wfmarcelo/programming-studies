import streamlit as st
import os
import google.generativeai as genai

api_key = os.getenv("GOOGLE_API_KEY")
genai.configure(api_key=api_key)


st.title("Uniarp Chat")

if "messages" not in st.session_state:
    st.session_state.messages = []

if "chat" not in st.session_state:
    try:
        model = genai.GenerativeModel("gemini-2.5-flash-preview-05-20")
        st.session_state.chat = model.start_chat(history=[])
    except Exception as e:
        st.error(f"Failed to initialize Gemini model: {e}")
        st.stop() 

    
for message in st.session_state.messages:
    with st.chat_message(message["role"]):
        st.markdown(message["content"])

if prompt := st.chat_input("What is up?"):
    st.session_state.messages.append({"role": "user", "content": prompt})

    with st.chat_message("user"):
        st.markdown(prompt)

    with st.chat_message("assistant"):
        try:
            message_placeholder = st.empty()
            full_response = ""

            for chunk in st.session_state.chat.send_message(prompt, stream=True):
                full_response += chunk.text
                message_placeholder.markdown(full_response + "▌")
            
            message_placeholder.markdown(full_response)
    
            st.session_state.messages.append({"role": "assistant", "content": full_response})
        except Exception as e:
            st.error(f"An error occurred while getting a response: {e}")

