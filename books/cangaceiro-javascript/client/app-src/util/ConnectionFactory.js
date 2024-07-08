const stores = ['negociacoes'];
let connection = null;
let close = null;

export class ConnectionFactory {
    constructor() {
        throw new Error('Não é possível criar instâncias dessa classe');
    }

    static getConnection() {
        return new Promise((resolve, reject) => {

            if (connection) return resolve(connection);

            const openRequest = indexedDB.open('jscangaceiro', 2);

            openRequest.onupgradeneeded = e => {

                ConnectionFactory.#createStores(e.target.result);

            };

            openRequest.onsuccess = e => {
                connection = e.target.result;

                close = connection.close.bind(connection);
                connection.close = () => {
                    throw new Error('Você mão pode fechar diretamente a conexão');
                };
                resolve(connection);
            };

            openRequest.onerror = e => {
                console.log(e.target.error);
                reject(e.target.error.name);
            };
        });
    }

    static closeConnection() {
        if (connection)
            close();
    }

    static #createStores(connection) {
        stores.forEach(store => {
            if (connection.objectStoreNames.contains(store))
                connection.deleteObjectStore(store);

            connection.createObjectStore(store, { autoIncrement: true });
        });
    }
}