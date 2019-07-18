package boardGame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: rows or columns less than 1");
		}
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	// para pegar a peça na posição desejada
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Error: Position not on the board");
		}
		return pieces[row][column];
	}
	
	// mesmo objetivo que a anterior mas utilizando um tipo posição
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Error: Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	// Função que adiciona uma determinada peça em determinada posição
	// do tabuleiro
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Error: There is already a piece on position " + position);
		}
		this.pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position; // podemos acessar por que poosition de piece é protected
	}
	
	// remove uma peça e a retorna
	// imagino que o retorno é para colocar em uma lista de peça capturadas
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		this.pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	// Funções que validam uma posição
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < this.rows && column >= 0 && column < this.columns; 
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	// verifica se existe uma peça na posição desejada 
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Error: Position not on the board");
		}
		return piece(position) != null;
	}
}
