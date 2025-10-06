from env_config import init_env_config
from gemini_config import init_gemini
from langsmith_config import init_langsmith
from langchain.chat_models import init_chat_model
from langchain_core.prompts import ChatPromptTemplate

init_env_config()
init_langsmith()
init_gemini()

model = init_chat_model("gemini-2.5-flash", model_provider="google_genai")

system_template = "Translate the following from English into {language}"

prompt_template = ChatPromptTemplate.from_messages(
    [("system", system_template), ("user", "{text}")]
)

prompt = prompt_template.invoke({"language": "Italian", "text": "hi!"})

response = model.invoke(prompt)
print(response.content)
