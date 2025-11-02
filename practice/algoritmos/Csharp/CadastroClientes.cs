public class CadastroClientes
{
    public static void Executar()
    {
        int totalClientes = 0; // CORREÇÃO: Começa a contar do 0 (total de cadastros)
        string nome = "";      // Variável para armazenar o nome lido
        string flag = "";      // Variável para armazenar o comando de parada (S/N)
        
        do
        {
            Console.WriteLine("--------------------------------");
            Console.WriteLine($"Total de clientes cadastrados até agora: {totalClientes}");
            Console.WriteLine("Deseja inserir um novo cliente? (S - Sim; N - Não/Encerrar)");
            flag = Console.ReadLine(); // Lê a intenção do usuário

            if (flag.ToUpper() == "S")
            {
                // Se a intenção é cadastrar, pedimos o nome e incrementamos
                totalClientes++; // Incrementa o contador
                Console.WriteLine($"Insira o nome do cliente {totalClientes}: ");
                nome = Console.ReadLine();
                Console.WriteLine($"Cliente {totalClientes}: {nome} cadastrado com sucesso!");

            } else if (flag.ToUpper() != "N")
            {
                // Opção de validação para entradas diferentes de S ou N
                Console.WriteLine("Opção inválida. Por favor, digite 'S' para continuar ou 'N' para encerrar.");
            }

        // CORREÇÃO LÓGICA: O loop continua ENQUANTO a flag NÃO for 'N'.
        } while (flag.ToUpper() != "N");
        
        Console.WriteLine("\n-------------------------");
        Console.WriteLine($"Cadastro encerrado. Total final de clientes cadastrados: {totalClientes}");
        Console.WriteLine("-------------------------");
    }
}