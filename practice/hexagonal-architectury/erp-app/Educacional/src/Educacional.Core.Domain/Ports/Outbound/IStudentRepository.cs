// Educacional.Core.Domain/Ports/Outbound/IAlunoRepository.cs
using Educacional.Core.Domain.Entities;
using Educacional.Core.Domain.ValueObjects;

namespace Educacional.Core.Domain.Ports.Outbound
{
    public interface IStudentRepository
    {
        Task AddAsync(Student aluno);
        Task<Student> GetByIdAsync(Guid id);
        Task<Student> GetByCpfAsync(Cpf cpf); // Método específico para consulta por CPF
        Task<IEnumerable<Student>> GetAllAsync();
        Task UpdateAsync(Student aluno); 
    }
}