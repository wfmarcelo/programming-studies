class Tiro {
    constructor(context, nave) {
        this.context = context;
        this.nave = nave;

        this.largura = 4;
        this.altura = 20;
        this.x = nave.x + nave.imagem.width / 2 - this.largura / 2;
        this.y = nave.y - this.altura;
        this.velocidade = 10;
        this.cor = 'red';
    }

    atualizar() {
        this.y -= this.velocidade;

        if (this.nave.teclado.pressionada(SETA_DIREITA))
            this.x += this.velocidade;
        if (this.nave.teclado.pressionada(SETA_ESQUERDA))
                this.x -= this.velocidade;
    }

    desenhar() {
        const ctx = this.context;
        ctx.save();
        ctx.fillStyle = this.cor;
        ctx.fillRect(this.x, this.y, this.largura, this.altura);
        ctx.restore();
    }
}