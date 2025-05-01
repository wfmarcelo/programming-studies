public interface IRegraDeCalculo
{
    double Calcula(Funcionario f);
}

public class Funcionario
{
    public double SalarioBase { get; internal set; }
    public Cargo Cargo { get; internal set; }
}

public class DezOuVintePorCento : IRegraDeCalculo
{
    public double Calcula(Funcionario funcionario)
    {
        if (funcionario.SalarioBase > 3000.0)
            return funcionario.SalarioBase * 0.8;
        else
            return funcionario.SalarioBase * 0.9;
    }
}

public class QuinzeOuVinteCincoPorCento : IRegraDeCalculo
{
    public double Calcula(Funcionario funcionario)
    {
        if (funcionario.SalarioBase > 2000.0)
            return funcionario.SalarioBase * 0.75;
        else
            return funcionario.SalarioBase * 0.85;
    }
}
