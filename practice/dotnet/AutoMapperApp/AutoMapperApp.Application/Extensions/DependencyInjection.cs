using Microsoft.Extensions.DependencyInjection;
using AutoMapperApp.Application.Services;

namespace AutoMapperApp.Application.Extensions
{
    // Classe estática para métodos de extensão (boa prática)
    public static class DependencyInjection
    {
        // O método de extensão recebe IServiceCollection
        public static IServiceCollection AddApplicationServices(
            this IServiceCollection services)
        {
            // 1. Registra os serviços da aplicação
            services.AddScoped<IProductService, ProductService>();
            // services.AddScoped<IOrderService, OrderService>(); // Adicione outros serviços aqui
            
            // 2. Registra o AutoMapper (pode ser movido para cá para limpar o Program.cs)
            // Registra a si mesmo para escanear os perfis
            services.AddAutoMapper(typeof(DependencyInjection).Assembly); 
            
            // Retorna o IServiceCollection para permitir encadeamento de métodos
            return services;
        }
    }
}