namespace BuilderPattern;

public class SoldadoDeInfantariaLeve : Soldado
{
    public override void DefinirFoco(string foco)
    {
        Foco = foco;
    }

    public override void EscolherArma(string arma)
    {
        Arma = arma;
    }

    public override void EscolherTransporte(string transporte)
    {
        Transporte = transporte;
    }
}