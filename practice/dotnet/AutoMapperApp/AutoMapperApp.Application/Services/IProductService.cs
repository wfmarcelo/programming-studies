using AutoMapperApp.Application.ViewModels;

namespace AutoMapperApp.Application.Services
{
    public interface IProductService
    {
        ProductDetailViewModel GetProductDetails(int id);
        List<ProductListViewModel> GetAllProductsList();
        void UpdateProduct(ProductDetailViewModel model); // Changed to ProductDetailViewModel
    }
}