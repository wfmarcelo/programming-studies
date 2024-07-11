"use client"
import React, { useState } from "react";
import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";

function NegociacaoForm() {
    const [validated, setValidated] = useState(false);
    
    const handleSubmit = (event : any) => {
        const form = event.currentTarget;
        const elements = form.elements;
        event.preventDefault();

        if (form.checkValidity() === false) {
            event.stopPropagation();
        }

        setValidated(true);
        console.log({
            data: elements.data.value,
            quantidade: elements.quantidade.value,
            valor: elements.valor.value
        });
    };

    return (
        <Form noValidate validated={validated} onSubmit={handleSubmit}>
            <Form.Group controlId="data" className="mb-3">
                <Form.Label>Data</Form.Label>
                <Form.Control type="date" required />
                <Form.Control.Feedback type="invalid">
                    É necessário informar a data.
                </Form.Control.Feedback>
            </Form.Group> 
            <Form.Group controlId="quantidade" className="mb-3">
                <Form.Label>Quantidade</Form.Label>
                <Form.Control type="number" min={1} step={1} defaultValue={1} required />
                <Form.Control.Feedback type="invalid">
                    É necessário informar a quantidade.
                </Form.Control.Feedback>
            </Form.Group>
            <Form.Group controlId="valor" className="mb-3">
                <Form.Label>Valor</Form.Label>
                <Form.Control type="number" min={0.01} step={0.01} defaultValue={0.01}  required />
                <Form.Control.Feedback type="invalid">
                    É necessário informar ovalor.
                </Form.Control.Feedback>
            </Form.Group>
            <Button type="submit" variant="primary">Incluir</Button>
        </Form>
    )
}

function NegociacaoTable() {
    const [negociacoes, setNegociacoes] = useState([]); 
    
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
                        <tr>
                            <td>{negociacao.data}</td>
                            <td>{negociacao.quantidade}</td>
                            <td>{negociacao.valor}</td>
                            <td></td>
                        </tr>
                    )
                }
            </tbody>
        </Table>
    );
}

export default function Home() {
    return(
        <div className="container">
            <h1 className="text-center">Negociações</h1>
            <NegociacaoForm  />
            <NegociacaoTable />
        </div>
    );
}