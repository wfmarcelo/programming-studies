
import { Animacao } from "./models/animacao.js";
import { Colisor } from "./models/colisor.js";
import { Fundo } from "./models/fundo.js";
import { Nave } from "./models/nave.js";
import { Ovni } from "./models/ovni.js";
import { Teclado } from "./models/teclado.js";

const canvas = document.getElementById('canvas_animacao');
const context = canvas.getContext('2d');
const btnIniciar = document.getElementById('link_jogar');


const mostrarLinkJogar = () => {
    btnIniciar.style.display = 'block';
}

btnIniciar.onclick = () => {
    btnIniciar.style.display = 'none';
    assets.game.som.play();
    ativarTiro(true);
    teclado.disparou(Teclado.ENTER, pausarJogo);
    animacao.ligar();
}

const assets = {
    game: { som: 'musica-acao.mp3', imagem: 'fundo-espaco.png' },
    espaco: { imagem: 'fundo-espaco.png' },
    estrelas: { imagem: 'fundo-estrelas.png' },
    nuvens: { imagem: 'fundo-nuvens.png' },
    nave: { imagem: 'nave-spritesheet.png' },
    ovni: { imagem: 'ovni.png' },
    explosao: { imagem: 'explosao.png', som: 'explosao.mp3' },
    tiro: { som: 'tiro.mp3' },

};

let animacao;
let teclado;
let colisor;
let espaco;
let estrelas;
let nuvens;
let nave;

let totalAssets = 0;
let carregados = 0;
const tamanhoTotal = 300;

const carregando = () => {
    context.save();

    context.drawImage(
        assets.game.imagem, 0, 0,
        canvas.width, canvas.height);


    context.fillStyle = 'white';
    context.strokeStyle = 'black';
    context.font = '50px sans-serif';
    context.fillText("Carregando...", 100, 200);
    context.strokeText("Carregando...", 100, 200);

    carregados++;
    const tamanho = carregados / totalAssets * tamanhoTotal;
    context.fillStyle = 'yellow';
    context.fillRect(100, 50, tamanho, 50);

    context.restore();


    if (carregados == totalAssets) 
        iniciarObjectos();
        mostrarLinkJogar();
};

const iniciarObjectos = () => {

    animacao = new Animacao(context);
    teclado = new Teclado(document);
    colisor = new Colisor();
    espaco = new Fundo(context, assets.espaco.imagem);
    estrelas = new Fundo(context, assets.estrelas.imagem);
    nuvens = new Fundo(context, assets.nuvens.imagem);
    nave = new Nave(context,
        teclado,
        assets.nave.imagem,
        assets.explosao,
        assets.tiro);

    animacao.novoSprite(espaco);
    animacao.novoSprite(estrelas);
    animacao.novoSprite(nuvens);
    animacao.novoSprite(nave);

    colisor.novoSprite(nave);
    animacao.novoProcessamento(colisor);

    configuracoesIniciais();
    criacaoInimigos();
};

const configuracoesIniciais = () => {
    espaco.velocidade = 60;
    estrelas.velocidade = 150;
    nuvens.velocidade = 500;

    nave.x = canvas.width / 2 - 18;
    nave.y = canvas.height - 48;
    nave.velocidade = 200;

    assets.game.som.volume = 0.8;
    assets.game.som.loop = true;
};

const pausarJogo = () => {
    if (animacao.ligado) {
        assets.game.som.pause();
        animacao.desligar()
        ativarTiro(false);

        context.save();
        context.fillStyle = 'white';
        context.strokeStyle = 'black';
        context.font = '50px sans-serif';
        context.fillText("Pausado", 160, 200);
        context.strokeText("Pausado", 160, 200);
        context.restore();
    } else {
        criacaoInimigos.ultimoOvni = new Date().getTime();
        assets.game.som.play();
        animacao.ligar();
        ativarTiro(true);


    }
};

const ativarTiro = (ativar) => {
    ativar
        ? teclado.disparou(Teclado.ESPACO, () => { nave.atirar() })
        : teclado.disparou(Teclado.ESPACO, null);
}

const carregarAssets = () => {
    for (const i in assets) {

        if (assets[i].imagem) {

            const img = new Image();
            img.src = `img/${assets[i].imagem}`;
            img.onload = carregando;
            totalAssets++;

            assets[i].imagem = img;
        }

        if (assets[i].som) {
            const snd = new Audio();
            snd.src = `snd/${assets[i].som}`;
            snd.load();
            snd.volume = 0.2;

            assets[i].som = snd;
        }
    }
};


carregarAssets();

const novoOvni = () => {
    const imgOvni = assets.ovni.imagem;
    const ovni = new Ovni(context, imgOvni, assets.explosao.imagem, assets.explosao.som);

    ovni.velocidade =
        Math.floor(5 + Math.random() * (1000 - 500 + 1));

    ovni.x =
        Math.floor(Math.random() *
            (canvas.width - imgOvni.width + 1));

    ovni.y = -imgOvni.height;

    animacao.novoSprite(ovni);
    colisor.novoSprite(ovni);
};

const criacaoInimigos = () => {
    const criador = {
        ultimoOvni: new Date().getTime(),
        processar: () => {
            const agora = new Date().getTime();
            const decorrido = agora - criador.ultimoOvni;

            if (decorrido > 1000) {
                novoOvni();

                criador.ultimoOvni = agora;
            }
        }
    };

    animacao.novoProcessamento(criador);
};









