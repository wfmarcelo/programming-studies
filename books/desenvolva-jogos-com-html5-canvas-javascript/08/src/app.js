
import { Animacao } from "./models/animacao.js";
import { Colisor } from "./models/colisor.js";
import { Fundo } from "./models/fundo.js";
import { Nave } from "./models/nave.js";
import { Ovni } from "./models/ovni.js";
import { Teclado } from "./models/teclado.js";

const canvas = document.getElementById('canvas_animacao');
const context = canvas.getContext('2d');

const imagens = {
    espaco: 'fundo-espaco.png',
    estrelas: 'fundo-estrelas.png',
    nuvens: 'fundo-nuvens.png',
    nave: 'nave.png',
    ovni: 'ovni.png'
};

let animacao;
let teclado;
let colisor;
let espaco;
let estrelas;
let nuvens;
let nave;

let totalImagens = 0;
let carregadas = 0;

const carregando = () => {
    carregadas++;
    if (carregadas == totalImagens) iniciarObjectos();
};



const iniciarObjectos = () => {
    animacao = new Animacao(context);
    teclado = new Teclado(document);
    colisor = new Colisor();
    espaco = new Fundo(context, imagens.espaco);
    estrelas = new Fundo(context, imagens.estrelas);
    nuvens = new Fundo(context, imagens.nuvens);
    nave = new Nave(context, teclado, imagens.nave);

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

    nave.x = canvas.width / 2 - imagens.nave.width / 2;
    nave.y = canvas.height - imagens.nave.height;
    nave.velocidade = 200;

    teclado.disparou(Teclado.ESPACO, () => {
        nave.atirar();
    })

    animacao.ligar();
};

const carregarImagens = () => {
    for (const i in imagens) {
        
        const img = new Image();
        img.src = `img/${imagens[i]}`;
        img.onload = carregando;
        totalImagens++;

        imagens[i] = img;
    }
};

carregarImagens();

const novoOvni = () => {
    const imgOvni = imagens.ovni;
    const ovni = new Ovni(context, imgOvni);

    ovni.velocidade = 
        Math.floor(5 + Math.random() * (1000 - 500 + 1)) ;

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









