import { HttpService } from "../../util/HttpService.js";
import { Negociacao } from "./Negociacao.js";

export class NegociacaoService {

    #http;

    constructor() {
        this.#http = new HttpService();
    }

    obtemNegociacoesDoPeriodo() {
        return Promise.all([
            this.obterNegociacoesDaSemana(),
            this.obterNegociacoesDaSemanaAnterior(),
            this.obterNegociacoesDaSemanaRetrasada()
        ])
            .then(periodo => periodo
                .reduce((novoArray, item) => novoArray.concat(item), [])
                .sort((a, b) => b.data.getTime() - a.data.getTime()))
            .catch(err => {
                console.log(err);
                throw new Error('Não foi possível obter as negociações do período')
            });
    }

    obterNegociacoesDaSemana() {
        return this.#http
            .get('negociacoes/semana')
            .then(
                dados => dados.map(objeto =>
                    new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)),
                err => {
                    throw new Error('Não foi possível obter as negociações');
                }
            );
    }

    obterNegociacoesDaSemanaAnterior() {
        return this.#http
            .get('negociacoes/anterior')
            .then(
                dados => dados.map(objeto =>
                    new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)),
                err => {
                    throw new Error('Não foi possível obter as negociações');
                }
            );
    }

    obterNegociacoesDaSemanaRetrasada() {
        return this.#http
            .get('negociacoes/retrasada')
            .then(
                dados => dados.map(objeto =>
                    new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)),
                err => {
                    throw new Error('Não foi possível obter as negociações');
                }
            );
    }
}