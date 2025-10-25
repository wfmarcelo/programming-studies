// Educacional.Core.Application/Services/GerenciarAlunoService.cs
using Educacional.Core.Domain.Entities;
using Educacional.Core.Domain.Ports.Outbound;
using Educacional.Core.Application.Ports.Inbound;

namespace Educacional.Core.Application.Services
{
    public class StudentManagementService : IStudentManagementService
    {
        private readonly IStudentRepository _studentRepository;

        public StudentManagementService(IStudentRepository studentRepository)
        {
            _studentRepository = studentRepository;
        }

        public async Task<StudentDto> CreateStudentAsync(CreateStudentCommand command)
        {
            // 1. O Domínio se autovalida: o Aluno.Criar já valida o CPF e a idade!
            var novoAluno = Student.Criar(
                command.Name, 
                command.Cpf, 
                command.DateOfBirth, 
                command.Registration
            );
            
            // 2. Regra de Aplicação (checar duplicidade antes de persistir)
            var studentExistente = await _studentRepository.GetByCpfAsync(novoAluno.IdentifierDocument);
            if (studentExistente != null)
            {
                throw new InvalidOperationException("Já existe um aluno cadastrado com este CPF.");
            }

            // 3. Persistência
            await _studentRepository.AddAsync(novoAluno);

            // 4. Retorno
            return new StudentDto(
                novoAluno.Id, 
                novoAluno.Name, 
                novoAluno.IdentifierDocument.Valor, 
                novoAluno.DateOfBirth, 
                novoAluno.Registration
            );
        }
        
        // ... Outros métodos ...
        public async Task<StudentDto> GetStudentByIdAsync(Guid id)
        {
            var student = await _studentRepository.GetByIdAsync(id);

            if (student == null)
                throw new Exception("Student not found.");

            return new StudentDto(
                student.Id, 
                student.Name, 
                student.IdentifierDocument.Valor, 
                student.DateOfBirth, 
                student.Registration
            );
        }
    }
}