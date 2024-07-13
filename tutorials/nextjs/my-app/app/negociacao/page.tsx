
"use client"
import React, { Component } from "react";
import { NegociacaoForm } from "./NegociacaoForm";
import { NegociacaoTable } from "./NegociacaoTable";
import { Negociacao } from "./Negociacao";


type PaginatedResult = {
    activePage: number,
    lastPage: number,
    pagesToShow: number[],
    prevPage?: number | null,
    nextPage?: number | null,
    hasPrev: boolean
    hasNext: boolean,
    items: Negociacao[]
}

type NegociacaoPageState = {
    negociacoes: PaginatedResult | null,
    loading: boolean
}

export default class NegociacaoPage extends Component<{}, NegociacaoPageState> {
    static displayName = NegociacaoPage.name;
    counter : number = 3;

    constructor(props: any) {
        super(props);
        this.state = { negociacoes: {
            activePage: 1,
            lastPage: 1,
            pagesToShow: [1],
            prevPage: null,
            nextPage: null,
            hasPrev: false,
            hasNext: false,
            items: []
        }, 
        loading: true };
        this.counter = 1
    }

    componentDidMount(): void {
        this.populateNegociacaoData();
    }

    handleNegociacaoFormSubmit = (negociacao: Negociacao) => {

        const newNegociacao: Negociacao = {
            id: (this.counter++).toString(),
            data: negociacao.data,
            quantidade: negociacao.quantidade,
            valor: negociacao.valor,
            volume: negociacao.quantidade * negociacao.valor
        };
        const newNegociacoes = this.state.negociacoes?.items.slice();

        if (newNegociacoes) {
            newNegociacoes.push(newNegociacao);
        }

        // this.setState({ negociacoes: newNegociacoes, loading: false });

    }

    render() {
        let negociacaoTable; !this.state.negociacoes?.items
            ? <p>Loading...</p>
            : (NegociacaoTable.renderNegociacaoTable(this.state.negociacoes?.items, this.state.loading));

        return (
            <div className="container">
                <h1 className="text-center">Negociações</h1>
                <NegociacaoForm onNegociacaoFormSubmit={this.handleNegociacaoFormSubmit} />
                {negociacaoTable}
            </div>
        );
    }

    async populateNegociacaoData(): Promise<void> {
        await new Promise(f => setTimeout(f, 2000));

        const negociacoesArray: Negociacao[] = [
            { id: (this.counter++).toString(), data: new Date(), quantidade: 15, valor: 10, volume: 150 }, 
            { id: (this.counter++).toString(), data: new Date(), quantidade: 10, valor: 20, volume: 200 },
            { id: (this.counter++).toString(), data: new Date(), quantidade: 5, valor: 10, volume: 50 },
        ];

        const negociacoes : PaginatedResult =  {
            activePage: 1,
            lastPage: 10,
            pagesToShow: [1,0,2,3,5,6,0,10],
            prevPage: null,
            nextPage: 2,
            hasPrev: false,
            hasNext: true,
            items: negociacoesArray
        };
        this.setState({ negociacoes, loading: false });

    }
}

