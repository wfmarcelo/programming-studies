from gemini_config import init_gemini
from langsmith_config import init_langsmith
from langchain.chat_models import init_chat_model
from langchain_core.messages import HumanMessage, SystemMessage
from env_config import init_env_config

init_env_config()
init_langsmith()
init_gemini()

model = init_chat_model("gemini-2.5-flash", model_provider="google_genai")

messages = [
    SystemMessage(content="Translate the following from English into Italian"),
    HumanMessage(content="hi!"),
]

# response =model.invoke(messages)
# print(response.content)

# response = model.invoke("Hello")
# print(response.content)
# response = model.invoke([{"role": "user", "content": "Hello"}])
# print(response.content)
# response = model.invoke([HumanMessage("Hello")])
# print(response.content)

for token in model.stream(messages):
    print(token.content, end="|")