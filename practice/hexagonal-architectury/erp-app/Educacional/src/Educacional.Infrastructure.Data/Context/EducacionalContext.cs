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
            modelBuilder.ApplyConfigurationsFromAssembly(typeof(EducacionalContext).Assembly);
            
            base.OnModelCreating(modelBuilder);
        }
    }
}