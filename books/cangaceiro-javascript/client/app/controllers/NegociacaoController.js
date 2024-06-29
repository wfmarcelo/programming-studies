class NegociacaoController {

    #inputData;
    #inputQuantidade;
    #inputValor;

    constructor() {

        let $ = document.querySelector.bind(document);

        this.#inputData = $('#data');
        this.#inputQuantidade = $('#quantidade');
        this.#inputValor = $('#valor');

    }

    adiciona(event) {
        event.preventDefault();

        let negociacao = new Negociacao(
            DateConverter.paraData(this.#inputData),
            parseInt(this.#inputQuantidade.value),
            parseFloat(this.#inputValor.value)
        );

        let diaMesAno = DateConverter.paraTexto(negociacao.data);

        console.log(diaMesAno);
    }
}