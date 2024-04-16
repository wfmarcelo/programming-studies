using FactoryMethodApp;

var fm = new FactoryMethod();

Console.WriteLine("Liu Kang | SubZero | Scorpion");
Console.WriteLine();

Console.Write("Escolha seu Personagem: ");
string escolha = Console.ReadLine();

IPersonagem personagem = fm.EscolherPersonagem(escolha);

Console.WriteLine();
Console.Write("Você vai jogar com ");
personagem.Escolhido();
