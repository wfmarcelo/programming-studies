// filepath: /home/marcelo/Projetos/pessoal/programming-studies/practice/dotnet/AutoMapperApp/AutoMapperApp.UnitTests/ProductServiceTests.cs
using Xunit;
using Moq;
using AutoMapper;
using AutoMapperApp.Application.Services;
using AutoMapperApp.Application.ViewModels;
using AutoMapperApp.Domain.Entities;
using AutoMapperApp.Infrastructure.Interfaces;
using AutoMapperApp.Infrastructure.QueryParameters;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System;
using AutoMapperApp.Application.Interfaces; // Adicione esta linha

namespace AutoMapperApp.UnitTests
{
    public class ProductServiceTests
    {
        private readonly Mock<IMapper> _mockMapper;
        private readonly Mock<IProductRepository> _mockProductRepository;
        private readonly Mock<IPagedListFactory> _mockPagedListFactory; // Adicione esta linha
        private readonly ProductService _productService;

        public ProductServiceTests()
        {
            _mockMapper = new Mock<IMapper>();
            _mockProductRepository = new Mock<IProductRepository>();
            _mockPagedListFactory = new Mock<IPagedListFactory>(); // Inicialize
            _productService = new ProductService(_mockMapper.Object, _mockProductRepository.Object, _mockPagedListFactory.Object); // Passe para o construtor
        }

        [Fact]
        public async Task GetProductDetails_ShouldReturnProductDetailViewModel_WhenProductExists()
        {
            // Arrange
            int productId = 1;
            var productEntity = new Product { Id = productId, Name = "Test Product", Price = 100m, CreationDate = DateTime.Now };
            var productDetailViewModel = new ProductDetailViewModel
            {
                Id = productId,
                NomeProduto = "Test Product",
                Price = "100.00",
                DataRegistro = DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss")
            };

            _mockProductRepository.Setup(repo => repo.GetByIdAsync(productId))
                                  .ReturnsAsync(productEntity);
            _mockMapper.Setup(mapper => mapper.Map<ProductDetailViewModel>(productEntity))
                       .Returns(productDetailViewModel);

            // Act
            var result = await _productService.GetProductDetails(productId);

            // Assert
            Assert.NotNull(result);
            Assert.Equal(productId, result.Id);
            Assert.Equal("Test Product", result.NomeProduto);
            Assert.Equal("100.00", result.Price);
            _mockProductRepository.Verify(repo => repo.GetByIdAsync(productId), Times.Once);
            _mockMapper.Verify(mapper => mapper.Map<ProductDetailViewModel>(productEntity), Times.Once);
        }

        [Fact]
        public async Task GetProductDetails_ShouldReturnNull_WhenProductDoesNotExist()
        {
            // Arrange
            int productId = 99;
            _mockProductRepository.Setup(repo => repo.GetByIdAsync(productId))
                                  .ReturnsAsync((Product)null);
            _mockMapper.Setup(mapper => mapper.Map<ProductDetailViewModel>(It.IsAny<Product>()))
                       .Returns((ProductDetailViewModel)null);

            // Act
            var result = await _productService.GetProductDetails(productId);

            // Assert
            Assert.Null(result);
            _mockProductRepository.Verify(repo => repo.GetByIdAsync(productId), Times.Once);
            _mockMapper.Verify(mapper => mapper.Map<ProductDetailViewModel>(It.IsAny<Product>()), Times.Once);
        }

        [Fact]
        public async Task GetAllProductsList_ShouldReturnPagedList_WithCorrectDataAndMetadata()
        {
            // Arrange
            var queryParameters = new ProductQueryParameters { PageNumber = 1, PageSize = 2 };
            var productEntities = new List<Product>
            {
                new Product { Id = 1, Name = "Product A", Price = 10m, CreationDate = DateTime.Now },
                new Product { Id = 2, Name = "Product B", Price = 20m, CreationDate = DateTime.Now },
                new Product { Id = 3, Name = "Product C", Price = 30m, CreationDate = DateTime.Now }
            };
            var productListViewModels = new List<ProductListViewModel>
            {
                new ProductListViewModel { Id = 1, Name = "Product A", Price = "10.00" },
                new ProductListViewModel { Id = 2, Name = "Product B", Price = "20.00" }
            };

            // Mock do repositório para retornar um IQueryable simples (não precisa de BuildMock agora)
            _mockProductRepository.Setup(repo => repo.GetAllAsync(queryParameters))
                                  .ReturnsAsync(productEntities.AsQueryable());

            // Mock da fábrica de PagedList para retornar um PagedList síncrono
            // Usamos o método Create síncrono da nossa PagedListFactory para simular a paginação
            _mockPagedListFactory.Setup(factory => factory.CreateAsync(
                                      It.IsAny<IQueryable<Product>>(),
                                      queryParameters.PageNumber,
                                      queryParameters.PageSize))
                                 .ReturnsAsync(new PagedList<Product>(
                                     productEntities.Skip((queryParameters.PageNumber - 1) * queryParameters.PageSize).Take(queryParameters.PageSize).ToList(),
                                     productEntities.Count,
                                     queryParameters.PageNumber,
                                     queryParameters.PageSize));

            // Mock do mapper para mapear a lista de entidades paginadas para a lista de ViewModels
            _mockMapper.Setup(mapper => mapper.Map<List<ProductListViewModel>>(It.IsAny<List<Product>>()))
                       .Returns(productListViewModels);

            // Act
            var result = await _productService.GetAllProductsList(queryParameters);

            // Assert
            Assert.NotNull(result);
            Assert.Equal(2, result.Count);
            Assert.Equal(3, result.TotalCount);
            Assert.Equal(2, result.TotalPages);
            Assert.Equal(1, result.CurrentPage);
            Assert.False(result.HasPrevious);
            Assert.True(result.HasNext);
            Assert.Equal("Product A", result.First().Name);
            Assert.Equal("10.00", result.First().Price);

            _mockProductRepository.Verify(repo => repo.GetAllAsync(queryParameters), Times.Once);
            _mockPagedListFactory.Verify(factory => factory.CreateAsync(
                                      It.IsAny<IQueryable<Product>>(),
                                      queryParameters.PageNumber,
                                      queryParameters.PageSize), Times.Once);
            _mockMapper.Verify(mapper => mapper.Map<List<ProductListViewModel>>(It.IsAny<List<Product>>()), Times.Once);
        }

