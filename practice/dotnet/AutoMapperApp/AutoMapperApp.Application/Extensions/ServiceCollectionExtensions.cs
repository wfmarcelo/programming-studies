using AutoMapperApp.Application.Interfaces;
using AutoMapperApp.Application.Services;
using Microsoft.Extensions.DependencyInjection;
using AutoMapperApp.Application.MappingProfiles;
using AutoMapperApp.Infrastructure.DependencyInjection; // Mantenha esta linha
using Microsoft.Extensions.Configuration; // Mantenha esta linha

namespace AutoMapperApp.Application.Extensions
{
    public static class ServiceCollectionExtensions
    {
        public static IServiceCollection AddApplicationServices(this IServiceCollection services, IConfiguration configuration)
        {
            services.AddAutoMapper(typeof(ProductProfile).Assembly); // Usando ProductProfile.Assembly para o AutoMapper
            services.AddScoped<IProductService, ProductService>();
            services.AddScoped<IPagedListFactory, PagedListFactory>(); // Adicione o registro da fábrica de PagedList

            // Mantenha esta chamada para registrar os serviços de infraestrutura
            services.AddInfrastructureServices(configuration);

            return services;
        }
    }
}