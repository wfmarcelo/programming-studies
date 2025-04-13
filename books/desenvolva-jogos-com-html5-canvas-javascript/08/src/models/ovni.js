import { Explosao } from "./explosao.js";
import { Tiro } from "./tiro.js";

export class Ovni {
    constructor(context, imagem, imgExplosao, somExplosao) {
        this.context = context;
        this.imagem = imagem;
        this.x = 0;
        this.y = 0;
        this.velocidade = 0;

        this.imgExplosao = imgExplosao;
        this.somExplosao = somExplosao;
    }

    atualizar() {
        this.y += 
            this.velocidade * this.animacao.decorrido / 1000;

        if (this.y > this.context.canvas.height) {
            this.animacao.excluirSprite(this);
            this.colisor.excluirSprite(this);
        }
    }

    desenhar() {
        const ctx = this.context;
        const img = this.imagem;
        ctx.drawImage(img, this.x, this.y, img.width, img.height);
    }

    retangulosColisao() {
        const rets =
            [
                {
                    x: this.x + 20,
                    y: this.y + 1 ,
                    largura: 25,
                    altura: 10
                },
                {
                    x: this.x + 2,
                    y: this.y + 11 ,
                    largura: 60,
                    altura: 12
                },
                {
                    x: this.x + 20,
                    y: this.y + 23 ,
                    largura:   25,
                    altura: 17
                }
            ];

        return rets;
    }

    colidiuCom(outro) {
        if (outro instanceof Tiro) {

            
            this.animacao.excluirSprite(this);
            this.colisor.excluirSprite(this);
            this.animacao.excluirSprite(outro);
            this.colisor.excluirSprite(outro);

            const explosao = new Explosao(this.context, 
                this.imgExplosao, this.somExplosao, this.x, this.y);
            this.animacao.novoSprite(explosao);

        }
    }
}