        [Fact]
        public async Task UpdateProduct_ShouldCallRepositoryUpdate_WhenModelIsValid()
        {
            // Arrange
            var productDetailViewModel = new ProductDetailViewModel
            {
                Id = 1,
                NomeProduto = "Updated Product",
                Price = "150.00",
                DataRegistro = DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss")
            };
            var productEntity = new Product { Id = 1, Name = "Updated Product", Price = 150m, CreationDate = DateTime.Now };

            _mockMapper.Setup(mapper => mapper.Map<Product>(productDetailViewModel))
                       .Returns(productEntity);
            _mockProductRepository.Setup(repo => repo.UpdateAsync(productEntity))
                                  .Returns(Task.CompletedTask);

            // Act
            await _productService.UpdateProduct(productDetailViewModel);

            // Assert
            _mockMapper.Verify(mapper => mapper.Map<Product>(productDetailViewModel), Times.Once);
            _mockProductRepository.Verify(repo => repo.UpdateAsync(productEntity), Times.Once);
        }

        [Fact]
        public async Task AddProduct_ShouldCallRepositoryAdd_AndReturnViewModelWithId()
        {
            // Arrange
            var productDetailViewModel = new ProductDetailViewModel
            {
                // Id não é fornecido para um novo produto, será gerado pelo repositório/BD
                NomeProduto = "New Product",
                Price = "250.00",
                DataRegistro = DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss") // Pode ser ignorado ou redefinido no serviço
            };

            var productEntity = new Product
            {
                // Id será 0 antes de ser adicionado, e 1 após (simulando geração de ID)
                Name = "New Product",
                Price = 250m,
                CreationDate = DateTime.Now
            };

            // Configura o mapper para mapear do ViewModel para a Entidade
            _mockMapper.Setup(mapper => mapper.Map<Product>(productDetailViewModel))
                       .Returns(productEntity);

            // Configura o repositório para simular a adição e a geração de ID
            _mockProductRepository.Setup(repo => repo.AddAsync(It.IsAny<Product>()))
                                  .Callback<Product>(p => p.Id = 1) // Simula que o repositório atribui um ID
                                  .Returns(Task.CompletedTask);

            // Configura o mapper para mapear da Entidade (com ID) de volta para o ViewModel
            _mockMapper.Setup(mapper => mapper.Map<ProductDetailViewModel>(It.Is<Product>(p => p.Id == 1)))
                       .Returns(new ProductDetailViewModel
                       {
                           Id = 1, // O ID gerado
                           NomeProduto = "New Product",
                           Price = "250.00",
                           DataRegistro = DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss")
                       });

            // Act
            var result = await _productService.AddProduct(productDetailViewModel);

            // Assert
            Assert.NotNull(result);
            Assert.Equal(1, result.Id); // Verifica se o ID foi atribuído
            Assert.Equal("New Product", result.NomeProduto);
            Assert.Equal("250.00", result.Price);

            _mockMapper.Verify(mapper => mapper.Map<Product>(productDetailViewModel), Times.Once);
            _mockProductRepository.Verify(repo => repo.AddAsync(It.IsAny<Product>()), Times.Once);
            _mockMapper.Verify(mapper => mapper.Map<ProductDetailViewModel>(It.Is<Product>(p => p.Id == 1)), Times.Once);
        }

        [Fact]
        public async Task DeleteProduct_ShouldCallRepositoryDelete_WhenProductExists()
        {
            // Arrange
            int productId = 1;
            _mockProductRepository.Setup(repo => repo.ExistsAsync(productId))
                                  .ReturnsAsync(true); // Simula que o produto existe
            _mockProductRepository.Setup(repo => repo.DeleteAsync(productId))
                                  .Returns(Task.CompletedTask); // Simula a exclusão

            // Act
            var result = await _productService.DeleteProduct(productId);

            // Assert
            Assert.True(result); // Espera que a exclusão seja bem-sucedida
            _mockProductRepository.Verify(repo => repo.ExistsAsync(productId), Times.Once);
            _mockProductRepository.Verify(repo => repo.DeleteAsync(productId), Times.Once);
        }

        [Fact]
        public async Task DeleteProduct_ShouldReturnFalse_WhenProductDoesNotExist()
        {
            // Arrange
            int productId = 99;
            _mockProductRepository.Setup(repo => repo.ExistsAsync(productId))
                                  .ReturnsAsync(false); // Simula que o produto NÃO existe
            _mockProductRepository.Setup(repo => repo.DeleteAsync(productId))
                                  .Returns(Task.CompletedTask); // Não deve ser chamado

            // Act
            var result = await _productService.DeleteProduct(productId);

            // Assert
            Assert.False(result); // Espera que a exclusão falhe (produto não encontrado)
            _mockProductRepository.Verify(repo => repo.ExistsAsync(productId), Times.Once);
            _mockProductRepository.Verify(repo => repo.DeleteAsync(productId), Times.Never); // Verifica que DeleteAsync não foi chamado
        }
    }
}