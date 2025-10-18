namespace AutoMapperApp.Application.ViewModels
{
    public class ProductListViewModel
    {
        public int Id { get; set; }
        public string Name { get; set; } // Mapeamento direto por convenção
        public string Price { get; set; } // Formatado
    }
}