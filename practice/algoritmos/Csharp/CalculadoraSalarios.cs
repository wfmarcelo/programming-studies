public class CalculadoraSalarios
{
    public static void Executar()
    {
        string nomeAtual;
        double salarioAtual;
        double somaSalarios = 0;
        double maiorSalario = double.MinValue;
        string nomeMaiorSalario = "";


        for (int i = 1; i <= 10; i++)
        {
            Console.WriteLine($"\nDigite o nome do funcionário {i}: ");
            nomeAtual = Console.ReadLine();
            Console.WriteLine($"Digite o salário do funcionário {i}: ");
            salarioAtual = Convert.ToDouble(Console.ReadLine());
            somaSalarios += salarioAtual;
            if (salarioAtual > maiorSalario)
            {
                maiorSalario = salarioAtual;
                nomeMaiorSalario = nomeAtual;
            }
        }

        Console.WriteLine("\n-------------------------");
        Console.WriteLine($"O maior salário é de {nomeMaiorSalario}, com o valor de {maiorSalario}");
        Console.WriteLine($"A soma dos salários é: {somaSalarios}");
        Console.WriteLine("-------------------------");

        
    }
}