using AutoMapper;
using AutoMapperApp.Domain.Entities; 
using AutoMapperApp.Application.ViewModels;


namespace AutoMapperApp.Application.Services
{
    public class ProductService : IProductService
    {
        private readonly IMapper _mapper;

        public ProductService(IMapper mapper)
        {
            _mapper = mapper;
        }

        public ProductViewModel GetProductById(int id)
        {
            // Simulação de busca no banco de dados
            var productEntity = new Product 
            {
                Id = 101,
                Name = "Monitor UltraWide",
                Price = 1450.50m,
                CreationDate = DateTime.Now
            }; 
            
            // Usa o IMapper injetado
            return _mapper.Map<ProductViewModel>(productEntity);
        }
    }
}