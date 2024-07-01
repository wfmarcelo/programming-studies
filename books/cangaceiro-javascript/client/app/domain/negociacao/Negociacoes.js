class Negociacoes {
    #negociacoes;
    #armadilha;

    constructor(armadilha) {
        this.#negociacoes = [];
        this.#armadilha = armadilha;
    }

    adiciona(negociacao) {
        this.#negociacoes.push(negociacao);

        this.#armadilha(this);
    }
    
    paraArray() {
        return [].concat(this.#negociacoes);
    }
    
    get volumeTotal() {
        return this.#negociacoes
            .reduce((total, negociacao) => total + negociacao.volume, 0);
    }

    esvazia() {
        this.#negociacoes.length = 0;

        this.#armadilha(this);
    }
}