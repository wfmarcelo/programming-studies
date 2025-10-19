// This file handles the creation and rendering of the chessboard, including the placement of pieces.

export class Board {
    constructor(containerId) {
        this.squares = []; // Armazenará os elementos DOM dos quadrados
        this.chessboardElement = document.getElementById(containerId);
        this.createBoard(); // Cria os elementos DOM para os quadrados
        this.selectedSquare = null; // Para rastrear o elemento DOM do quadrado selecionado
    }

    createBoard() {
        this.chessboardElement.innerHTML = ''; // Limpa o conteúdo existente
        this.squares = []; // Garante que this.squares é uma nova matriz

        for (let i = 0; i < 8; i++) {
            const rowElements = []; // Armazena elementos DOM para esta linha
            const rowElement = document.createElement('div');
            rowElement.className = 'board-row';

            for (let j = 0; j < 8; j++) {
                const squareElement = document.createElement('div');
                squareElement.className = 'board-square';
                squareElement.dataset.x = j; // Índice da coluna
                squareElement.dataset.y = i; // Índice da linha

                const isLight = (i + j) % 2 === 0;
                squareElement.classList.add(isLight ? 'light-square' : 'dark-square');

                rowElement.appendChild(squareElement);
                rowElements.push(squareElement); // Armazena referência ao elemento DOM
            }
            this.chessboardElement.appendChild(rowElement);
            this.squares.push(rowElements); // Armazena a linha de elementos DOM
        }
    }

    render(boardState) { // boardState é o array 2D de ChessGame.board (objetos Piece ou null)
        // Itera sobre os elementos DOM (this.squares) e atualiza seu conteúdo
        boardState.forEach((row, rowIndex) => {
            row.forEach((piece, colIndex) => {
                const squareElement = this.squares[rowIndex][colIndex];
                squareElement.innerHTML = ''; // Limpa a imagem da peça anterior

                if (piece) { // Se houver um objeto Piece
                    const pieceImage = document.createElement('img');
                    pieceImage.src = `/assets/pieces/${piece.getFileName()}`; // Usa piece.getFileName()
                    pieceImage.alt = `${piece.color} ${piece.type}`;
                    pieceImage.className = 'piece-image';
                    squareElement.appendChild(pieceImage);
                }
            });
        });
    }

    highlightSquare(row, col, className = 'highlight-selected') {
        const squareElement = this.squares[row][col];
        if (squareElement) {
            squareElement.classList.add(className);
        }
    }

    unhighlightAllSquares() {
        this.squares.flat().forEach(squareElement => {
            squareElement.classList.remove('highlight-selected');
            squareElement.classList.remove('highlight-valid-move'); // Remove também os destaques de movimentos válidos
        });
    }

    // O método placePiece não é mais usado diretamente para renderização inicial,
    // mas pode ser útil para colocação dinâmica de peças, se necessário.
    placePiece(piece, row, col) {
        // Esta lógica agora colocaria um objeto Piece no tabuleiro visual.
        // É melhor usar render(game.board) depois que game.board for atualizado.
    }
}