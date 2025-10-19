// This file serves as the entry point for the chess game, initializing the game and setting up event listeners.

import { ChessGame } from './game.js';
import { Board } from './board.js';

document.addEventListener('DOMContentLoaded', () => {
    const game = new ChessGame();
    const board = new Board('chess-board');

    let selectedSquareElement = null; // Armazena o elemento DOM do quadrado selecionado
    let selectedPiecePosition = null; // Armazena {row, col} da peça selecionada

    board.render(game.board); // Renderiza o tabuleiro inicial

    board.chessboardElement.addEventListener('click', (event) => {
        const targetSquareElement = event.target.closest('.board-square');

        if (!targetSquareElement) {
            // Clicou fora de um quadrado, deseleciona tudo
            board.unhighlightAllSquares();
            selectedSquareElement = null;
            selectedPiecePosition = null;
            return;
        }

        const row = parseInt(targetSquareElement.dataset.y);
        const col = parseInt(targetSquareElement.dataset.x);

        const clickedPiece = game.board[row][col];

        if (selectedSquareElement === null) {
            // Nenhuma peça selecionada ainda, tenta selecionar uma
            if (clickedPiece && clickedPiece.color === game.currentTurn) {
                selectedSquareElement = targetSquareElement;
                selectedPiecePosition = { row, col };
                board.highlightSquare(row, col, 'highlight-selected');
                // TODO: Em uma etapa futura, você pode adicionar lógica para destacar movimentos válidos aqui
            }
        } else {
            // Uma peça já está selecionada, tenta fazer um movimento
            const from = selectedPiecePosition;
            const to = { row, col };

            // Tenta fazer o movimento
            const moveMade = game.makeMove(from, to);

            // Após tentar um movimento, limpa a seleção e re-renderiza
            board.unhighlightAllSquares();
            selectedSquareElement = null;
            selectedPiecePosition = null;

            if (moveMade) {
                board.render(game.board); // Re-renderiza o tabuleiro se o movimento foi bem-sucedido
            }
        }
    });
});