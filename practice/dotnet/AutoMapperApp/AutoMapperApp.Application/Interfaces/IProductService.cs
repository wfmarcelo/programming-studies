using AutoMapperApp.Application.ViewModels;
using AutoMapperApp.Infrastructure.QueryParameters;
using System.Threading.Tasks;

namespace AutoMapperApp.Application.Interfaces
{
    public interface IProductService
    {
        Task<ProductDetailViewModel> GetProductDetails(int id);
        Task<PagedList<ProductListViewModel>> GetAllProductsList(ProductQueryParameters queryParameters);
        Task UpdateProduct(ProductDetailViewModel model);
        Task<ProductDetailViewModel> AddProduct(ProductDetailViewModel model);
        Task<bool> DeleteProduct(int id); // NOVO MÉTODO: Retorna true se excluído, false se não encontrado
    }
}