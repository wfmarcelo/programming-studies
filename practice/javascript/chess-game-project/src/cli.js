import { ChessGame } from './game.js';

console.log("--- Jogo de Xadrez no Terminal (Node.js) ---");

const game = new ChessGame();

console.log("\nTabuleiro Inicial:");
game.printBoard();

console.log(`\nTurno atual: ${game.currentTurn}`);

// Exemplo de um movimento: Mover o peão branco de a2 para a4
// (linha 6, coluna 0 para linha 4, coluna 0)
console.log("\nFazendo um movimento: Peão branco de a2 para a4");
game.makeMove({ row: 6, col: 0 }, { row: 4, col: 0 });

console.log("\nTabuleiro após o movimento:");
game.printBoard();

console.log(`\nTurno atual: ${game.currentTurn}`);

// Exemplo de outro movimento: Mover o peão preto de a7 para a5
// (linha 1, coluna 0 para linha 3, coluna 0)
console.log("\nFazendo um movimento: Peão preto de a7 para a5");
game.makeMove({ row: 1, col: 0 }, { row: 3, col: 0 });

console.log("\nTabuleiro após o segundo movimento:");
game.printBoard();

console.log(`\nTurno atual: ${game.currentTurn}`);

// Você pode adicionar mais lógica aqui para simular o jogo,
// receber entradas do usuário, etc.