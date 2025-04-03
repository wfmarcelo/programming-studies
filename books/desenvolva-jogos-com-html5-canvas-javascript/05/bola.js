class Bola {
    constructor(context) {
        this.context = context;
        this.x = 0;
        this.y = 0;
        this.velocidadeX = 0;
        this.velocidadeY = 0;

        this.cor = 'black';
        this.raio = 10;
    }

    atualizar() {
        const context = this.context;

        if (this.x < this.raio ||
            this.x > context.canvas.width - this.raio) {
            this.velocidadeX *= -1;
        }

        if (this.y < this.raio ||
            this.y > context.canvas.height - this.raio) {
            this.velocidadeY *= -1;
        }

        this.x += this.velocidadeX;
        this.y += this.velocidadeY;
    }

    desenhar() {
        const context = this.context;

        context.save();

        context.fillStyle = this.cor;

        context.beginPath();
        context.arc(this.x, this.y, this.raio, 0, 2 * Math.PI, false);
        context.fill();

        context.restore();
    }

    retangulosColisao() {
        return [
            {
                x: this.x - this.raio,
                y: this.y - this.raio,
                largura: this.raio * 2,
                altura: this.raio * 2

            }
        ];
    }

    colidiuCom(sprite) {
        if (this.x < sprite.x)
            this.velocidadeX = -Math.abs(this.velocidadeX);
        else
            this.velocidadeX = Math.abs(this.velocidadeX);

        if (this.y < sprite.y)
            this.velocidadeY = -Math.abs(this.velocidadeY);
        else
            this.velocidadeY = Math.abs(this.velocidadeY);
    }
}