using AutoMapperApp.Application.ViewModels;
using System.Linq;
using System.Threading.Tasks;

namespace AutoMapperApp.Application.Interfaces
{
    public interface IPagedListFactory
    {
        // Método para criar PagedList a partir de IQueryable (para uso em produção com EF Core)
        Task<PagedList<T>> CreateAsync<T>(IQueryable<T> source, int pageNumber, int pageSize) where T : class;

        // Método para criar PagedList a partir de IEnumerable (para uso em testes ou dados em memória)
        PagedList<T> Create<T>(IEnumerable<T> source, int pageNumber, int pageSize) where T : class;
    }
}