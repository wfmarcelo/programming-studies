class NegociacaoController {

    #inputData;
    #inputQuantidade;
    #inputValor;
    #negociacoes;
    #mensagem;
    #service;

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

        this.#service = new NegociacaoService();
    }

    adiciona(event) {
        try {
            event.preventDefault();
            this.#negociacoes.adiciona(this.#criaNegociacao());
            this.#mensagem.texto = 'Negociação adicionada com sucesso';
            this.#limpaFormulario();
            
        } catch(err) {
            console.log(err);
            console.log(err.stack);

            if(err instanceof DataInvalidaException) {
                this.#mensagem.texto = err.message;
            }
            else {
                this.#mensagem.texto = 'Um erro não esperado aconteceu. Entre em contato com o suporte';

            }
        }
    }

    apaga() {
        this.#negociacoes.esvazia();
        this.#mensagem.texto = 'Negociações apagadas com sucesso';
    }

    importaNegociacoes() {
        this.#service.obterNegociacoesDaSemana((err, negociacoes) => {
            if (err) {
                this.#mensagem.texto = 'Não foi possível obter as negociações da semana';
                return;
            }

            negociacoes.forEach(negociacao => 
                this.#negociacoes.adiciona(negociacao));

            this.#mensagem.texto = 'Negociações importadas com sucesso';
        });
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