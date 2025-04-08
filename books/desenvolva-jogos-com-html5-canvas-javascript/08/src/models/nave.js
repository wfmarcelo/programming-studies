import { Ovni } from "./ovni.js";
import { Teclado } from "./teclado.js";
import { Tiro } from "./tiro.js";

export class Nave {
    constructor(context, teclado, imagem) {
        this.context = context;
        this.teclado = teclado;
        this.imagem = imagem;
        this.x = 0;
        this.y = 0;
        this.velocidade = 0;
        this.pontosVida = 3;
    }

    atualizar() {
        const incremento =
            this.velocidade * this.animacao.decorrido / 1000;
        
        if (this.teclado.pressionada(Teclado.SETA_ESQUERDA) && this.x > 0)
            this.x -= incremento;

        if (this.teclado.pressionada(Teclado.SETA_DIREITA)
            && this.x < this.context.canvas.width - this.imagem.width)
            this.x += incremento;

        if (this.teclado.pressionada(Teclado.SETA_ACIMA) && this.y > 0)
            this.y -= incremento;

        if (this.teclado.pressionada(Teclado.SETA_ABAIXO)
            && this.y < this.context.canvas.height - this.imagem.height)
            this.y += incremento;
    }

    desenhar() {
        this.context.drawImage(this.imagem, this.x, this.y,
            this.imagem.width, this.imagem.height);
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

        // const ctx = this.context;

        // for (const i in rets) {
        //     ctx.save();
        //     ctx.strokeStyle = 'yellow';
        //     ctx.strokeRect(rets[i].x, rets[i].y, rets[i].largura, rets[i].altura);
        //     ctx.restore();
        // }

        return rets;

    }

    colidiuCom(outro) {
        if (outro instanceof Ovni) {
            this.pontosVida--;

            this.animacao.excluirSprite(outro);
            this.colisor.excluirSprite(outro);
            
        } 
        
        if (this.pontosVida == 0) {
            this.animacao.desligar();
            alert('GAME OVER');
        }
        

    }
}