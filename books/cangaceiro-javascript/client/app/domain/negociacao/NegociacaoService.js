class NegociacaoService {

    #http;

    constructor() {
        this.#http = new HttpService();
    }

    obterNegociacoesDaSemana() {
        return this.#http
            .get('negociacoes/semana')
            .then(
                dados => {
                    const negociacoes = dados.map(objeto => 
                        new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor));

                    return negociacoes;
                },
                err => {
                    throw new Error('Não foi possível obter as negociações');
                }
            );
    }

    obterNegociacoesDaSemanaAnterior() {
        return this.#http
            .get('negociacoes/anterior')
            .then(
                dados => {
                    const negociacoes = dados.map(objeto => 
                        new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor));

                    return negociacoes;
                },
                err => {
                    throw new Error('Não foi possível obter as negociações');
                }
            );
    }

    obterNegociacoesDaSemanaRetrasada() {
        return this.#http
            .get('negociacoes/retrasada')
            .then(
                dados => {
                    const negociacoes = dados.map(objeto => 
                        new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor));

                    return negociacoes;
                },
                err => {
                    throw new Error('Não foi possível obter as negociações');
                }
            );
    }
}