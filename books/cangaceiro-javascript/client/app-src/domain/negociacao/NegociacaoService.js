import { HttpService } from "../../util/HttpService.js";
import { Negociacao } from "./Negociacao.js";
import { ApplicationException } from "../../util/ApplicationException.js";

export class NegociacaoService {

    constructor() {
        this._http = new HttpService();
    }

    async obtemNegociacoesDoPeriodo() {
        try {
            let periodo = await Promise.all([
                this.obterNegociacoesDaSemana(),
                this.obterNegociacoesDaSemanaAnterior(),
                this.obterNegociacoesDaSemanaRetrasada()
            ]);

            return periodo
                .reduce((novoArray, item) => novoArray.concat(item), [])
                .sort((a, b) => b.data.getTime() - a.data.getTime());
        } catch (err) {
            console.error(err);
            throw new ApplicationException('Não foi possível obter as negociações do período');
        }
        
    }

    obterNegociacoesDaSemana() {
        return this._http
            .get('negociacoes/semana')
            .then(
                dados => dados.map(objeto =>
                    new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)),
                err => {
                    throw new ApplicationException('Não foi possível obter as negociações');
                }
            );
    }

    obterNegociacoesDaSemanaAnterior() {
        return this._http
            .get('negociacoes/anterior')
            .then(
                dados => dados.map(objeto =>
                    new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)),
                err => {
                    throw new ApplicationException('Não foi possível obter as negociações');
                }
            );
    }

    obterNegociacoesDaSemanaRetrasada() {
        return this._http
            .get('negociacoes/retrasada')
            .then(
                dados => dados.map(objeto =>
                    new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)),
                err => {
                    throw new ApplicationException('Não foi possível obter as negociações');
                }
            );
    }
}