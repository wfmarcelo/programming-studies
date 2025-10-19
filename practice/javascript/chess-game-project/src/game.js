// This file contains the game logic for the chess game, including the rules of chess, turn management, and game state.

import { Pawn, Rook, Knight, Bishop, Queen, King } from './pieces.js'; // Importe todas as classes de peças

export class ChessGame {
    constructor() {
        this.board = this.initializeBoard();
        this.currentTurn = 'white';
        this.gameOver = false;
    }

    initializeBoard() {
        const board = Array(8).fill(null).map(() => Array(8).fill(null));

        // Peças Pretas
        board[0][0] = new Rook('black');
        board[0][1] = new Knight('black');
        board[0][2] = new Bishop('black');
        board[0][3] = new Queen('black');
        board[0][4] = new King('black');
        board[0][5] = new Bishop('black');
        board[0][6] = new Knight('black');
        board[0][7] = new Rook('black');
        for (let i = 0; i < 8; i++) {
            board[1][i] = new Pawn('black');
        }

        // Peças Brancas
        board[7][0] = new Rook('white');
        board[7][1] = new Knight('white');
        board[7][2] = new Bishop('white');
        board[7][3] = new Queen('white');
        board[7][4] = new King('white');
        board[7][5] = new Bishop('white');
        board[7][6] = new Knight('white');
        board[7][7] = new Rook('white');
        for (let i = 0; i < 8; i++) {
            board[6][i] = new Pawn('white');
        }

        return board;
    }

    makeMove(from, to) {
        if (this.gameOver) {
            console.log("Game is over. No more moves allowed.");
            return false; // Retorna false se o movimento não for feito
        }

        const pieceToMove = this.board[from.row][from.col];
        const targetSquarePiece = this.board[to.row][to.col];

        // 1. Verifica se há uma peça na posição de origem
        if (!pieceToMove) {
            console.log("Nenhuma peça na posição inicial.");
            return false;
        }

        // 2. Verifica se é o turno correto
        if (pieceToMove.color !== this.currentTurn) {
            console.log(`É o turno de ${this.currentTurn}. Não pode mover a peça ${pieceToMove.color}.`);
            return false;
        }

        // 3. Verifica se a peça está tentando capturar uma peça da mesma cor
        if (targetSquarePiece && targetSquarePiece.color === pieceToMove.color) {
            console.log("Não pode capturar sua própria peça.");
            return false;
        }

        // 4. Valida o movimento usando o método canMove da peça
        // Por enquanto, canMove é um placeholder e sempre retorna true.
        // Você implementará as regras reais do xadrez aqui.
        if (!pieceToMove.canMove(from, to, this.board)) {
            console.log("Movimento inválido para esta peça.");
            return false;
        }

        // 5. Executa o movimento
        this.board[to.row][to.col] = pieceToMove;
        this.board[from.row][from.col] = null;

        // 6. Troca os turnos
        this.currentTurn = this.currentTurn === 'white' ? 'black' : 'white';
        console.log(`Moveu ${pieceToMove.color} ${pieceToMove.type} de ${from.row},${from.col} para ${to.row},${to.col}`);
        console.log(`Turno atual: ${this.currentTurn}`);

        // 7. Verifica condições de fim de jogo (xeque-mate, empate, etc.)
        this.checkGameOver();

        return true; // Retorna true se o movimento foi bem-sucedido
    }

    checkGameOver() {
        // Lógica para verificar se o jogo terminou
        return false;
    }

    printBoard() {
        console.log("  a b c d e f g h");
        console.log(" +-----------------");
        this.board.forEach((row, rowIndex) => {
            const displayRow = row.map(piece => {
                if (piece === null) return '.';
                const pieceChar = piece.type.charAt(0);
                return piece.color === 'white' ? pieceChar.toUpperCase() : pieceChar.toLowerCase();
            }).join(' ');
            console.log(`${8 - rowIndex}|${displayRow}`);
        });
        console.log(" +-----------------");
    }
}

// Remova ou comente esta linha, pois a classe será importada e instanciada onde for necessário.
// const chessGame = new ChessGame();