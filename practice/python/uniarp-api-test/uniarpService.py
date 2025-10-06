import requests
import getpass
import configparser

class UniarpService:

    def __init__(self):
        config = configparser.ConfigParser()
        config.read('config.ini')    
        self.baseUrl = config['API']['url']
        self.username = ""
        self.password = ""


    def login(self):
        try:
            self.username = input("Please enter your username: ")
            self.password = getpass.getpass("Please enter your password: ")

            url = f"{self.baseUrl}/RMSRestDataServer/getavailableservices"

            print("Login ...")
            response = requests.get(url, auth=(self.username, self.password))

        except requests.exceptions.HTTPError as e:
            if e.response.status_code == 401:
                print("Authentication failed. Please check your username and password.")
            else:
                print(f"An HTTP error occurred: {e}")
        except requests.exceptions.RequestException as e:
            print(f"An error occurred: {e}")
     

    def get(self, path, context):
        try:
            url = f"{self.baseUrl}/RMSRestDataServer/rest/{path}"


            print(f"Fetching data from {url}...")
            response = requests.get(url, auth=(self.username, self.password), headers=context)

            response.raise_for_status()

            data = response.json()

            return data.get("data")
        except requests.exceptions.HTTPError as e:
            if e.response.status_code == 401:
                print("Authetication failed. Please check your username and password.")
            else:
                print(f"An HTTP error occcurred: {e}")
        except requests.exceptions.RequestException as e:
            print(f"An error occurred: {e}")
        except json.JSONDecodeError:
            print("Error: Could not decode JSON response from the API.")