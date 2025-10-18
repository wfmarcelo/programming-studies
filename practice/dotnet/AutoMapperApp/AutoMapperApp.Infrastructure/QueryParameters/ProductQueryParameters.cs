namespace AutoMapperApp.Infrastructure.QueryParameters
{
    public class ProductQueryParameters : BaseQueryParameters // Herda de BaseQueryParameters
    {
        // Propriedades específicas de filtro para Produto
        public int? Id { get; set; }
        public string? Name { get; set; }
    }
}