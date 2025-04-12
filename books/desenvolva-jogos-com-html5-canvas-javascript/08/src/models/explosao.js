import { Spritesheet } from "./spritesheet.js";

export class Explosao {
    constructor(context, imagem, x, y) {
        this.context = context;
        this.imagem = imagem;
        this.spritesheet = new Spritesheet(context, imagem, 1, 5);
        this.spritesheet.intervalo = 75;
        this.x = x;
        this.y = y;

        this.fimDaExplosao = null;

        this.spritesheet.fimDoCiclo = () => {
            this.animacao.excluirSprite(this);
            if (this.fimDaExplosao) this.fimDaExplosao();
        }
    }

    atualizar() {

    }

    desenhar() {
        this.spritesheet.desenhar(this.x, this.y);
        this.spritesheet.proximoQuadro();
    }
}