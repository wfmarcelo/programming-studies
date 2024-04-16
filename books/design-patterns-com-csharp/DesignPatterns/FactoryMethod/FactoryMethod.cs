namespace FactoryMethodApp;

public class FactoryMethod
{
    public IPersonagem? EscolherPersonagem(string personagem)
    {
        switch (personagem)
        {
            case "Liu Kang": return new LiuKang();
            case "SubZero": return new SubZero();
            case "Scorpion": return new Scorpion();
            default: return null;
        }
    }
}