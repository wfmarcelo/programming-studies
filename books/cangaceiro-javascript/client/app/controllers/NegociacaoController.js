class NegociacaoController {

    #inputData;
    #inputQuantidade;
    #inputValor;
    #negociacoes;
    #negociacoesView;

    constructor() {

        let $ = document.querySelector.bind(document);

        this.#inputData = $('#data');
        this.#inputQuantidade = $('#quantidade');
        this.#inputValor = $('#valor');
        this.#negociacoes = new Negociacoes();
        this.#negociacoesView = new NegociacoesView('#negociacoes');

        this.#negociacoesView.update(this.#negociacoes);

    }

    adiciona(event) {
        
        event.preventDefault();
        this.#negociacoes.adiciona(this.#criaNegociacao());
        this.#negociacoesView.update(this.#negociacoes);
        this.#limpaFormulario();
    }

    #limpaFormulario() {
        this.#inputData.value = '';
        this.#inputQuantidade.value = 1;
        this.#inputValor.value = 0.0;
        this.#inputData.focus();
    }

    #criaNegociacao() {
        return new Negociacao(
            DateConverter.paraData(this.#inputData.value),
            parseInt(this.#inputQuantidade.value),
            parseFloat(this.#inputValor.value)
        );
    }
}