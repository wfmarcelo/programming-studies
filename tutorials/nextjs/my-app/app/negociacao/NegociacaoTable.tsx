import React from "react";
import { Negociacao } from "./Negociacao";
import Table from "react-bootstrap/Table";
import Spinner from "react-bootstrap/Spinner";

type NegociacaoTableProps = {
    negociacoes: Negociacao[],
    loading: boolean
}

export class NegociacaoTable extends React.Component<NegociacaoTableProps> {

    static displayName = NegociacaoTable.name;
    negociacoes: Negociacao[]
    loading: boolean;

    constructor(props: NegociacaoTableProps) {
        super(props);
        this.negociacoes = props.negociacoes;
        this.loading = props.loading;
        console.log('negociacao table constructor');
    }

    static renderNegociacaoTable(negociacoes: Negociacao[], loading: boolean) {
        
        negociacoes.map(negociacao => {console.log(negociacao.data)});
        console.log(loading);
        const contents = loading
            ? (<div className="text-center mt-3">
                <Spinner animation="border" role="status" variant="primary">
                    <span className="visually-hidden">Loading...</span>
                </Spinner></div>)
            : (
                <Table hover className="mt-3">
                    <thead>
                        <tr>
                            <th>Data</th>
                            <th className="text-center">Quantidade</th>
                            <th className="text-center">Valor</th>
                            <th className="text-center">Volume</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            negociacoes.map(negociacao =>
                                <tr key={negociacao.id}>
                                    <td>{negociacao.data?.toLocaleDateString()}</td>
                                    <td className="text-center">{negociacao.quantidade}</td>
                                    <td className="text-center">{negociacao.valor}</td>
                                    <td className="text-center">{negociacao.volume}</td>
                                </tr>
                            )
                        }
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colSpan={3}></td>
                            <td className="text-center">{negociacoes.reduce(
                                (acumulator, currentValue) => acumulator + currentValue.volume, 0)}</td>
                        </tr>
                    </tfoot>
                </Table>
            )

            console.log(contents);
        return <>
            <h1>Teste</h1>
            {contents}
        </>;
    }

    render() {
        return NegociacaoTable.renderNegociacaoTable(this.negociacoes, this.loading);
    }
}
