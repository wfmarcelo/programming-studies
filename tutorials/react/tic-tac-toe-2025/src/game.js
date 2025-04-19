import { useState } from "react";
import Board from "./board";

export default function Game() {
    const [history, setHistory] = useState([Array(9).fill(null)]);
    const [currentMove, setCurrentMove] = useState(0);
    const [ascSort, setAscSort] = useState(true);

    const xIsNext = currentMove % 2 === 0;
    let currentSquares = history[currentMove];

    function handlePlay(nextSquares) {
        const nextHistory = [...history.slice(0, currentMove + 1), nextSquares]; 
        setHistory(nextHistory);
        setCurrentMove(nextHistory.length - 1);
    }

    function jumpTo(nextMove) {
        setCurrentMove(nextMove);
    }

    function sort() {
        setAscSort(!ascSort);
    }


    const moves = history.map((squares, move) => {
        
        const description =
            move > 0
                ? `Go to move #${move}`
                : 'Go to game start';

        let content = 
            <button onClick={() => jumpTo(move)}>{description}</button>;

        if (move == currentMove)
            content = <span>{`You are at move #${move}`}</span>;

        return (
            <li key={move}>
                {content}
            </li>
        )
    });

    return (
        <div className="game">
            <div className="game-board">
                <Board xIsNext={xIsNext} squares={currentSquares} onPlay={handlePlay} />
            </div>
            <div className="game-info">
                <ol>{moves}</ol>
            </div>
        </div>
    )
}