using AutoMapper;
using AutoMapperApp.Application.ViewModels;
using AutoMapperApp.Domain.Entities;
using System.Globalization;

namespace AutoMapperApp.Application.MappingProfiles
{
    public class ProductProfile : Profile
    {
        public ProductProfile()
        {
            // Mapeamento de Product para ProductListViewModel
            CreateMap<Product, ProductListViewModel>()
                .ForMember(dest => dest.Price, opt => opt.MapFrom(src => src.Price.ToString("N2", CultureInfo.GetCultureInfo("pt-BR"))));

            // Mapeamento de Product para ProductDetailViewModel
            CreateMap<Product, ProductDetailViewModel>()
                .ForMember(dest => dest.NomeProduto, opt => opt.MapFrom(src => src.Name))
                .ForMember(dest => dest.Price, opt => opt.MapFrom(src => src.Price.ToString("N2", CultureInfo.GetCultureInfo("pt-BR"))))
                .ForMember(dest => dest.DataRegistro, opt => opt.MapFrom(src => src.CreationDate.ToString("yyyy-MM-dd HH:mm:ss")));

            // Mapeamento de ProductDetailViewModel para Product
            CreateMap<ProductDetailViewModel, Product>()
                .ForMember(dest => dest.Name, opt => opt.MapFrom(src => src.NomeProduto))
                .ForMember(dest => dest.Price, opt => opt.MapFrom<PriceStringToDecimalResolver>())
                .ForMember(dest => dest.CreationDate, opt => opt.Ignore());
        }
    }
}