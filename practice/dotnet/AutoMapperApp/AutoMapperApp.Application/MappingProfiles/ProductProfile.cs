using AutoMapper;
using AutoMapperApp.Domain.Entities; 
using AutoMapperApp.Application.ViewModels;

namespace AutoMapperApp.Application.MappingProfiles 
{
    // O namespace precisa ser único para o escaneamento do AutoMapper
    public class ProductProfile : Profile
    {
        public ProductProfile()
        {
            CreateMap<Product, ProductViewModel>()
                .ForMember(dest => dest.NomeProduto, 
                           opt => opt.MapFrom(src => src.Name))
                .ForMember(dest => dest.DataRegistro, 
                           opt => opt.MapFrom(src => src.CreationDate.ToString("dd/MM/yyyy")))
                .ForMember(dest => dest.Price, 
                           opt => opt.MapFrom(src => $"R$ {src.Price:N2}"));
        }
    }
}