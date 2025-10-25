// Educacional.Core.Application/Ports/Inbound/IGerenciarAlunoService.cs
namespace Educacional.Core.Application.Ports.Inbound
{
    // Renomeado: CriarAlunoCommand -> CreateStudentCommand
    public record CreateStudentCommand(string Name, string Cpf, DateTime DateOfBirth, string Registration);
    
    // Renomeado: AlunoDto -> StudentDto
    public record StudentDto(Guid Id, string Name, string Cpf, DateTime DateOfBirth, string Registration);
    
    public interface IStudentManagementService
    {
        Task<StudentDto> CreateStudentAsync(CreateStudentCommand command);
        Task<StudentDto> GetStudentByIdAsync(Guid id);
        // ...
    }
}