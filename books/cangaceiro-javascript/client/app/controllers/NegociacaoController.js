class NegociacaoController {

    #inputData;
    #inputQuantidade;
    #inputValor;
    #negociacoes;
    #negociacoesView;
    #mensagem;
    #mensagemView;

    constructor() {

        const $ = document.querySelector.bind(document);

        this.#inputData = $('#data');
        this.#inputQuantidade = $('#quantidade');
        this.#inputValor = $('#valor');
        this.#negociacoes = new Negociacoes();
        this.#negociacoesView = new NegociacoesView('#negociacoes');

        this.#negociacoesView.update(this.#negociacoes);
        
        this.#mensagem = new Mensagem();
        this.#mensagemView = new MensagemView('#mensagemView');
        this.#mensagemView.update(this.#mensagem);

    }

    adiciona(event) {
        
        event.preventDefault();
        this.#negociacoes.adiciona(this.#criaNegociacao());
        this.#mensagem.texto = 'Negociação adicionada com sucesso';
        this.#mensagemView.update(this.#mensagem);
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