const SETA_ESQUERDA = 37;
const SETA_ACIMA = 38;
const SETA_DIREITA = 39;
const SETA_ABAIXO = 40;
const ESPACO = 32;

class Teclado {
    constructor(elemento) {
        this.elemento = elemento;

        this.pressionadas = [];
        this.disparadas = [];
        this.funcoesDisparo = [];

        const teclado = this;

        elemento.addEventListener('keydown', function(evento) {
            let tecla = evento.keyCode;
            teclado.pressionadas[tecla] = true;

            if (teclado.funcoesDisparo[tecla] && !teclado.disparadas[tecla]) {
                teclado.disparadas[tecla] = true;
                teclado.funcoesDisparo[tecla] ();
            }
        });
        
        elemento.addEventListener('keyup', function(evento) {
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