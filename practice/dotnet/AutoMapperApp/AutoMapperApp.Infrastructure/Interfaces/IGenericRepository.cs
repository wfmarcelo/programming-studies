using System.Linq;
using System.Threading.Tasks;
using AutoMapperApp.Infrastructure.QueryParameters;

namespace AutoMapperApp.Infrastructure.Interfaces
{
    public interface IGenericRepository<TEntity, TQueryParameters>
        where TEntity : class
        where TQueryParameters : BaseQueryParameters
    {
        Task<IQueryable<TEntity>> GetAllAsync(TQueryParameters queryParameters);
        Task<TEntity?> GetByIdAsync(int id);
        // Outros métodos CRUD genéricos podem ser adicionados aqui
        Task AddAsync(TEntity entity);
        Task UpdateAsync(TEntity entity);
        Task DeleteAsync(int id); // Ou DeleteAsync(TEntity entity)
    }
}