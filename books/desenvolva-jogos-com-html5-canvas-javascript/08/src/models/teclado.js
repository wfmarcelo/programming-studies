

export class Teclado {
    
    static SETA_ESQUERDA = 37;
    static SETA_ACIMA = 38;
    static SETA_DIREITA = 39;
    static SETA_ABAIXO = 40;
    static ESPACO = 32;
    static ENTER = 13;
    
    
    constructor(elemento) {
        this.elemento = elemento;

        this.pressionadas = [];
        this.disparadas = [];
        this.funcoesDisparo = [];

        const teclado = this;

        elemento.addEventListener('keydown', function (evento) {
            let tecla = evento.keyCode;
            teclado.pressionadas[tecla] = true;

            if (teclado.funcoesDisparo[tecla] && !teclado.disparadas[tecla]) {
                teclado.disparadas[tecla] = true;
                teclado.funcoesDisparo[tecla]();
            }
        });

        elemento.addEventListener('keyup', function (evento) {
            teclado.pressionadas[evento.keyCode] = false;
            teclado.disparadas[evento.keyCode] = false;
        });
    }

    pressionada(tecla) {
        return this.pressionadas[tecla];
    }

    disparou(tecla, callback) {
        this.funcoesDisparo[tecla] = callback;
    }

    


}

