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

    listaTodos() {
        return new Promise((resolve, reject) => {

        });
    }
}