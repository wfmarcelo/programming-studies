import pyodbc
import os
import pypdf
from datetime import date
import json
import google.generativeai as genai

api_key = os.getenv("GOOGLE_API_KEY")
genai.configure(api_key=api_key)

model = genai.GenerativeModel("gemini-2.5-flash")

file_path = "calendario.json"
pdf_path = "calendario.pdf"


def main():
    
    
    connection_string = os.getenv("ConnectionStrings__PY__CorporeRM")

    current_year = date.today().year

    sql_query = """
        select 
            GCALEND.CODIGO,
            GCALEND.NOME AS CALENDARIO,
            GFERIADO.DIAFERIADO,
            GFERIADO.NOME AS FERIADO
            
        from 
            GCALEND (nolock)

            INNER JOIN GFERIADO (NOLOCK) ON
                GFERIADO.CODCALENDARIO = GCALEND.CODIGO

        WHERE 1 = 1
        AND GCALEND.CODIGO LIKE CONCAT('%', ?, '%')
        """


    try:
        # with pyodbc.connect(connection_string) as cnn:
        #     with cnn.cursor() as cursor:

        #         print("Executing query to get SQL Server version...")
        #         cursor.execute(sql_query, current_year)

        #         rows = cursor.fetchall()

        #         if rows:
        #             print("\nConnection successful!")
                    
        #             column_names = [column[0] for column in cursor.description]
        #             result_as_dict = [dict(zip(column_names, row)) for row in rows]
        #             results_json = json.dumps(result_as_dict, indent=4, default=str)

        #             print(results_json)
        #         else:
        #             print("Query executed, but no results were returned.")

        # with open(file_path, 'r') as json_file:
        #     context = json.load(json_file)

        context = extract_text_from_pdf(pdf_path)
        
        while True:
            user_input = input("Faça sua pergunta sobre o calendário (Digite -1 para finalizar): ")

            if user_input.lower() == '-1':
                break
            
            response = question_amswering(user_input, context)
            print(response.text)
    
    except pyodbc.Error as ex:
        sqlstate = ex.args[0]
        if sqlstate == '28000':
            print("Authentication failed. Please check your username and password.")
        else:
            print(f"An error occurred: {ex}")
    except Exception as e:
        print(f"\nAn error occurred: {e}")


def question_amswering(context, question):
    return model.generate_content(f"Question: {question} Context: {context}")

def extract_text_from_pdf(file_path):
    """
    Extracts all text from a PDF file and returns it as a single string.
    """
    all_text = ""
    try:
        # Open the PDF file in binary read mode ('rb')
        with open(file_path, 'rb') as pdf_file:
            # Create a PdfReader object
            reader = pypdf.PdfReader(pdf_file)
            
            # Iterate through each page and extract text
            for page in reader.pages:
                page_text = page.extract_text()
                if page_text:
                    all_text += page_text + "\n"
        
        return all_text
    
    except FileNotFoundError:
        print(f"Error: The file '{file_path}' was not found.")
        return None
    except Exception as e:
        print(f"An error occurred: {e}")
        return None

if __name__ == "__main__":
    main()