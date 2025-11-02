// See https://aka.ms/new-console-template for more information
Console.WriteLine("Olá, sejam bem-vindos aos exercícios de C#!");

do
{
    Console.WriteLine("Escolha uma opção de exercício para executar: (ctrl + c para sair)");
    Console.WriteLine("1 - Calculadora de Média");
    Console.WriteLine("2 - Calculadora de Salários");
    Console.WriteLine("3 - Cadastro de Clientes");
    // Você pode adicionar mais opções de exercícios aqui

    string opcao = Console.ReadLine();
    switch (opcao)
    {
        case "1":
            CalculadoraMedia.Executar();
            break;
        case "2":
            CalculadoraSalarios.Executar();
            break;
        case "3":
            CadastroClientes.Executar();
            break;
        // Você pode adicionar mais casos para outros exercícios aqui
        default:
            Console.WriteLine("Opção inválida. Por favor, escolha uma opção válida.");
            break;
    }

    Console.WriteLine(); // Linha em branco para melhor legibilidade

} while (true);





