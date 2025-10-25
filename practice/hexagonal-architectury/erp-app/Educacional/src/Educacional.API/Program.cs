// Educacional.API/Program.cs (Exemplo de como ficaria a configuração)
using Educacional.Core.Application.Ports.Inbound;
using Educacional.Core.Application.Services;
using Educacional.Infrastructure.Data.Repositories;
using Educacional.Infrastructure.Data.Context;
using Microsoft.EntityFrameworkCore;
using Educacional.Core.Domain.Ports.Outbound;

var builder = WebApplication.CreateBuilder(args);

// --- Configuração da Infraestrutura (EF Core/SQLite) ---
builder.Services.AddDbContext<EducacionalContext>(options =>
{
    // O nome do arquivo SQLite será 'Educacional.db'
    options.UseSqlite(builder.Configuration.GetConnectionString("DefaultConnection") ?? "Data Source=Educacional.db");
});

// --- Injeção de Dependência (O Plug Hexagonal) ---

// 1. Porta de Saída (Outbound Port) implementada pelo Adaptador de Infraestrutura
builder.Services.AddScoped<IStudentRepository, StudentRepository>();

// 2. Porta de Entrada (Inbound Port) implementada pelo Serviço de Aplicação
builder.Services.AddScoped<IStudentManagementService, StudentManagementService>();

// Adicionar Controladores e outros serviços...
builder.Services.AddControllers();
// ... resto da configuração da API ...

var app = builder.Build();

// --- Migrações do Banco de Dados (Para garantir que o DB exista) ---
using (var scope = app.Services.CreateScope())
{
    var db = scope.ServiceProvider.GetRequiredService<EducacionalContext>();
    db.Database.Migrate();
}

// ... mapeamento de controladores e execução ...
app.MapControllers();
app.Run();