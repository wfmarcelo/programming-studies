import React from "react";
import { Negociacao } from "./Negociacao";
import Table from "react-bootstrap/Table";

type NegociacaoTableProps = {
    negociacoes: Negociacao[]
}

type NegociacaoTableState = {
    negociacoes: Negociacao[];
}

export class NegociacaoTable extends React.Component<NegociacaoTableProps, NegociacaoTableState> {

    static displayName = NegociacaoTable.name;

    constructor(props: NegociacaoTableProps) {
        super(props);
        this.state = { negociacoes: props.negociacoes };
    }

    static renderNegociacaoTable(negociacoes: Negociacao[]) {
        const total = negociacoes.reduce(
            (acumulator, currentValue) => acumulator + currentValue.volume, 0);
        
        return (
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
    }

    render() {
        return (NegociacaoTable.renderNegociacaoTable(this.state.negociacoes));
    }

}