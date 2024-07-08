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

        this.#init();
        
    }

    adiciona(event) {
        try {
            event.preventDefault();
            const negociacao = this.#criaNegociacao();

            getNegociacaoDao()
                .then(dao => dao.adiciona(negociacao))
                .then(() => {
                    this.#negociacoes.adiciona(negociacao);
                    this.#mensagem.texto = 'Negociação adicionada com sucesso';
                    this.#limpaFormulario();
                })
                .catch(err => this.#mensagem.texto = err);

            
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

        getNegociacaoDao()
            .then(dao => dao.apagaTodos())
            .then(() => {
                this.#negociacoes.esvazia();
                this.#mensagem.texto = 'Negociações apagadas com sucesso';
            })
            .catch(err => this.#mensagem.texto = err);

    }

    importaNegociacoes() {
        this.#service
            .obtemNegociacoesDoPeriodo()
            .then(negociacoes => {
                
                negociacoes
                    .filter(novaNegociacao => {
                        return !this.#negociacoes.paraArray().some(negociacaoExistente =>
                            novaNegociacao.equals(negociacaoExistente));
                    })
                    .forEach(negociaco => this.#negociacoes.adiciona(negociaco));
                
                this.#mensagem.texto = 'Negociações do período importadas com sucesso';
            })
            .catch(err => this.#mensagem.texto = err);
    }

    #init() {
        getNegociacaoDao()
            .then(dao => dao.listaTodos())
            .then(negociacoes =>
                negociacoes.forEach(negociacao =>
                    this.#negociacoes.adiciona(negociacao)))
            .catch(err => this.#mensagem.texto = err);
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