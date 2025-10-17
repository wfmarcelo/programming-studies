using AutoMapper;
using automapper_razor.Models;

public class ProductProfile : Profile
{
    public ProductProfile()
    {
        // Mapeamento de Product -> ProductViewModel
        CreateMap<Product, ProductViewModel>()
            // Mapeamento personalizado para NomeProduto
            .ForMember(dest => dest.NomeProduto, 
                       opt => opt.MapFrom(src => src.Name))

            // Mapeamento personalizado para formatação da data
            .ForMember(dest => dest.DataRegistro, 
                       opt => opt.MapFrom(src => src.CreationDate.ToString("dd/MM/yyyy")))
                       
            // Mapeamento personalizado para formatação da moeda
            .ForMember(dest => dest.Price, 
                       opt => opt.MapFrom(src => $"R$ {src.Price:N2}"));
    }
}