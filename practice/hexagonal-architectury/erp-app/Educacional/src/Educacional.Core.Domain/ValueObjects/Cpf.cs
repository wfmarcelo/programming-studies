// Educacional.Core.Domain/ValueObjects/Cpf.cs
using System.Text.RegularExpressions;

namespace Educacional.Core.Domain.ValueObjects
{
    public record Cpf
    {
        public string Valor { get; }

        public Cpf(string valor)
        {
            Valor = CleanCpf(valor);
            
            if (!IsValid(Valor))
            {
                throw new ArgumentException("CPF inválido.", nameof(valor));
            }
        }

        private static string CleanCpf(string valor)
        {
            return Regex.Replace(valor ?? string.Empty, @"[^\d]", "");
        }

        // Simulação da lógica de validação do CPF (regra de domínio crucial)
        private static bool IsValid(string cpf)
        {
            if (string.IsNullOrEmpty(cpf) || cpf.Length != 11) return false;
            // No mundo real, aqui estaria a lógica completa de validação de CPF.
            // Para o exemplo, vamos apenas verificar se não são todos dígitos iguais.
            if (new string(cpf[0], 11) == cpf) return false; 
            
            return true;
        }

        public override string ToString() => Valor;
    }
}