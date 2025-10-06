class Aluno:
    def __init__(self, data):
        self.id = data.get("id")
        self.nome = data.get("NOME")
        self.ra = data.get("RA")
        self.cpf = data.get("CPF")

    def __repr__(self):
        return (f"Aluno(Id='{self.id}', RA='{self.ra}', Nome='{self.nome}', CPF='{self.cpf}')")