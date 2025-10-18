using AutoMapper;
using System;
using System.Globalization;

namespace AutoMapperApp.Application.MappingProfiles
{
    public class PriceStringToDecimalResolver : IValueResolver<ViewModels.ProductDetailViewModel, Domain.Entities.Product, decimal>
    {
        public decimal Resolve(ViewModels.ProductDetailViewModel source, Domain.Entities.Product destination, decimal destMember, ResolutionContext context)
        {
            if (string.IsNullOrWhiteSpace(source.Price))
            {
                return 0m; // Ou lance uma exceção, dependendo da sua regra de negócio
            }

            string priceString = source.Price.Replace("R$", "").Trim();

            // Tenta converter usando a cultura pt-BR para lidar com vírgulas como separador decimal
            if (decimal.TryParse(priceString, NumberStyles.Currency, CultureInfo.GetCultureInfo("pt-BR"), out decimal price))
            {
                return price;
            }

            // Se a conversão falhar, você pode lançar uma exceção ou retornar um valor padrão.
            // Lançar uma exceção é geralmente melhor para indicar dados inválidos.
            throw new FormatException($"The input string '{source.Price}' for price was not in a correct format after cleaning.");
        }
    }
}