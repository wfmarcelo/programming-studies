using DesignPatterns.Examples.ch02;


Console.WriteLine("Digite a opção do capitulo que deseja visualizar que deseja visualizar: ");
Console.WriteLine("2 - Capitulo 2");
Console.WriteLine("Q - para sair.");

var opcao = Console.ReadLine();

while (opcao.ToLower().Equals("q") == false)
{
    switch (opcao)
    {
        case "2":
            CH02();
            break;
        default:
            Console.WriteLine("Opção escolhida não definida.");
            Console.WriteLine();
            break;

    }
    
    Console.WriteLine("Digite a opção do capitulo que deseja visualizar que deseja visualizar: ");
    Console.WriteLine("2 - Capitulo 2");
    Console.WriteLine("Q - para sair.");

    opcao = Console.ReadLine();
}


static void CH02()
{
    ShangTsung st = new ShangTsung();
    st.Atacar();

    Console.WriteLine();

}