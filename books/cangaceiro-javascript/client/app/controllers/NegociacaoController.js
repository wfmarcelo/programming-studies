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

        this.#negociacoes = new Bind(
            new Negociacoes(),
            new NegociacoesView('#negociacoes'),
            'adiciona', 'esvazia'
        );

        this.#mensagem = new Bind(
            new Mensagem(),
            new MensagemView('#mensagemView'),
            'texto'
        );
    }

    adiciona(event) {

        event.preventDefault();
        this.#negociacoes.adiciona(this.#criaNegociacao());
        this.#mensagem.texto = 'Negociação adicionada com sucesso';
        this.#limpaFormulario();
    }

    apaga() {
        this.#negociacoes.esvazia();
        this.#mensagem.texto = 'Negociações apagadas com sucesso';
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