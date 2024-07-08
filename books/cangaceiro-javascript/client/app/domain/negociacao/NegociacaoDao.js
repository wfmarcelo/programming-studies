class NegociacaoDao {
    
    #connection;
    #store;
    
    constructor(connection) {
        this.#connection = connection;
        this.#store = 'negociacoes';
    }

    adiciona(negociacao) {
        return new Promise((resolve, reject) => {
            const request = this.#connection
                .transaction([this.#store], 'readwrite')
                .objectStore(this.#store)
                .add(negociacao);

            request.onsuccess = e => resolve();
            request.onerror = e => {
                console.log(e.target.error);
                reject('Não foi possível salvar a negociação');
            }
        });
    }

    apagaTodos() {
        return new Promise((resolve, reject) => {
            const request = this.#connection
                .transaction([this.#store], 'readwrite')
                .objectStore(this.#store)
                .clear();

            request.onsuccess = e => resolve();

            request.onerror = e => {
                console.log(e.target.error);
                reject('Não foi possível apagar as negociações');
            }
        });
    }

    listaTodos() {
        return new Promise((resolve, reject) => {
            const negociacoes = [];
            
            const cursor = this.#connection
                .transaction([this.#store], 'readwrite')
                .objectStore(this.#store)
                .openCursor();

            cursor.onsuccess = e => {
                const atual = e.target.result;

                if (atual) {
                    const negociacao = new Negociacao(
                        atual.value._data,
                        atual.value._quantidade,
                        atual.value._valor);
                    
                        negociacoes.push(negociacao);
                        atual.continue();
                } else {
                    resolve(negociacoes);
                }
            };

            cursor.onerror = e => {
                console.log(e.target.error);
                reject('Não foi possível listar as negociações');
            };
        });
    }
}