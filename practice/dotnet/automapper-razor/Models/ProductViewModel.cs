namespace automapper_razor.Models
{
    public class ProductViewModel
    {
        // Notice the different property name (DataRegistro)
        public string DataRegistro { get; set; } 
        
        // Notice the different property name (NomeProduto)
        public string NomeProduto { get; set; } 
        
        public string Price { get; set; } // String to format the currency
    }
}