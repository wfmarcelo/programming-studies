class Carro {
    constructor(cor, velocidadeMaxima) {
        this.cor = cor;
        this.velocidadeMaxima = velocidadeMaxima;
        this.velocidadeAtual = 0;
    }

    acelerar() {
        this.velocidadeAtual += 10;
    }
}