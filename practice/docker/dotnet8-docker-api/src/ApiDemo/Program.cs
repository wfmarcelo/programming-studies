using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Hosting;

var builder = WebApplication.CreateBuilder(args);

// Leitura de variáveis de ambiente (já vem habilitado por padrão no .NET)
var connection = builder.Configuration["ConnectionStrings:Default"]; // use __ no .env
var apiKey = builder.Configuration["API_KEY"];

builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Swagger em Development
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

// Endpoints
app.MapGet("/", () => Results.Ok(new
{
    message = "API .NET 8 rodando! 🚀",
    environment = app.Environment.EnvironmentName,
    connectionString = string.IsNullOrWhiteSpace(connection) ? "(não definida)" : "(definida)",
    apiKey = string.IsNullOrWhiteSpace(apiKey) ? "(não definida)" : "(definida)"
}));

// CRUD simples em memória
var todos = new List<Todo>
{
    new (1, "Aprender Docker", false),
    new (2, "Criar API .NET 8", true)
};

app.MapGet("/todos", () => Results.Ok(todos));
app.MapGet("/todos/{id:int}", (int id) =>
{
    var todo = todos.FirstOrDefault(t => t.Id == id);
    return todo is null ? Results.NotFound() : Results.Ok(todo);
});
app.MapPost("/todos", (Todo todo) =>
{
    var nextId = todos.Count == 0 ? 1 : todos.Max(t => t.Id) + 1;
    var novo = todo with { Id = nextId };
    todos.Add(novo);
    return Results.Created($"/todos/{novo.Id}", novo);
});
app.MapPut("/todos/{id:int}", (int id, Todo update) =>
{
    var idx = todos.FindIndex(t => t.Id == id);
    if (idx == -1) return Results.NotFound();
    todos[idx] = update with { Id = id };
    return Results.NoContent();
});
app.MapDelete("/todos/{id:int}", (int id) =>
{
    var removed = todos.RemoveAll(t => t.Id == id) > 0;
    return removed ? Results.NoContent() : Results.NotFound();
});

// Ouvir em 0.0.0.0:8080 (útil p/ container)
app.Urls.Add("http://0.0.0.0:8080");
app.Run();

// ===== Tipos (devem vir depois dos top-level statements) =====
public record Todo(int Id, string Title, bool Done);