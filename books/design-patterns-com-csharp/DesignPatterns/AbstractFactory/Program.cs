using AbstractFactory;

IFabricaBases fabrica;
Console.WriteLine("Escolha um dos personsagens:\n\n1-Protoss\n2-Zergs\n3-Terranos ");

switch (Console.ReadLine())
{
    case "1":
        fabrica = new FabricaBaseProtoss();
        break;

    case "2":
        fabrica = new FabricaBaseZerg();
        break;

    case "3":
        fabrica = new FabricaBaseTerran();
        break;
}

Console.ReadLine();