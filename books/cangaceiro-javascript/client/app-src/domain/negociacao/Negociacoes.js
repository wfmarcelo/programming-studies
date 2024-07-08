export class Negociacoes {
    #negociacoes;

    constructor() {
        this.#negociacoes = [];
    }

    adiciona(negociacao) {
        this.#negociacoes.push(negociacao);
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
    }
}