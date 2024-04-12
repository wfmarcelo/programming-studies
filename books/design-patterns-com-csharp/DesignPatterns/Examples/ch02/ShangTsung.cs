namespace DesignPatterns.Examples.ch02;

public class ShangTsung : Personagem
{
    public override void Atacar()
    {
        var personagens = new List<Personagem>
        {
            new LiuKang(),
            new SubZero()
        };

        foreach (var personagem in personagens)
        {
            Console.WriteLine($"Agora eu sou {personagem.GetType().Name}");
            personagem.Atacar();
        }
    }
}