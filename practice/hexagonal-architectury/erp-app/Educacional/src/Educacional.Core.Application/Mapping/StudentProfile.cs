using AutoMapper;
using Educacional.Core.Domain.Entities;
using Educacional.Core.Application.Ports.Inbound;
using Educacional.Core.Domain.ValueObjects;

namespace Educacional.Core.Application.Mapping
{
    // O Profile herda de AutoMapper.Profile
    public class StudentProfile : Profile
    {
        public StudentProfile()
        {
            // 1. Mapeamento de Comando (Entrada) para Entidade (Domínio) - Usado para CRIAR
            CreateMap<CreateStudentCommand, Student>()
                .ConstructUsing(src => 
                    // Usamos o Factory Method do Domínio para garantir que as regras são aplicadas
                    Student.Create(
                        src.Name, 
                        src.Cpf, 
                        src.DateOfBirth, 
                        src.Registration
                    )
                );
            
            // 2. Mapeamento de Entidade (Domínio) para DTO (Saída) - Usado para CONSULTAR/RETORNAR
            CreateMap<Student, StudentDto>()
                // Mapeamento explícito para propriedades que não combinam por nome ou tipo.
                .ForMember(dest => dest.Cpf, opt => opt.MapFrom(src => src.IdentifierDocument.Valor))
                .ForMember(dest => dest.Name, opt => opt.MapFrom(src => src.Name)) // Exemplo, mas é automático
                .ReverseMap() // Permite mapear DTO -> Entidade de volta se necessário (não recomendado para Domínio)
                .ForPath(src => src.IdentifierDocument, opt => opt.MapFrom(dest => new Cpf(dest.Cpf)));
        }
    }
}