class View {
    #elemento;

    constructor(seletor) {
        this.#elemento = document.querySelector(seletor);
    }

    update(model){
        this.#elemento.innerHTML = this.template(model);
    };

    template(model){
        throw new Error('VocÊ precisa implementar o método template');
    };
}