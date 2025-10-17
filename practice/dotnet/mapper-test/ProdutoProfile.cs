using AutoMapper;

public class ProdutoProfile : Profile
{
    public ProdutoProfile()
    {
        // A sintaxe de mapeamento vai aqui:
        CreateMap<Produto, ProdutoDto>()
           .ForMember(dest => dest.NomeProduto, opt => opt.MapFrom(src => src.Nome))
           .ForMember(dest => dest.VendaFormatada, opt => opt.MapFrom(src => src.DataVenda.ToString("dd/MM/yyyy")));
    }
}