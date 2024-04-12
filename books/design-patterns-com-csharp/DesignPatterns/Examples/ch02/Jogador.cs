namespace DesignPatterns.Examples.ch02;

public class Jogador : IJogador
{
    public void ParaDireita()
    {
        Console.WriteLine("Para direita");
    }

    public void ParaEsquerda()
    {
        Console.WriteLine("Para esquerda");
    }

    public void ParaFrente()
    {
        Console.WriteLine("Para frente");
    }

    public void ParaTras()
    {
        Console.WriteLine("Para trás");
    }
}