class Animacao {
    constructor(context) {
        this.context = context;
        this.sprites = [];
        this.ligado = false;
        this.processamentos = [];
        this.spritesExcluir = [];
        this.processamentosExcluir = [];
    }

    novoSprite(sprite) {
        this.sprites.push(sprite);
        sprite.animacao = this;
    }

    ligar() {
        this.ligado = true;
        this.proximoFrame();
    }

    desligar() {
        this.ligado = false;
    }

    proximoFrame() {
        if (!this.ligado) return;

        // this.limparTela();

        for (const i in this.sprites)
            this.sprites[i].atualizar();
        
        for (const i in this.sprites)
            this.sprites[i].desenhar();

        for (const i in this.processamentos)
            this.processamentos[i].processar();

        this.processarExclusoes();

        requestAnimationFrame(() => {
            this.proximoFrame();
        })
    }

    limparTela() {
        this.context.clearRect(0, 0, this.context.canvas.width, this.context.canvas.height)
    }

    novoProcessamento(processamento) {
        this.processamentos.push(processamento);
        processamento.animacao = this;
    }

    excluirSprite(sprite) {
        this.spritesExcluir.push(sprite);
    }
    
    excluirProcessamento(processamento) {
        this.processamentosExcluir.push(processamento);
    }

    processarExclusoes() {
        const novoSprites = [];
        const novoProcessamentos = [];

        for (const i in this.sprites) {
            if (this.spritesExcluir.indexOf(this.sprites[i]) == -1)
                novoSprites.push(this.sprites[i]);
        }
        
        for (const i in this.processamentos) {
            if (this.processamentosExcluir.indexOf(this.processamentos[i]) == -1)
                novoProcessamentos.push(this.processamentos[i]);
        }

        this.spritesExcluir = [];
        this.processamentosExcluir = [];

        this.sprites = novoSprites;
        this.processamentos = novoProcessamentos;
    }

}