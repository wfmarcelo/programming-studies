public enum Cargo {
    DESENVOLVEDOR,
    DBA,
    TESTER
}

public class CalculadoraDeSalario
{

    public double Calcula(Funcionario funcionario){
        if (Cargo.DESENVOLVEDOR == funcionario.Cargo)
            return new DezOuVintePorCento().Calcula(funcionario);

        if (Cargo.DBA == funcionario.Cargo || Cargo.TESTER == funcionario.Cargo)
            return new QuinzeOuVinteCincoPorCento().Calcula(funcionario);

        throw new ArgumentException("funcionario invalido");
    }
}