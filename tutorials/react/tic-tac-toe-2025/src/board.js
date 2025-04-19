import Square from "./square";

export default function Board({ xIsNext, squares, onPlay }) {

  const board = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8]
  ];
  
  function handleClick(i) {
    if (squares[i] || calculateWinner(squares)) return;

    const nextSquares = squares.slice();
    nextSquares[i] = xIsNext ? "X" : "O";

    onPlay(nextSquares);
  }

  const winner = calculateWinner(squares);
  let status =
    winner
      ? `Winner: ${winner}`
      : `Next player: ${xIsNext ? "X" : "O"}`


  return (
    <>
      <div className="status">{status}</div>
      {
        board.map((row, i) =>
          <div className="board-row" key={i}>
            {
              row.map((column, i) =>
                <Square key={i} value={squares[column]} onSquareClick={() => handleClick(column)} />
              )
            }
          </div>
        )
      }

    </>
  );
}

function calculateWinner(squares) {
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6]
  ]

  for (let i = 0; i < lines.length; i++) {
    const [a, b, c] = lines[i];
    if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c])
      return squares[a];
  }

  return null
}