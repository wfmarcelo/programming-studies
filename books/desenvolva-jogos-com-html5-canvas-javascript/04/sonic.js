const SONIC_DIREITA = 1;
const SONIC_ESQUERDA = 2;

class Sonic {
    constructor(context, teclado, imagem) {
        this.context = context;
        this.teclado = teclado;
        this.x = 0;
        this.y = 0;

        this.sheet = new Spritesheet(context, imagem, 3, 8);
        this.sheet.intervalo = 60;

        this.andando = false;
        this.direcao = SONIC_DIREITA;

        this.velocidade = 10;
    }

    atualizar() {
        if (this.teclado.pressionada(SETA_DIREITA)) {
            if (!this.andando || this.direcao != SONIC_DIREITA) {
                this.sheet.linha = 1;
                this.sheet.coluna = 0;
            }

            this.andando = true;
            this.direcao = SONIC_DIREITA;

            this.sheet.proximoQuadro();

            this.x += this.velocidade;

        } else if (this.teclado.pressionada(SETA_ESQUERDA)) {
            if (!this.andando || this.direcao != SONIC_ESQUERDA) {
                this.sheet.linha = 2;
                this.sheet.coluna = 0;
            }

            this.andando = true;
            this.direcao = SONIC_ESQUERDA;
            this.sheet.proximoQuadro();
            this.x -= this.velocidade;
        } else {
            if (this.direcao == SONIC_DIREITA)
                this.sheet.coluna = 0;
            else if (this.direcao == SONIC_ESQUERDA)
                this.sheet.coluna = 1;

            this.sheet.linha = 0;
            this.andando = false;
        }
    }

    desenhar() {
        this.sheet.desenhar(this.x, this.y);
    }
}