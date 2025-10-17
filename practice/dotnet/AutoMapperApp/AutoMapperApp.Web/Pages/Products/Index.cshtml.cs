using Microsoft.AspNetCore.Mvc.RazorPages;
using AutoMapperApp.Application.Services;      // Para a interface IProductService
using AutoMapperApp.Application.ViewModels;  // Para o ProductViewModel

namespace AutoMapperApp.Web.Pages.Products
{
    // O PageModel é responsável por coordenar a lógica da página
    public class IndexModel : PageModel
    {
        // Campo privado somente leitura para armazenar a instância do serviço
        private readonly IProductService _productService;

        // Propriedade pública que armazena o ViewModel para uso na View (.cshtml)
        // O default! é usado para dizer ao compilador que será inicializado no OnGet
        public ProductViewModel MappedProduct { get; set; } = default!;

        // 1. Injeção de Dependência via Construtor
        // O ASP.NET Core DI fornece a instância de ProductService (registrada no Program.cs)
        public IndexModel(IProductService productService)
        {
            _productService = productService;
        }

        // 2. Handler Method (Executado quando a página é acessada via HTTP GET)
        public void OnGet()
        {
            // O PageModel APENAS delega a busca e o mapeamento para o Serviço.
            // O resultado já é o ProductViewModel, limpo e formatado pelo AutoMapper.
            MappedProduct = _productService.GetProductById(101);
        }
        
        // Se fosse um formulário de edição, haveria um método OnPost()
        // public IActionResult OnPost() { ... }
    }
}