using System.Reflection;
using AutoMapper;
using Microsoft.Extensions.Logging;

class Program
{
    private static IMapper _mapper;

    static void Main(string[] args)
    {

        // Crie um LoggerFactory básico para satisfazer o construtor
        using var loggerFactory = LoggerFactory.Create(builder =>
        {
            builder.AddConsole();
            builder.SetMinimumLevel(LogLevel.Warning); // Configura o nível mínimo de log
        });
        
        // 1. Configurar o Mapeamento, passando o loggerFactory como segundo argumento
        var mapperConfiguration = new MapperConfiguration(cfg =>
        {
            // Adiciona todos os Profiles encontrados no Assembly atual
            cfg.AddMaps(Assembly.GetExecutingAssembly());
        }, loggerFactory); // <--- AQUI ESTÁ O NOVO ARGUMENTO

        // Opcional: Verifica a validade da configuração
        mapperConfiguration.AssertConfigurationIsValid();
      

        // 2. Criar e armazenar a instância do IMapper
        _mapper = mapperConfiguration.CreateMapper();
        // 3. Uso do Mapper
        var produto = new Produto
        {
            Id = 1,
            Nome = "Teclado Mecânico",
            Preco = 450.00m,
            DataVenda = new DateTime(2025, 10, 17)
        };

        // Realiza o mapeamento
        ProdutoDto produtoDto = _mapper.Map<ProdutoDto>(produto);

        Console.WriteLine($"Nome Original: {produto.Nome}");
        Console.WriteLine($"Nome Mapeado: {produtoDto.NomeProduto}");
        Console.WriteLine($"Preço: {produtoDto.Preco:C}");
        Console.WriteLine($"Data Formatada: {produtoDto.VendaFormatada}");
    }
}