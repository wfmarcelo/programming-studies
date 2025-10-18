using AutoMapper;
using AutoMapperApp.Domain.Entities;
using AutoMapperApp.Application.ViewModels;

namespace AutoMapperApp.Application.Services
{
    public class ProductService : IProductService
    {
        private readonly IMapper _mapper;
        private readonly List<Product> _products; // Store products in memory

        public ProductService(IMapper mapper)
        {
            _mapper = mapper;
            _products = GetListFromDatabase(); // Initialize products
        }

        public ProductDetailViewModel GetProductDetails(int id)
        {
            var product = GetProductFromDatabase(id);
            return _mapper.Map<ProductDetailViewModel>(product);
        }

        private Product GetProductFromDatabase(int id)
        {
            // Find the product in the list based on the ID
            var product = _products.FirstOrDefault(p => p.Id == id);
            return product;
        }

        public List<ProductListViewModel> GetAllProductsList()
        {
            return _mapper.Map<List<ProductListViewModel>>(_products);
        }

        private List<Product> GetListFromDatabase()
        {
            // Generate 3 more random items
            return new List<Product>
            {
                new Product { Id = 101, Name = "Monitor UltraWide", Price = 1450.50m, CreationDate = DateTime.Now },
                new Product { Id = 102, Name = "Teclado Mecânico", Price = 250.50m, CreationDate = DateTime.Now },
                new Product { Id = 103, Name = "Mouse Gamer", Price = 120.00m, CreationDate = DateTime.Now },
                new Product { Id = 104, Name = "Headset Bluetooth", Price = 300.00m, CreationDate = DateTime.Now },
                new Product { Id = 105, Name = "Webcam 4K", Price = 450.00m, CreationDate = DateTime.Now }
            };
        }

        public void UpdateProduct(ProductDetailViewModel model)
        {
            // 1. Mapeia o ViewModel (Origem) de volta para a Entidade (Destino)
            var productEntity = _mapper.Map<Product>(model);

            // 2. Salva a entidade atualizada no banco (Simulação)
            SaveProductToDatabase(productEntity);
        }

        private void SaveProductToDatabase(Product productEntity)
        {
            throw new NotImplementedException();
        }
    }
}