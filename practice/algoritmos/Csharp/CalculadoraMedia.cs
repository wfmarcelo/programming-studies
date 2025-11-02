public class CalculadoraMedia
{
    public static void Executar()
    {
        double soma = 0;
        int contador = 1;
        double media;
        int NUMERO_NOTAS = 5;

        while (contador <= NUMERO_NOTAS)
        {
            Console.WriteLine($"\nDigite a {contador}ª nota: ");
            double nota = Convert.ToDouble(Console.ReadLine());

            if (nota >= 0 && nota <= 10)
            {
                soma += nota;
                contador++;
            } else
            {
                Console.WriteLine("Nota inválida! Digite uma nota entre 0 e 10.");
            }
        }

        media = soma / NUMERO_NOTAS;

        Console.WriteLine("\n-------------------------");
        Console.WriteLine($"A média das notas é: {media}");
        Console.WriteLine("-------------------------");
    }
}