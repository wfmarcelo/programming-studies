using AutoMapper;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using automapper_razor.Models;

namespace automapper_razor.Pages;

public class IndexModel : PageModel
{
    private readonly ILogger<IndexModel> _logger;
    private readonly IMapper _mapper;

    public IndexModel(
        ILogger<IndexModel> logger,
        IMapper mapper

            )
    {
        _logger = logger;
        _mapper = mapper;
    }

    // Propriedade para exibir o resultado na página Razor
    public ProductViewModel MappedProduct { get; set; } = new ProductViewModel();

    public void OnGet()
    {
        var productEntity = new Product
        {
            Id = 101,
            Name = "Mouse Gamer X-Pro",
            Price = 199.99m,
            CreationDate = DateTime.Now
        };

        MappedProduct = _mapper.Map<ProductViewModel>(productEntity);

    }
}
