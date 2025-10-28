// Educacional.Core.Application/Services/GerenciarAlunoService.cs
using Educacional.Core.Domain.Entities;
using Educacional.Core.Domain.Ports.Outbound;
using Educacional.Core.Application.Ports.Inbound;
using AutoMapper;

namespace Educacional.Core.Application.Services
{
    public class StudentManagementService : IStudentManagementService
    {
        private readonly IStudentRepository _studentRepository;
        private readonly IMapper _mapper;

        public StudentManagementService(IStudentRepository studentRepository, IMapper mapper)
        {
            _studentRepository = studentRepository;
            _mapper = mapper;
        }

        public async Task<StudentDto> CreateStudentAsync(CreateStudentCommand command)
        {
            // 1. O Domínio se autovalida: o Aluno.Criar já valida o CPF e a idade!
            var novoAluno = Student.Create(
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
            return _mapper.Map<StudentDto>(novoAluno);
        }

        public Task<IEnumerable<StudentDto>> GetAllStudentsAsync()
        {
            throw new NotImplementedException();
        }

        // ... Outros métodos ...
        public async Task<StudentDto> GetStudentByIdAsync(Guid id)
        {
            var student = await _studentRepository.GetByIdAsync(id);

            if (student == null)
                throw new Exception("Student not found.");

            return _mapper.Map<StudentDto>(student);
        }

        public Task UpdateStudentNameAsync(Guid id, string newName)
        {
            throw new NotImplementedException();
        }
    }
}