import { Ovni } from "./ovni.js";
import { Teclado } from "./teclado.js";
import { Tiro } from "./tiro.js";
import { Spritesheet } from "./spritesheet.js";
import { Explosao } from "./explosao.js";

export class Nave {
    constructor(context, teclado, imagem, explosao, tiro) {
        this.context = context;
        this.teclado = teclado;
        this.imagem = imagem;
        this.x = 0;
        this.y = 0;
        this.velocidade = 0;
        this.pontosVida = 3;
        this.spritesheet = new Spritesheet(context, imagem, 3, 2);
        this.spritesheet.linha = 0;
        this.spritesheet.intervalo = 100;
        this.explosao = explosao;
        this.tiro = tiro;
    }

    atualizar() {
        const incremento =
            this.velocidade * this.animacao.decorrido / 1000;

        if (this.teclado.pressionada(Teclado.SETA_ESQUERDA) && this.x > 0)
            this.x -= incremento;

        if (this.teclado.pressionada(Teclado.SETA_DIREITA)
            && this.x < this.context.canvas.width - 36)
            this.x += incremento;

        if (this.teclado.pressionada(Teclado.SETA_ACIMA) && this.y > 0)
            this.y -= incremento;

        if (this.teclado.pressionada(Teclado.SETA_ABAIXO)
            && this.y < this.context.canvas.height - 48)
            this.y += incremento;
    }

    desenhar() {
        if (this.teclado.pressionada(Teclado.SETA_ESQUERDA))
            this.spritesheet.linha = 1;
        else if (this.teclado.pressionada(Teclado.SETA_DIREITA))
            this.spritesheet.linha = 2;
        else
            this.spritesheet.linha = 0;

        this.spritesheet.desenhar(this.x, this.y);
        this.spritesheet.proximoQuadro();
    }

    atirar() {
        const t = new Tiro(this.context, this);
        this.animacao.novoSprite(t);
        this.colisor.novoSprite(t);
    }

    retangulosColisao() {
        const rets =
            [
                {
                    x: this.x + 2,
                    y: this.y + 19,
                    largura: 9,
                    altura: 13
                },
                {
                    x: this.x + 13,
                    y: this.y + 3,
                    largura: 10,
                    altura: 33
                },
                {
                    x: this.x + 25,
                    y: this.y + 19,
                    largura: 9,
                    altura: 13
                }
            ];


        return rets;

    }

    colidiuCom(outro) {
        if (outro instanceof Ovni) {
            this.pontosVida--;

            this.animacao.excluirSprite(outro);
            this.colisor.excluirSprite(outro);

            const expOutro = new Explosao(this.context, this.explosao.imagem,
                this.explosao.som, outro.x, outro.y);

            this.animacao.novoSprite(expOutro);

        }

        if (this.pontosVida == 0) {
            const expThis = new Explosao(this.context, this.explosao.imagem,
                this.explosao.som, this.x, this.y);
            this.animacao.excluirSprite(this);
            this.animacao.novoSprite(expThis);

            expThis.fimDaExplosao = () => {
                this.animacao.desligar();
                alert('GAME OVER');
            }
        }


    }
}