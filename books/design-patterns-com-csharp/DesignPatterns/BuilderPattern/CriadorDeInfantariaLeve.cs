namespace BuilderPattern;

public class CriadorDeInfantariaLeve : CriadorDeSoldado
{
    public CriadorDeInfantariaLeve()
    {
        soldado = new SoldadoDeInfantariaLeve();
    }
    
    public override void Arma()
    {
        soldado.EscolherArma("Ataque aéreo");
    }

    public override void Foco()
    {
        soldado.DefinirFoco("resposta rápida aérea");
    }

    public override void Transporte()
    {
        soldado.EscolherTransporte("Helicóptero de ataque do Exército");
    }
}