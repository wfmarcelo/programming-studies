// This file defines the base Piece class and its subclasses for each chess piece type.

export class Piece {
    constructor(color, type) {
        this.color = color;
        this.type = type; // e.g., 'pawn', 'rook', 'knight'
    }

    // Método abstrato a ser implementado pelas subclasses
    canMove(startPos, endPos, board) {
        // Por enquanto, apenas um placeholder.
        // A lógica real de movimento para cada peça será implementada aqui.
        console.log(`${this.color} ${this.type} tentando mover de ${startPos.row},${startPos.col} para ${endPos.row},${endPos.col}`);
        return true; // Por padrão, permite qualquer movimento para fins de teste inicial
    }

    // Ajuda a obter o nome do arquivo SVG da peça
    getFileName() {
        const colorPrefix = this.color === 'white' ? 'w' : 'b';
        const typeChar = this.type.charAt(0); // 'p', 'r', 'n', 'b', 'q', 'k'
        return `${colorPrefix}${typeChar}.svg`;
    }
}

export class Pawn extends Piece {
    constructor(color) {
        super(color, 'pawn');
    }
    canMove(startPos, endPos, board) {
        // Lógica de movimento do peão será implementada aqui
        return super.canMove(startPos, endPos, board);
    }
}

export class Rook extends Piece {
    constructor(color) {
        super(color, 'rook');
    }
    canMove(startPos, endPos, board) {
        // Lógica de movimento da torre será implementada aqui
        return super.canMove(startPos, endPos, board);
    }
}

export class Knight extends Piece {
    constructor(color) {
        super(color, 'knight');
    }
    canMove(startPos, endPos, board) {
        // Lógica de movimento do cavalo será implementada aqui
        return super.canMove(startPos, endPos, board);
    }
}

export class Bishop extends Piece {
    constructor(color) {
        super(color, 'bishop');
    }
    canMove(startPos, endPos, board) {
        // Lógica de movimento do bispo será implementada aqui
        return super.canMove(startPos, endPos, board);
    }
}

export class Queen extends Piece {
    constructor(color) {
        super(color, 'queen');
    }
    canMove(startPos, endPos, board) {
        // Lógica de movimento da rainha será implementada aqui
        return super.canMove(startPos, endPos, board);
    }
}

export class King extends Piece {
    constructor(color) {
        super(color, 'king');
    }
    canMove(startPos, endPos, board) {
        // Lógica de movimento do rei será implementada aqui
        return super.canMove(startPos, endPos, board);
    }
}