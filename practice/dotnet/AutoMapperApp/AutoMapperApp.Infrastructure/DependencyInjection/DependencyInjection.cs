// filepath: /home/marcelo/Projetos/pessoal/programming-studies/practice/dotnet/AutoMapperApp/AutoMapperApp.Infrastructure/DependencyInjection/DependencyInjection.cs
using AutoMapperApp.Infrastructure.Interfaces; // Changed using directive
using AutoMapperApp.Infrastructure.Data;
using AutoMapperApp.Infrastructure.Repositories;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace AutoMapperApp.Infrastructure.DependencyInjection
{
    public static class DependencyInjection
    {
        public static IServiceCollection AddInfrastructureServices(this IServiceCollection services, IConfiguration configuration)
        {
            services.AddDbContext<ApplicationDbContext>(options =>
                options.UseSqlite(configuration.GetConnectionString("DefaultConnection")));

            services.AddScoped<IProductRepository, ProductRepository>();

            return services;
        }
    }
}