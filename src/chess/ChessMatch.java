package chess;

import boardGame.Board;
import boardGame.Position;
import chess.pieces.*;

public class ChessMatch {
	private Board board;
	
	public ChessMatch() {
		this.board = new Board(8, 8);
		initialSetup();
	}
	
	// cria uma matriz de peças de xadrez
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i = 0; i < board.getRows(); i++) {
			for(int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		
		return mat;
	}
	
	private void initialSetup() {
		this.board.placePiece(new Rook(this.board, Color.WHITE), new Position(2, 1));
		this.board.placePiece(new king(this.board, Color.BLACK), new Position(0, 4));
		this.board.placePiece(new king(this.board, Color.WHITE), new Position(7, 4));
	}
}
