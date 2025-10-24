var builder = WebApplication.CreateBuilder(args);

// Adiciona serviços ao contêiner.
// O Environment é lido automaticamente de várias fontes, incluindo variáveis de ambiente (como as do .env via docker-compose)
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configura o pipeline de requisição HTTP.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

// Endpoint de Teste Básico
app.MapGet("/", () => "Minha API .NET 8.0 está rodando!");

// Endpoint para testar a leitura da variável de ambiente (do .env)
app.MapGet("/config", (IConfiguration config) =>
{
    // A variável que esperamos vir do arquivo .env via docker-compose
    var secretKey = config["MinhaApi:SecretKey"] ?? "Valor Não Encontrado (Erro)";
    
    return Results.Ok(new 
    {
        Environment = app.Environment.EnvironmentName,
        Message = "Configuração lida com sucesso.",
        SecretKeyFromEnv = secretKey
    });
})
.WithName("GetConfigurationTest")
.WithOpenApi();

app.Run();