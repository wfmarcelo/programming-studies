from langchain_tavily import TavilySearch
from langchain.chat_models import init_chat_model
from langgraph.prebuilt import create_react_agent



search = TavilySearch(max_results=2)
search_results = search.invoke("What is the weather in Caçador")
# print(search_results)

tools = [search]

model = init_chat_model("google_genai:gemini-2.5-flash")
agent_executor = create_react_agent(model, tools)

# query = "Hi, I'm Marcelo."
# response = model.invoke([{"role": "user", "content": query}])
# print(response.text())

# model_with_tools = model.bind_tools(tools)

# query = "Search for the weather in Caçador"
# response = model_with_tools.invoke([{"role": "user", "content": query}])
# print(f"Message content: {response.text()}\n")
# print(f"Tool calls: {response.tool_calls}")

input_message = {"role": "user", "content": "Search for the weather in Caçador-SC"}

# response = agent_executor.invoke({"messages": [input_message]})

# for message in response["messages"]:
#     message.pretty_print()

for step in agent_executor.stream({"messages": [input_message]}, stream_mode="values"):
    step["messages"][-1].pretty_print()