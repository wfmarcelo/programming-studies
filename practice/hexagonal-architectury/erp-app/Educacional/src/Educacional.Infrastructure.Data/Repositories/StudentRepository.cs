// Educacional.Infrastructure.Data/Repositories/AlunoRepository.cs
using Educacional.Core.Domain.Entities;
using Educacional.Core.Domain.Ports.Outbound;
using Educacional.Core.Domain.ValueObjects;
using Educacional.Infrastructure.Data.Context;
using Microsoft.EntityFrameworkCore;

namespace Educacional.Infrastructure.Data.Repositories
{
    public class StudentRepository : IStudentRepository
    {
        private readonly EducacionalContext _context;

        public StudentRepository(EducacionalContext context)
        {
            _context = context;
        }

        public async Task AddAsync(Student aluno)
        {
            _context.Alunos.Add(aluno);
            await _context.SaveChangesAsync();
        }

        public async Task<Student> GetByIdAsync(Guid id)
        {
            return await _context.Alunos.FirstOrDefaultAsync(a => a.Id == id);
        }

        public async Task<Student> GetByCpfAsync(Cpf cpf)
        {
            // Busca o CPF usando o valor interno do Value Object
            return await _context.Alunos.FirstOrDefaultAsync(a => a.IdentifierDocument.Valor == cpf.Valor);
        }

        public async Task<IEnumerable<Student>> GetAllAsync()
        {
            return await _context.Alunos.ToListAsync();
        }

        public async Task UpdateAsync(Student aluno)
        {
            _context.Alunos.Update(aluno);
            await _context.SaveChangesAsync();
        }
    }
}