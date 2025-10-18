using AutoMapperApp.Application.Interfaces;
using AutoMapperApp.Application.Services;
using AutoMapperApp.Application.ViewModels;
using AutoMapperApp.Infrastructure.QueryParameters;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace AutoMapperApp.Api.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class ProductsController : ControllerBase
    {
        private readonly IProductService _productService;

        public ProductsController(IProductService productService)
        {
            _productService = productService;
        }

        // GET: api/Products?PageNumber=1&PageSize=5&OrderBy=Name%20desc
        [HttpGet]
        public async Task<ActionResult<PaginatedResponse<ProductListViewModel>>> GetProducts([FromQuery] ProductQueryParameters queryParameters)
        {
            var pagedProducts = await _productService.GetAllProductsList(queryParameters);
            return Ok(new PaginatedResponse<ProductListViewModel>(pagedProducts));
        }

        // GET: api/Products/{id}
        [HttpGet("{id}")]
        public async Task<ActionResult<ProductDetailViewModel>> GetProduct(int id)
        {
            var product = await _productService.GetProductDetails(id);

            if (product == null)
            {
                return NotFound();
            }

            return Ok(product);
        }

        // PUT: api/Products/{id}
        [HttpPut("{id}")]
        public async Task<IActionResult> PutProduct(int id, ProductDetailViewModel productViewModel)
        {
            if (id != productViewModel.Id)
            {
                return BadRequest("Product ID in URL does not match ID in body.");
            }

            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            try
            {
                await _productService.UpdateProduct(productViewModel);
            }
            catch (System.Exception)
            {
                return NotFound();
            }

            return NoContent();
        }

        // NOVO ENDPOINT: Criar um novo produto
        [HttpPost]
        public async Task<ActionResult<ProductDetailViewModel>> AddProduct([FromBody] ProductDetailViewModel model)
        {
            // O ID não deve ser fornecido para um novo produto
            if (model.Id != 0)
            {
                return BadRequest("Do not provide an ID for a new product.");
            }

            // Você pode adicionar validação aqui se necessário
            // if (!ModelState.IsValid) return BadRequest(ModelState);

            var createdProduct = await _productService.AddProduct(model);

            // Retorna 201 Created e um cabeçalho Location apontando para o novo recurso
            // CORREÇÃO AQUI: Usar nameof(GetProduct) em vez de nameof(GetProductDetails)
            return CreatedAtAction(nameof(GetProduct), new { id = createdProduct.Id }, createdProduct);
        }

        // NOVO ENDPOINT: Excluir um produto
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteProduct(int id)
        {
            var deleted = await _productService.DeleteProduct(id);
            if (!deleted)
            {
                return NotFound(); // Retorna 404 se o produto não for encontrado
            }
            return NoContent(); // Retorna 204 No Content para exclusão bem-sucedida
        }
    }
}