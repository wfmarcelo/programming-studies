using Educacional.Core.Domain.Entities;
using Educacional.Core.Domain.ValueObjects;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Educacional.Infrastructure.Data.Configurations
{
    // A classe implementa a interface de configuração para a Entidade Student
    public class StudentConfiguration : IEntityTypeConfiguration<Student>
    {
        public void Configure(EntityTypeBuilder<Student> builder)
        {
            // 1. Chave Primária
            builder.HasKey(s => s.Id);
            
            // O Id será gerado pela aplicação (DDD) e não pelo banco de dados.
            builder.Property(s => s.Id)
                   .ValueGeneratedNever();

            // 2. Propriedades Simples
            builder.Property(s => s.Name)
                   .IsRequired()
                   .HasMaxLength(250);

            builder.Property(s => s.Registration)
                   .IsRequired()
                   .HasMaxLength(50);
            
            // 3. Configuração do Value Object CPF
            // O EF Core deve saber como converter o Value Object (Cpf) para um tipo de coluna (string)
            builder.Property(s => s.IdentifierDocument)
                   .HasConversion(
                       vo => vo.Valor,      // Converte Cpf para string (para o DB)
                       valor => new Cpf(valor)) // Converte string para Cpf (vindo do DB)
                   .HasColumnName("Cpf") // Nome da coluna no DB
                   .IsRequired();
            
            // 4. Índice de Unicidade
            // Garante que não haverá duplicidade de CPF (regra de domínio/persistência)
            builder.HasIndex(s => s.IdentifierDocument).IsUnique();
            
            // 5. Mapeamento de Tabela (Opcional, se o nome for diferente da Entidade)
            builder.ToTable("Students");
        }
    }
}