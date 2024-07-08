const ConnectionFactory = (() => {

    const stores = ['negociacoes'];
    let connection = null;
    
    return class ConnectionFactory {
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
                    resolve(connection);
                };
    
                openRequest.onerror = e => {
                    console.log(e.target.error);
                    reject(e.target.error.name);
                };
            });
        }
    
        static #createStores(connection) {
            stores.forEach(store => {
                if (connection.objectStoreNames.contains(store)) 
                    connection.deleteObjectStore(store);
    
                connection.createObjectStore(store, { autoIncrement: true });
            });
        }
    }
})();

