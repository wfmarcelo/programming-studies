// Educacional.Infrastructure.Data/Context/EducacionalContext.cs
using Educacional.Core.Domain.Entities;
using Educacional.Core.Domain.ValueObjects;
using Microsoft.EntityFrameworkCore;

namespace Educacional.Infrastructure.Data.Context
{
    public class EducacionalContext : DbContext
    {
        public DbSet<Student> Alunos { get; set; }

        public EducacionalContext(DbContextOptions<EducacionalContext> options) : base(options) { }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            // Configuração da Entidade Aluno
            modelBuilder.Entity<Student>(entity =>
            {
                entity.HasKey(a => a.Id);
                
                // Configuração do Value Object CPF como "propriedade possuída" (Owned Type) ou conversão
                entity.Property(a => a.IdentifierDocument)
                      .HasConversion(
                          vo => vo.Valor, // Conversão de VO para string (DB)
                          valor => new Cpf(valor)) // Conversão de string (DB) para VO
                      .HasColumnName("Cpf")
                      .IsRequired();
                
                // Garante que não haverá duplicidade de CPF
                entity.HasIndex(a => a.IdentifierDocument).IsUnique(); 
            });
            
            base.OnModelCreating(modelBuilder);
        }
    }
}