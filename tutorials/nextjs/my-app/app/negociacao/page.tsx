"use client"
import React, { Component } from "react";
import { NegociacaoForm, NegociacaoFormElement, NegociacaoFormElements } from "./NegociacaoForm";
import { NegociacaoTable } from "./NegociacaoTable";
import { Negociacao } from "./Negociacao";
import Spinner from "react-bootstrap/Spinner";


type NegociacaoViewState = {
    negociacoes: Negociacao[],
    loading: boolean
}

export default class NegociacaoView extends Component<{}, NegociacaoViewState> {
    static displayName = NegociacaoView.name;

    constructor(props: any) {
        super(props);
        this.state = { negociacoes: [], loading: true }

    }

    componentDidMount(): void {
        this.populateNegociacaoData();
    }


    onNegociacaoFormSubmit = (negociacao: Negociacao) => {

        const newNegociacao: Negociacao = {
            id: (this.state.negociacoes[this.state.negociacoes.length - 1].id + "1"),
            data: negociacao.data,
            quantidade: negociacao.quantidade,
            valor: negociacao.valor,
            volume: negociacao.quantidade * negociacao.valor
        };
        const newNegociacoes = this.state.negociacoes.slice();
        newNegociacoes.push(newNegociacao);

        this.setState({ negociacoes: newNegociacoes, loading: false });
    }

    render() {
        let contents = this.state.loading
            ? (<div className="mb -3 text-center">
                <Spinner animation="border" role="status">
                    <span className="visually-hidden">Loading...</span>
                </Spinner>
            </div>
)
            : NegociacaoTable.renderNegociacaoTable(this.state.negociacoes);

            console.log(this.state.negociacoes);
        return (
            <div className="container">
                <h1 className="text-center">Negociações</h1>
                <NegociacaoForm onNegociacaoFormSubmit={this.onNegociacaoFormSubmit} />
                {contents}
            </div>
        );
    }

    async populateNegociacaoData(): Promise<void> {
        await new Promise(f => setTimeout(f, 2000));
        const data = [{ id: "1", data: new Date(), quantidade: 15, valor: 10, volume: 150 }, { id: "2", data: new Date(), quantidade: 10, valor: 20, volume: 200 }];
        this.setState({ negociacoes: data, loading: false });

    }
}

