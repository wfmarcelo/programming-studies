// Educacional.Core.Domain/Entities/Aluno.cs
using Educacional.Core.Domain.ValueObjects;

namespace Educacional.Core.Domain.Entities
{
    // O Aluno é a Entidade que tem uma identidade única e ciclo de vida.
    public class Student 
    {
        public Guid Id { get; private set; }
        
        // Propriedades de Pessoa
        public string Name { get; private set; } 
        public DateTime DateOfBirth { get; private set; }
        public Cpf IdentifierDocument { get; private set; } // Uso do Value Object
        
        // Propriedades Específicas de Aluno
        public string Registration { get; private set; }

        private Student(string name, Cpf cpf, DateTime dateOfBirth, string registration)
        {
            Id = Guid.NewGuid();
            Name = name;
            IdentifierDocument = cpf;
            DateOfBirth = dateOfBirth;
            Registration = registration;

            ValidateAge();
        }

        public static Student Create(string name, string cpf, DateTime dateOfBirth, string registration)
        {
            // O domínio garante que o CPF é válido antes de criar o aluno
            var documento = new Cpf(cpf);

            return new Student(name, documento, dateOfBirth, registration);
        }
        
        // Regra de Negócio de Domínio
        private void ValidateAge()
        {
            if (DateOfBirth > DateTime.Now.AddYears(-5))
            {
                throw new ArgumentException("Alunos devem ter pelo menos 5 anos de idade.");
            }
        }
        
        // Exemplo de como o Domínio muda o próprio estado
        public void UpdateName(string novoNome)
        {
            if (string.IsNullOrWhiteSpace(novoNome))
                throw new ArgumentException("O nome não pode ser vazio.");
            Name = novoNome;
        }
    }
}