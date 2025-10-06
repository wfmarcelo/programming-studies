from langchain.chat_models import init_chat_model
from langchain_core.messages import HumanMessage
from langchain_core.messages import AIMessage

model = init_chat_model("gemini-2.5-flash", model_provider="google_genai")

# response = model.invoke([HumanMessage(content="Hi! I'm Marcelo")])

# print(response.content)

# response = model.invoke([HumanMessage(content="What's my name?")])

# print(response.content)

response = model.invoke(
    [
        HumanMessage(content="Hi! I'm Marcelo"),
        AIMessage(content="Hello Marcelo! How can I assist you today?"),
        HumanMessage(content="What's my name?"),
        
    ]
)

print(response.content)