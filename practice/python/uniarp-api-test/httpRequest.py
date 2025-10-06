
from alunoService import AlunoService
from uniarpService import UniarpService


def main():

    try:
        uniarpService = UniarpService()
        uniarpService.login()
        
        alunoService = AlunoService(uniarpService)

        ra = input("Please enter the RA: ")

        aluno = alunoService.get(f"1$_${ra}")

        print(aluno)

        # print(json.dumps(data, indent=4))

    except ValueError:
        print("Invalid input. Please enter a valid number.")

if __name__ == "__main__":
    main()