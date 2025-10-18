using AutoMapper;
using AutoMapperApp.Application.Interfaces;
using AutoMapperApp.Application.ViewModels;
using AutoMapperApp.Domain.Entities;
using AutoMapperApp.Infrastructure.Interfaces;
using AutoMapperApp.Infrastructure.QueryParameters;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System;

namespace AutoMapperApp.Application.Services
{
    public class ProductService : IProductService
    {
        private readonly IMapper _mapper;
        private readonly IProductRepository _productRepository;
        private readonly IPagedListFactory _pagedListFactory;

        public ProductService(IMapper mapper, IProductRepository productRepository, IPagedListFactory pagedListFactory)
        {
            _mapper = mapper;
            _productRepository = productRepository;
            _pagedListFactory = pagedListFactory;
        }

        public async Task<ProductDetailViewModel> GetProductDetails(int id)
        {
            var product = await _productRepository.GetByIdAsync(id);
            return _mapper.Map<ProductDetailViewModel>(product);
        }

        public async Task<PagedList<ProductListViewModel>> GetAllProductsList(ProductQueryParameters queryParameters)
        {
            var productsQuery = await _productRepository.GetAllAsync(queryParameters);
            var pagedProducts = await _pagedListFactory.CreateAsync(productsQuery, queryParameters.PageNumber, queryParameters.PageSize);
            var productListViewModels = _mapper.Map<List<ProductListViewModel>>(pagedProducts);

            return new PagedList<ProductListViewModel>(
                productListViewModels,
                pagedProducts.TotalCount,
                pagedProducts.CurrentPage,
                pagedProducts.PageSize
            );
        }

        // CORREÇÃO AQUI: Carregar a entidade existente e mapear as mudanças para ela
        public async Task UpdateProduct(ProductDetailViewModel model)
        {
            // 1. Carregar a entidade existente do banco de dados
            var existingProduct = await _productRepository.GetByIdAsync(model.Id);

            if (existingProduct == null)
            {
                // Lidar com o caso em que o produto não é encontrado
                // Você pode lançar uma exceção, retornar um valor booleano, etc.
                // Para este exemplo, vamos lançar uma exceção.
                throw new InvalidOperationException($"Product with ID {model.Id} not found for update.");
            }

            // 2. Mapear as propriedades do ViewModel para a entidade existente
            // O AutoMapper, com opt.Ignore() para CreationDate, não sobrescreverá a data original.
            _mapper.Map(model, existingProduct);

            // 3. Salvar a entidade modificada de volta no repositório
            await _productRepository.UpdateAsync(existingProduct);
        }

        public async Task<ProductDetailViewModel> AddProduct(ProductDetailViewModel model)
        {
            var productEntity = _mapper.Map<Product>(model);
            productEntity.CreationDate = DateTime.Now;
            await _productRepository.AddAsync(productEntity);
            return _mapper.Map<ProductDetailViewModel>(productEntity);
        }

        public async Task<bool> DeleteProduct(int id)
        {
            var productExists = await _productRepository.ExistsAsync(id);
            if (!productExists)
            {
                return false;
            }

            await _productRepository.DeleteAsync(id);
            return true;
        }
    }
}