using AutoMapperApp.Domain.Entities;
using AutoMapperApp.Infrastructure.QueryParameters;
using System.Linq;
using System.Threading.Tasks;

namespace AutoMapperApp.Infrastructure.Interfaces
{
    public interface IProductRepository
    {
        Task<Product> GetByIdAsync(int id);
        Task<IQueryable<Product>> GetAllAsync(ProductQueryParameters queryParameters);
        Task AddAsync(Product entity);
        Task UpdateAsync(Product entity);
        Task DeleteAsync(int id); // NOVO MÉTODO
        Task<bool> ExistsAsync(int id); // Pode ser útil para verificar antes de deletar
    }
}