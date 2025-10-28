using Educacional.Infrastructure.Data.Repositories; // Usado para obter o assembly de Infra
using Educacional.Core.Application.Services;      // Usado para obter o assembly de Aplicação
using Educacional.API.Extensions;
using Educacional.Infrastructure.Data.Context;
using Microsoft.EntityFrameworkCore;
using Educacional.Core.Application.Mapping;                // O novo método de extensão
// ... (Restante dos usings e configurações)
// ...

var builder = WebApplication.CreateBuilder(args);

// --- Configuração da Infraestrutura (EF Core/SQLite) ---
// ... (Contexto DB e configurações do EF Core/SQLite) ...
// Adicionar o DB Context ainda é manual e necessário.
builder.Services.AddDbContext<EducacionalContext>(options =>
{
    options.UseSqlite(builder.Configuration.GetConnectionString("DefaultConnection") ?? "Data Source=Educacional.db");
});


// --- Configuração do AutoMapper ---
builder.Services.AddAutoMapper(typeof(StudentProfile).Assembly); 


// --- INJEÇÃO DE DEPENDÊNCIA DINÂMICA (O Plug Hexagonal) ---

// 1. Registrar os Adaptadores de Saída (Implementações de Repositórios)
// Usamos qualquer classe do projeto 'Educacional.Infrastructure.Data' para obter o Assembly
builder.Services.RegisterServicesByConvention(typeof(StudentRepository).Assembly);

// 2. Registrar os Adaptadores de Entrada (Implementações dos Serviços de Aplicação)
// Usamos qualquer classe do projeto 'Educacional.Core.Application' para obter o Assembly
builder.Services.RegisterServicesByConvention(typeof(StudentManagementService).Assembly);


// ... (resto da configuração da API) ...