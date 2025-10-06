from langchain_community.utilities import SQLDatabase
import os



db_uri = os.environ.get("ConnectionStrings__PY__IA__RM")

db = SQLDatabase.from_uri(db_uri)

if not db_uri:
    raise ValueError("The 'ConnectionStrings__PY__IA__RM' environment variable is not set.")

try:
    # Initialize the SQLDatabase utility with the URI
    db = SQLDatabase.from_uri(db_uri)

    # Example: Print the dialect to confirm connection
    # print(f"Successfully connected to a {db.dialect} database.")

    # print(db.get_usable_table_names())

    # print(db.run("SELECT * FROM GCALEND"))
    
    # You can now use the 'db' object for your LangChain applications
    # print(db.get_usable_table_names())

except Exception as e:
    print(f"Error connecting to the database: {e}")

from typing_extensions import TypedDict

class State(TypedDict):
    question: str
    query: str
    result: str
    answer: str

from langchain.chat_models import init_chat_model

llm = init_chat_model("google_genai:gemini-2.5-flash")

from langchain_core.prompts import ChatPromptTemplate
system_message = """
Given an input question, create a syntactically correct {dialect} query to
run to help find the answer. Unless the user specifies in his question a
specific number of examples they wish to obtain, always limit your query to
at most {top_k} results using the top sintax, the top statement should
always be placed after the distinct statement. You can order the results 
by a relevant column to
return the most interesting examples in the database.

Never query for all the columns from a specific table, only ask for a the
few relevant columns given the question.

Pay attention to use only the column names that you can see in the schema
description. Be careful to not query for columns that do not exist. Also,
pay attention to which column is in which table.

Only use the following tables:
{table_info}
"""

user_prompt = "Question: {input}"

query_prompt_template = ChatPromptTemplate(
    [("system", system_message), ("user", user_prompt)]
)

for message in query_prompt_template.messages:
    message.pretty_print()

from typing_extensions import Annotated

class QueryOutput(TypedDict):
    """Generated SQL query."""

    query: Annotated[str, ..., "Syntactically valid SQL query."]

def write_query(state: State):
    """Generate SQL query to fetch information."""
    prompt = query_prompt_template.invoke(
        {
            "dialect": db.dialect,
            "top_k": 10,
            "table_info": db.get_table_info(),
            "input": state["question"]
        }
    )

    structured_llm = llm.with_structured_output(QueryOutput)
    result = structured_llm.invoke(prompt)
    return {"query": result["query"]}

print(db.dialect)

# print(write_query({"question": "Qual feriado ocorre no mês de setembro no calendario 2025 de caçador?"}))

from langchain_community.tools.sql_database.tool import QuerySQLDatabaseTool

def execute_query(state: State):
    """Execute SQL query"""
    execute_query_tool = QuerySQLDatabaseTool(db=db)
    return {"result": execute_query_tool.invoke(state["query"])}

def generate_answer(state: State):
    """Answer question using retrieved information as context."""
    prompt = (
        "Given the following user question, corresponding SQL query, "
        "and SQL result, answer the user question.\n\n"
        f"Question: {state['question']}\n"
        f"SQL Query: {state['query']}\n"
        f"SQL Result: {state['result']}"
    )
    response = llm.invoke(prompt)
    return {"answer": response.content}

from langgraph.graph import START, StateGraph

graph_builder = StateGraph(State).add_sequence(
    [write_query, execute_query, generate_answer]
)
graph_builder.add_edge(START, "write_query")
graph = graph_builder.compile()

for step in graph.stream(
    {"question": "Quais são os calendários de 2025?"},
    stream_mode="updates"
):
    print(step)