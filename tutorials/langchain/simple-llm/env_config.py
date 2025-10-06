
def init_env_config():
    try:
        from dotenv import load_dotenv

        load_dotenv()
    except ImportError:
        pass