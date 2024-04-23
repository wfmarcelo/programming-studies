namespace BuilderPattern;

public abstract class CriadorDeSoldado
{
    protected Soldado soldado;

    public Soldado ObterSoldado()
    {
        return soldado;
    }

    public abstract void Arma();
    public abstract void Transporte();
    public abstract void Foco();
}