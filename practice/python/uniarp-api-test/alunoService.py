from uniarpService import UniarpService
from aluno import Aluno

class AlunoService:

    def __init__(self, uniarpService : UniarpService):
        self.context = {
            "CODCOLIGADA": "1"
        }
        self.path = "EduAlunoData"
        self.service = uniarpService

    def get(self, id):
        return Aluno(self.service.get(f"{self.path}/{id}", self.context))