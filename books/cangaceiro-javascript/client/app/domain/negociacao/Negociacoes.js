class Negociacoes {
    #negociacoes;
    #armadilha;
    #contexto;

    constructor(contexto, armadilha) {
        this.#negociacoes = [];
        this.#armadilha = armadilha;
        this.#contexto = contexto;
    }

    adiciona(negociacao) {
        this.#negociacoes.push(negociacao);

        this.#armadilha.call(this.#contexto, this);
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

        this.#armadilha.call(this.#contexto, this);
    }
}