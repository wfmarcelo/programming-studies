

export class Tiro {
    constructor(context, nave) {
        this.context = context;
        this.nave = nave;

        this.largura = 3;
        this.altura = 10;
        this.x = nave.x + 18;
        this.y = nave.y - this.altura;
        this.velocidade = 400;
        this.cor = 'yellow';

        nave.tiro.som.currentTime = 0.0;
        nave.tiro.som.play();
    }

    atualizar() {
        this.y -= 
            this.velocidade * this.animacao.decorrido / 1000  ;

        if (this.y < -this.altura) {
            this.animacao.excluirSprite(this);
            this.colisor.excluirSprite(this);
        }

    }

    desenhar() {
        const ctx = this.context;
        ctx.save();
        ctx.fillStyle = this.cor;
        ctx.fillRect(this.x, this.y, this.largura, this.altura);
        ctx.restore();
    }

    retangulosColisao() {
        return [
            {
                x: this.x,
                y: this.y,
                largura: this.largura,
                altura: this.altura
            }
        ];
    }

    colidiuCom() {

    }
}