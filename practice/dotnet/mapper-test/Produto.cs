// Classe de Domínio/Origem
public class Produto
{
    public int Id { get; set; }
    public string Nome { get; set; }
    public decimal Preco { get; set; }
    public DateTime DataVenda { get; set; }
}

// Classe DTO/Destino
public class ProdutoDto
{
    public string NomeProduto { get; set; } // Nome de propriedade diferente
    public decimal Preco { get; set; }
    public string VendaFormatada { get; set; } // Propriedade formatada
}