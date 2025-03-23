const DIRECAO_ESQUERDA = 1;
const DIRECAO_DIREITA = 2;


class Heroi {
    constructor(context, teclado, animacao) {
        this.context = context;
        this.teclado = teclado;
        this.animacao = animacao;
        this.x = 0;
        this.y = 0;

        this.direcao = DIRECAO_DIREITA;
    }

    atualizar() {
        if (this.teclado.pressionada(SETA_ESQUERDA) && this.x > 0) {
            this.direcao = DIRECAO_ESQUERDA;
            this.x -= 10;
        } else if (this.teclado.pressionada(SETA_DIREITA) &&
        this.x < this.context.canvas.width - 20) {
                this.direcao = DIRECAO_DIREITA;
            this.x += 10;
        }
    }

    desenhar() {
        this.context.fillRect(this.x, this.y, 20, 50);
    }

    atirar() {
        const tiro = new Bola(this.context);
        tiro.x = this.x + 10;
        tiro.y = this.y + 10;
        tiro.raio = 2;
        tiro.cor = 'red';

        if (this.direcao == DIRECAO_ESQUERDA) {
            tiro.velocidadeX = -20;
        } else {
            tiro.velocidadeX = 20;
        }

        this.animacao.novoSprite(tiro);
    }
}