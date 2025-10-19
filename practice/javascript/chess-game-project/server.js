import express from 'express';
import path from 'path';
import { fileURLToPath } from 'url';

// Obter __dirname para módulos ES
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();
const PORT = process.env.PORT || 3000;

// 1. Rota principal para servir o index.html
// Esta rota deve vir ANTES de qualquer middleware estático que possa interceptar '/'
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

// 2. Servir arquivos estáticos da pasta 'public' para outros recursos (CSS, imagens, etc.)
// O 'index.html' já foi tratado pela rota acima, então este middleware cuidará de 'style.css' e outros.
app.use(express.static(path.join(__dirname, 'public')));

// 3. Servir arquivos da pasta 'src' para que o main.js possa importá-los
// O navegador fará requisições como /src/main.js, então precisamos mapear isso
app.use('/src', express.static(path.join(__dirname, 'src')));

// Iniciar o servidor
app.listen(PORT, () => {
    console.log(`Servidor rodando em http://localhost:${PORT}`);
    console.log('Abra seu navegador e acesse esta URL.');
});