import React from "react";
import { Negociacao } from "./Negociacao";
import Table from "react-bootstrap/Table";

type NegociacaoTableProps = {
    negociacoes: Negociacao[]
}

type NegociacaoTableState = {
    negociacoes: Negociacao[];
    loading: boolean;
}

export class NegociacaoTable extends React.Component<NegociacaoTableProps, NegociacaoTableState> {

    static displayName = NegociacaoTable.name;

    constructor(props: NegociacaoTableProps) {
        super(props);
        this.state = { negociacoes: props.negociacoes, loading: true };
    }

    static renderNegociacaoTable(negociacoes: Negociacao[]) {
        return (
            <Table hover className="mt-3">
             <thead>
                 <tr>
                     <th>Data</th>
                     <th>Quantidade</th>
                     <th>Valor</th>
                     <th>Volume</th>
                 </tr>
             </thead>
             <tbody>
                 {
                     negociacoes.map(negociacao => 
                         <tr key={negociacao.id}>
                             <td>{negociacao.data?.toLocaleDateString()}</td>
                             <td>{negociacao.quantidade}</td>
                             <td>{negociacao.valor}</td>
                             <td>{negociacao.volume}</td>
                         </tr>
                     )
                 }
             </tbody>
         </Table>
        )
    }

    render() {
        let contents = this.state.loading
            ? <p><em></em></p>
            : NegociacaoTable.renderNegociacaoTable(this.state.negociacoes);
            
        return <>{contents}</>;
    }

    
}