namespace PrototypePattern;

public class NuvemConcreta : NuvemMolde
{
    private string corPreenchimento;
    private string corContorno;

    public NuvemConcreta(string corPreenchimento, string corContorno)
    {
        this.corContorno = corContorno;
        this.corPreenchimento = corPreenchimento;
    }
    public override NuvemMolde Clone()
    {
        Console.WriteLine($"A nuvem clonada tem contorno {corContorno} e preenchimento {corPreenchimento}");
        return this.MemberwiseClone() as NuvemMolde;
    }
}