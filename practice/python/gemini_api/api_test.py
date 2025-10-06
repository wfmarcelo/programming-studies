import os
import google.generativeai as genai

api_key = os.getenv("GOOGLE_API_KEY")

if not api_key:
    raise ValueError("API key not found. Please set th 'GOOGLE_API_KEY' environment variable")

genai.configure(api_key=api_key)

model = genai.GenerativeModel("gemini-1.5-flash")

prompt = "Explain large language models in a simple way."

print("\n--- Sending prompot fo Gemini API ---")
print(f"Prompt: '{prompt}'")

try:
    response = model.generate_content(prompt)

    print("\n--- Model Response ---")
    print(response.text)

except Exception as e:
    print(f"\nAn error occurred: {e}")