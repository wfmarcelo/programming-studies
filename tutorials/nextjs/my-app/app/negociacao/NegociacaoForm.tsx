
import React from "react";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { Negociacao } from "./Negociacao";

type NegociacaoFormProps = {
    onNegociacaoFormSubmit: (negociacao : Negociacao) => void
};

type NegociacaoFormState = {
    validated: boolean
}

export interface NegociacaoFormElements extends HTMLFormControlsCollection {
    dataInput: HTMLInputElement,
    quantidadeInput: HTMLInputElement,
    valorInput: HTMLInputElement
}

export interface NegociacaoFormElement extends HTMLFormElement {
    readonly elements: NegociacaoFormElements
}

export class NegociacaoForm extends React.Component<NegociacaoFormProps, NegociacaoFormState> {
    static displayName = NegociacaoForm.name;
    onNegociacaoFormSubmit: (negociacao: Negociacao) => void;
    

    constructor(props: NegociacaoFormProps) {
        super(props);
        this.state = { validated: false };
        this.onNegociacaoFormSubmit = props.onNegociacaoFormSubmit;
    }

    handleSubmit = (event : React.FormEvent<NegociacaoFormElement>) => {
        event.preventDefault();
        const form = event.currentTarget;

        if (form.checkValidity() === false) {
            event.stopPropagation();
            this.setState({ validated: true });
            return;
        } 
        

        const negociacao : Negociacao = { 
            data: form.elements.dataInput.valueAsDate,
            quantidade: form.elements.quantidadeInput.valueAsNumber,
            valor: form.elements.valorInput.valueAsNumber,
            volume: 0
        };

        this.onNegociacaoFormSubmit(negociacao);
    }

    render() {
        return (
            <Form noValidate validated={this.state.validated} onSubmit={this.handleSubmit}>
             <Form.Group controlId="dataInput" className="mb-3">
                 <Form.Label>Data</Form.Label>
                 <Form.Control type="date" required />
                 <Form.Control.Feedback type="invalid">
                     É necessário informar a data.
                 </Form.Control.Feedback>
             </Form.Group> 
             <Form.Group controlId="quantidadeInput" className="mb-3">
                 <Form.Label>Quantidade</Form.Label>
                 <Form.Control type="number" min={1} step={1} defaultValue={1} required />
                 <Form.Control.Feedback type="invalid">
                     É necessário informar a quantidade.
                 </Form.Control.Feedback>
             </Form.Group>
             <Form.Group controlId="valorInput" className="mb-3">
                 <Form.Label>Valor</Form.Label>
                 <Form.Control type="number" min={0.01} step={0.01} defaultValue={0.01}  required />
                 <Form.Control.Feedback type="invalid">
                     É necessário informar o valor.
                 </Form.Control.Feedback>
             </Form.Group>
             <Button type="submit" variant="primary">Incluir</Button>
         </Form>
        )
    }
}