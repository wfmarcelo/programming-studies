using Educacional.Core.Application.Ports.Inbound;
using Microsoft.AspNetCore.Mvc;

namespace Educacional.API.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class StudentsController : ControllerBase
    {
        // Dependência da Porta de Entrada (Inbound Port) da Aplicação
        private readonly IStudentManagementService _service; 

        public StudentsController(IStudentManagementService service)
        {
            _service = service;
        }

        /// <summary>
        /// Registers a new student in the system.
        /// </summary>
        /// <param name="command">Data for creating the student, including Name, Cpf, Date of Birth, and Registration.</param>
        [HttpPost]
        [ProducesResponseType(StatusCodes.Status201Created, Type = typeof(StudentDto))]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        [ProducesResponseType(StatusCodes.Status409Conflict)]
        public async Task<IActionResult> Post([FromBody] CreateStudentCommand command)
        {
            try
            {
                // 1. Delega para o Serviço de Aplicação (A Porta de Entrada)
                var studentDto = await _service.CreateStudentAsync(command);
                
                // 2. Retorna resposta HTTP 201 Created com o DTO do aluno
                return CreatedAtAction(nameof(GetById), new { id = studentDto.Id }, studentDto);
            }
            // Captura ArgumentException (lançada pelo Value Object Cpf ou Regra de Idade no Domínio)
            catch (ArgumentException ex)
            {
                return BadRequest(new { Error = ex.Message });
            }
            // Captura InvalidOperationException (lançada pela regra de CPF duplicado na Aplicação)
            catch (InvalidOperationException ex)
            {
                 // Retorna 409 Conflict para indicar recurso duplicado
                return Conflict(new { Error = ex.Message });
            }
            catch (Exception)
            {
                // Retorna 500 Internal Server Error para erros inesperados
                return StatusCode(StatusCodes.Status500InternalServerError, new { Error = "An unexpected error occurred during student creation." });
            }
        }

        /// <summary>
        /// Retrieves a student by their unique ID.
        /// </summary>
        /// <param name="id">The student's unique identifier (GUID).</param>
        [HttpGet("{id:guid}")]
        [ProducesResponseType(StatusCodes.Status200OK, Type = typeof(StudentDto))]
        [ProducesResponseType(StatusCodes.Status404NotFound)]
        public async Task<IActionResult> GetById(Guid id)
        {
            try
            {
                // 1. Delega para o Serviço de Aplicação
                var studentDto = await _service.GetStudentByIdAsync(id);
                
                // 2. Retorna resposta HTTP 200 OK
                return Ok(studentDto);
            }
            // Captura a exceção de "Aluno não encontrado" (lançada na Aplicação)
            catch (Exception) 
            {
                // Retorna 404 Not Found
                return NotFound();
            }
        }
        
        // Poderíamos adicionar aqui os endpoints GET all, PUT (Update), DELETE, etc.
    }
}