using System.Reflection;
using Microsoft.Extensions.DependencyInjection;

namespace Educacional.API.Extensions
{
    public static class ServiceCollectionExtensions
    {
        /// <summary>
        /// Scans the given assembly and registers pairs of interfaces and implementations 
        /// where the interface name starts with 'I' and matches the implementation class name (e.g., IService -> Service).
        /// </summary>
        /// <param name="services">The IServiceCollection instance.</param>
        /// <param name="assembly">The assembly to scan (e.g., Core.Application or Infrastructure.Data).</param>
        public static IServiceCollection RegisterServicesByConvention(this IServiceCollection services, Assembly assembly)
        {
            // 1. Obter todos os tipos (classes e interfaces) no Assembly
            var allTypes = assembly.GetTypes();
            
            // 2. Filtrar interfaces públicas (portas)
            var interfaces = allTypes
                .Where(t => t.IsInterface && t.Name.StartsWith('I') && t.IsPublic);

            foreach (var @interface in interfaces)
            {
                // Nome esperado da implementação (removendo o 'I' inicial)
                string implementationName = @interface.Name.Substring(1); 

                // 3. Encontrar a implementação correspondente
                var implementation = allTypes
                    .FirstOrDefault(t => t.IsClass && !t.IsAbstract && t.Name == implementationName);

                if (implementation != null)
                {
                    // 4. Registrar o par Interface/Implementação como Scoped
                    // Exemplo: IStudentRepository -> StudentRepository
                    services.AddScoped(@interface, implementation);
                    
                    Console.WriteLine($"Registered: {@interface.Name} -> {implementation.Name} (Scoped)");
                }
            }

            return services;
        }
    }
}