using BuilderPattern;

var exercito = new Exercito();
CriadorDeSoldado criadorDeSoldado;
Soldado soldado;

criadorDeSoldado = new CriadorForcasEspeciais();
exercito.ConstruirSoldado(criadorDeSoldado);
soldado = criadorDeSoldado.ObterSoldado();
Console.WriteLine("Soldado com as características: {0}, {1}, {2}",
    soldado.Arma, soldado.Transporte, soldado.Foco);

criadorDeSoldado = new CriadorDeInfantariaLeve();
exercito.ConstruirSoldado(criadorDeSoldado);
soldado = criadorDeSoldado.ObterSoldado();
Console.WriteLine("Soldado com as características: {0}, {1}, {2}",
    soldado.Arma, soldado.Transporte, soldado.Foco);

