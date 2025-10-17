
using AutoMapperApp.Application.ViewModels;

namespace AutoMapperApp.Application.Services;

public interface IProductService 
{ 
    ProductViewModel GetProductById(int id); 
}