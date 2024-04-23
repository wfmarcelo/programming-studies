namespace BuilderPattern;

public class CriadorForcasEspeciais : CriadorDeSoldado
{
    public CriadorForcasEspeciais()
    {
        soldado = new SoldadoDeForcasEspeciais();
    }
    
    public override void Arma()
    {
        soldado.EscolherArma("Fuzil");
    }

    public override void Foco()
    {
        soldado.DefinirFoco("combate em solo");
    }

    public override void Transporte()
    {
        soldado.EscolherTransporte("Carro de operações especiais");
    }
}