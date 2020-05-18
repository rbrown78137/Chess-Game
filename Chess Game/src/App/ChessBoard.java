package App;

import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
//import javafx.scene.layout.StackPane;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class ChessBoard extends Pane {
	int currentPlayer = 1;
	boolean hasClickedPiece = false;
	int clickedPieceRow = -1;
	int clickedPieceColumn = -1;
	int[][] board = new int[8][8];
	// row X column
	ArrayList<BoardStackPane> panes = new ArrayList<>();
	// form panes.get(x*8+y) x and y are locations on the map
	ArrayList<ChessPiece> pieces = new ArrayList<>();

	/*
	 * | 17| 18| 19| 20| 21| 22| 23| 24| | 25| 26| 27| 28| 29| 30| 31| 32| Top 2
	 * Rows ******************************** | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
	 * Bottom 2 Rows | 9 | 10| 11| 12| 13| 14| 15| 16|
	 * 
	 */
	ChessBoard() {
		// adds background chess board
		Pane chessBoardBackGround = new Pane();
		for (int i = 0; i < 8; i++) {
			for (int k = 0; k < 8; k++) {
				Rectangle rect = new Rectangle(i * 100, k * 100, 100, 100);
				if ((i + k) % 2 == 0) {
					rect.setFill(new Color((166.0 / 256), (134.0 / 256), (35.0 / 356), 1));
				} else {
					rect.setFill(new Color((102.0 / 256), (51.0 / 256), 0, 1));
				}
				chessBoardBackGround.getChildren().add(rect);

			}
		}
		getChildren().add(chessBoardBackGround);
		// adds panes for each square in chess board
		for (int i = 0; i < 8; i++) {
			for (int k = 0; k < 8; k++) {
				panes.add(new BoardStackPane(k, i));
				panes.get(i * 8 + k).setLayoutX(i * 100);
				panes.get(i * 8 + k).setLayoutY(k * 100);
				// added rectangle to ensure that stack panes would be 100 x 100
				Rectangle rect = new Rectangle(0, 0, 100, 100);
				rect.setFill(new Color(1, 1, 1, 0));
				// made it invisible so it can't be seen
				panes.get(i * 8 + k).getChildren().add(rect);
			}
		}
		// ADDS IN THE STARTING PIECES
		// Player 1
		// loop adds in pawns
		for (int i = 1; i <= 8; i++) {
			pieces.add(new ChessPiece(1, 1, (7), i));
			board[7 - 1][i - 1] = i;
			panes.get((i - 1) * 8 + ((7) - 1)).getChildren().add((pieces.get(i - 1).display));
		}
		pieces.add(new ChessPiece(1, 2, 8, 1)); // rook
		pieces.add(new ChessPiece(1, 3, 8, 2)); // knight
		pieces.add(new ChessPiece(1, 4, 8, 3)); // bishop
		pieces.add(new ChessPiece(1, 5, 8, 4)); // queen
		pieces.add(new ChessPiece(1, 6, 8, 5)); // king
		pieces.add(new ChessPiece(1, 4, 8, 6)); // bishop
		pieces.add(new ChessPiece(1, 3, 8, 7)); // knight
		pieces.add(new ChessPiece(1, 2, 8, 8)); // rook
		// form panes.get( column * 8 +row)
		// form panes.get(x*8+y)
		// refer to notes at panes and pieces decleration to understand format
		panes.get((1 - 1) * 8 + (8 - 1)).getChildren().add(pieces.get(9 - 1).display);
		panes.get((2 - 1) * 8 + (8 - 1)).getChildren().add(pieces.get(10 - 1).display);
		panes.get((3 - 1) * 8 + (8 - 1)).getChildren().add(pieces.get(11 - 1).display);
		panes.get((4 - 1) * 8 + (8 - 1)).getChildren().add(pieces.get(12 - 1).display);
		panes.get((5 - 1) * 8 + (8 - 1)).getChildren().add(pieces.get(13 - 1).display);
		panes.get((6 - 1) * 8 + (8 - 1)).getChildren().add(pieces.get(14 - 1).display);
		panes.get((7 - 1) * 8 + (8 - 1)).getChildren().add(pieces.get(15 - 1).display);
		panes.get((8 - 1) * 8 + (8 - 1)).getChildren().add(pieces.get(16 - 1).display);
		// add pieces to board
		board[8 - 1][1 - 1] = 9;
		board[8 - 1][2 - 1] = 10;
		board[8 - 1][3 - 1] = 11;
		board[8 - 1][4 - 1] = 12;
		board[8 - 1][5 - 1] = 13;
		board[8 - 1][6 - 1] = 14;
		board[8 - 1][7 - 1] = 15;
		board[8 - 1][8 - 1] = 16;
		// Player 2

		pieces.add(new ChessPiece(2, 2, 1, 1)); // rook
		pieces.add(new ChessPiece(2, 3, 1, 2)); // knight
		pieces.add(new ChessPiece(2, 4, 1, 3)); // bishop
		pieces.add(new ChessPiece(2, 5, 1, 4)); // queen
		pieces.add(new ChessPiece(2, 6, 1, 5)); // king
		pieces.add(new ChessPiece(2, 4, 1, 6)); // bishop
		pieces.add(new ChessPiece(2, 3, 1, 7)); // knight
		pieces.add(new ChessPiece(2, 2, 1, 8)); // rook
		// adds player display to board
		panes.get((1 - 1) * 8 + (1 - 1)).getChildren().add(pieces.get(17 - 1).display);
		panes.get((2 - 1) * 8 + (1 - 1)).getChildren().add(pieces.get(18 - 1).display);
		panes.get((3 - 1) * 8 + (1 - 1)).getChildren().add(pieces.get(19 - 1).display);
		panes.get((4 - 1) * 8 + (1 - 1)).getChildren().add(pieces.get(20 - 1).display);
		panes.get((5 - 1) * 8 + (1 - 1)).getChildren().add(pieces.get(21 - 1).display);
		panes.get((6 - 1) * 8 + (1 - 1)).getChildren().add(pieces.get(22 - 1).display);
		panes.get((7 - 1) * 8 + (1 - 1)).getChildren().add(pieces.get(23 - 1).display);
		panes.get((8 - 1) * 8 + (1 - 1)).getChildren().add(pieces.get(24 - 1).display);
		// adds pieces to board
		board[1 - 1][1 - 1] = 17;
		board[1 - 1][2 - 1] = 18;
		board[1 - 1][3 - 1] = 19;
		board[1 - 1][4 - 1] = 20;
		board[1 - 1][5 - 1] = 21;
		board[1 - 1][6 - 1] = 22;
		board[1 - 1][7 - 1] = 23;
		board[1 - 1][8 - 1] = 24;

		// loop adds in pawns for player 2
		for (int i = 1; i <= 8; i++) {
			pieces.add(new ChessPiece(2, 1, (2), i));
			board[2 - 1][i - 1] = i + 24;
			panes.get((i - 1) * 8 + ((2) - 1)).getChildren().add((pieces.get(i - 1 + 24).display));
		}
		// END OF ADDING IN PIECES;
		getChildren().addAll(panes); // puts Stack Panes into chess board
		// creates a listener for mouse clicks
		setOnMouseClicked(e -> {
			handleClick(e.getX(), e.getY());
		});
	}

	class ChessPiece {
		// inner class that defines individual chess pieces and what pieces look like
		static final int PAWN = 1, ROOK = 2, KNIGHT = 3, BISHOP = 4, QUEEN = 5, KING = 6;
		String imageName;
		ImageViewWithMarker display;
		int player;
		int type;
		boolean firstMove = true;
		boolean addedPawnMove = false;
		ArrayList<Integer> XMoves = new ArrayList<>();
		ArrayList<Integer> YMoves = new ArrayList<>();

		ChessPiece(int player, int type, int yLocation, int xLocation) {
			// X and Y flipped in constructor to switch from x by y view to row X column
			// view
			this.player = player;
			this.type = type;
			switch (type) {
			case PAWN:
				imageName = "/res/PAWN" + player + ".png";
				display = new ImageViewWithMarker(new Image(getClass().getResourceAsStream(imageName)));
				display.piece = this;
				if (player == 1) {
					XMoves.add(-1);YMoves.add(-1);
					XMoves.add(1);YMoves.add(-1);
					XMoves.add(0);YMoves.add(-1);
					XMoves.add(0);YMoves.add(-2);
				}
				if (player == 2) {
					XMoves.add(-1);YMoves.add(1);
					XMoves.add(1);YMoves.add(1);
					XMoves.add(0);YMoves.add(1);
					XMoves.add(0);YMoves.add(2);
				}
				break;
			case ROOK:
				imageName = "/res/ROOK" + player + ".png";
				display = new ImageViewWithMarker(new Image(getClass().getResourceAsStream(imageName)));
				display.piece = this;
				for (int i = 1; i <= 8; i++) {
					XMoves.add(i);YMoves.add(0);
				}
				for (int i = 1; i <= 8; i++) {
					XMoves.add(i * -1);YMoves.add(0);
				}
				for (int i = 1; i <= 8; i++) {
					YMoves.add(i);XMoves.add(0);
				}
				for (int i = 1; i <= 8; i++) {
					YMoves.add(i * -1);XMoves.add(0);
				}
				break;
			case KNIGHT:
				imageName = "/res/KNIGHT" + player + ".png";
				display = new ImageViewWithMarker(new Image(getClass().getResourceAsStream(imageName)));
				display.piece = this;
				XMoves.add(2);YMoves.add(1);
				XMoves.add(-2);YMoves.add(1);
				XMoves.add(2);YMoves.add(-1);
				XMoves.add(-2);YMoves.add(-1);
				XMoves.add(1);YMoves.add(2);
				XMoves.add(-1);YMoves.add(2);
				XMoves.add(1);YMoves.add(-2);
				XMoves.add(-1);YMoves.add(-2);
				break;
			case BISHOP:
				imageName = "/res/BISHOP" + player + ".png";
				display = new ImageViewWithMarker(new Image(getClass().getResourceAsStream(imageName)));
				display.piece = this;
				for (int i = 1; i <= 8; i++) {
					XMoves.add(i);YMoves.add(i);
					XMoves.add(i);YMoves.add(i * -1);
					XMoves.add(i * -1);YMoves.add(i);
					XMoves.add(i * -1);YMoves.add(i * -1);
				}
				break;
			case QUEEN:
				imageName = "/res/QUEEN" + player + ".png";
				display = new ImageViewWithMarker(new Image(getClass().getResourceAsStream(imageName)));
				display.piece = this;
				for (int i = 1; i <= 8; i++) {
					XMoves.add(i);YMoves.add(0);
				}
				for (int i = 1; i <= 8; i++) {
					XMoves.add(i * -1);YMoves.add(0);
				}
				for (int i = 1; i <= 8; i++) {
					YMoves.add(i);XMoves.add(0);
				}
				for (int i = 1; i <= 8; i++) {
					YMoves.add(i * -1);XMoves.add(0);
				}
				for (int i = 1; i <= 8; i++) {
					XMoves.add(i);YMoves.add(i);
					XMoves.add(i);YMoves.add(i * -1);
					XMoves.add(i * -1);YMoves.add(i);
					XMoves.add(i * -1);YMoves.add(i * -1);
				}
				break;
			case KING:
				imageName = "/res/KING" + player + ".png";
				display = new ImageViewWithMarker(new Image(getClass().getResourceAsStream(imageName)));
				display.piece = this;
				XMoves.add(1);YMoves.add(1);
				XMoves.add(-1);YMoves.add(1);
				XMoves.add(1);YMoves.add(-1);
				XMoves.add(-1);YMoves.add(-1);
				XMoves.add(0);YMoves.add(1);
				XMoves.add(0);YMoves.add(-1);
				XMoves.add(1);YMoves.add(0);
				XMoves.add(-1);YMoves.add(0);
				break;
			}

		}

	}

	public void handleClick(double X, double Y) {
		int row = (int) (Y / 100) + 1;
		int column = (int) (X / 100) + 1;
		System.out.println("row " + row + " column " + column);
		if (!hasClickedPiece) {
			clickedPieceRow = row;
			clickedPieceColumn = column;
			boolean isPiece = displayMoveableSpots(row, column);
			if (isPiece) {
				hasClickedPiece = true;
			}

		} else if (hasClickedPiece) {
			if (row == clickedPieceRow && column == clickedPieceColumn) {
				removeMoveableSpots();
				hasClickedPiece = false;
			} else if (canMove(row, column)) {
				System.out.println("can Move");
				removeMoveableSpots();
				movePiece(row, column);
				hasClickedPiece = false;
			}

		}
	}

	public boolean displayMoveableSpots(int row, int column) {
		Object[] objects = panes.get((column - 1) * 8 + (row - 1)).getChildren().toArray();
		for (Object object : objects) {
			if (object instanceof ImageViewWithMarker) {
				ImageViewWithMarker image = (ImageViewWithMarker) object;
				if (image.piece.player == currentPlayer) {
						for (int i = 0; i < image.piece.XMoves.size(); i++) {
							int x = image.piece.XMoves.get(i) + clickedPieceColumn;
							int y = image.piece.YMoves.get(i) + clickedPieceRow;
							if (x >= 1 && y >= 1 && x <= 8 && y <= 8 && canMove(y, x)) {
								panes.get((x - 1) * 8 + (y - 1)).getChildren().add(new MoveRect());
							}
						}

					MoveRect currentPieceRect = new MoveRect();
					// currentPieceRect.setFill(new Color((238.0/256),(244.0/256),(66.0/256),0.5));
					currentPieceRect.setFill(new Color(1, 0, 0, 0.5));
					panes.get((column - 1) * 8 + (row - 1)).getChildren().add(currentPieceRect);
					return true;
				}
			}
		}
		return false;
	}

	public void removeMoveableSpots() {
		for (int i = 1; i <= 8; i++) {
			for (int k = 1; k <= 8; k++) {
				Object[] objects = panes.get((k - 1) * 8 + (i - 1)).getChildren().toArray();
				for (Object object : objects) {
					if (object instanceof MoveRect) {
						panes.get((k - 1) * 8 + (i - 1)).getChildren().remove(object);
					}
				}
			}
		}
	}

	public boolean canMove(int row, int column) {
		int pieceNum = board[clickedPieceRow - 1][clickedPieceColumn - 1];
		if (isFriend(row, column, pieceNum))
			return false;
		if (!(pieceNum == 10 || pieceNum == 15 || pieceNum == 18 || pieceNum == 23)) {
			int rowDiff = row - clickedPieceRow;
			int columnDiff = column - clickedPieceColumn;
			int scans;
			// row diff and row mod used to reduce amount of code
			int rowMod = 0;
			int colMod = 0;

			if (rowDiff > 0) {
				rowMod = 1;
			} else if (rowDiff < 0) {
				rowMod = -1;
			} else {
				rowMod = 0;
			}

			if (columnDiff > 0) {
				colMod = 1;
			} else if (columnDiff < 0) {
				colMod = -1;
			} else {
				colMod = 0;
			}

			if (rowDiff > 0) {
				scans = rowDiff;
			} else if (rowDiff < 0) {
				scans = rowDiff * -1;
			} else if (columnDiff > 0) {
				scans = columnDiff;
			} else {
				scans = columnDiff * -1;
			}
			for (int i = 1; i <= scans; i++) {
				if (isPiece(clickedPieceRow + (i * rowMod), clickedPieceColumn + (i * colMod), pieceNum)) {
					if (!(clickedPieceRow + (i * rowMod) == row && clickedPieceColumn + (i * colMod) == column
							&& !isFriend(clickedPieceRow + (i * rowMod), clickedPieceColumn + (i * colMod), pieceNum)))
						return false;
				}
			}
		}
		boolean moveable = false;
		ChessPiece piece = pieces.get(pieceNum - 1);
		if(piece.type != 1) {
		for (int i = 0; i < piece.XMoves.size(); i++) {
			if ((clickedPieceRow + piece.YMoves.get(i)) == row
					&& column == (clickedPieceColumn + piece.XMoves.get(i))) {
				moveable = true;
			}
		}
		}
		if(piece.type == 1) {
			if(row == clickedPieceRow+piece.YMoves.get(0) && column == clickedPieceColumn+piece.XMoves.get(0) && board[row-1][column-1]!=0)
				moveable = true;
			if(row == clickedPieceRow+piece.YMoves.get(1) && column == clickedPieceColumn+piece.XMoves.get(1) && board[row-1][column-1]!=0)
				moveable = true;
			if(row == clickedPieceRow+piece.YMoves.get(2) && column == clickedPieceColumn+piece.XMoves.get(2) && board[row-1][column-1]==0)
				moveable = true;
			if(row == clickedPieceRow+piece.YMoves.get(3) && column == clickedPieceColumn+piece.XMoves.get(3) && board[row-1][column-1]==0 && piece.firstMove == true) 
				moveable = true;
		}
		return moveable;
	}

	public void movePiece(int row, int column) {
		int pieceNum = board[clickedPieceRow - 1][clickedPieceColumn - 1];
		System.out.println("piece num " + pieceNum);
		board[row - 1][column - 1] = pieceNum;
		board[clickedPieceRow - 1][clickedPieceColumn - 1] = 0;
		Object[] objects = panes.get((column - 1) * 8 + (row - 1)).getChildren().toArray();
		for (Object object : objects) {
			if (object instanceof ImageViewWithMarker)
				panes.get((column - 1) * 8 + (row - 1)).getChildren().remove(object);
		}
		Object[] objects2 = panes.get((clickedPieceColumn - 1) * 8 + (clickedPieceRow - 1)).getChildren().toArray();
		for (Object object : objects2) {
			if (object instanceof ImageViewWithMarker) {
				ImageViewWithMarker image = (ImageViewWithMarker) object;
				panes.get((clickedPieceColumn - 1) * 8 + (clickedPieceRow - 1)).getChildren().remove(object);
				panes.get((column - 1) * 8 + (row - 1)).getChildren().add(image);
			}
		}
		/*
		 * code for removing pawns 2 move start if( (pieceNum!=0 && pieceNum<=8) ||
		 * (pieceNum>=25) ) { if(pieces.get(pieceNum-1).firstMove) {
		 * pieces.get(pieceNum-1).XMoves.remove(3);
		 * pieces.get(pieceNum-1).YMoves.remove(3); pieces.get(pieceNum-1).firstMove =
		 * false; } if((row==1 || row==8) && !pieces.get(pieceNum-1).addedPawnMove) {
		 * ChessPiece piece = pieces.get(pieceNum-1); piece.XMoves.add(-1);
		 * piece.YMoves.add(1); piece.XMoves.add(0); piece.YMoves.add(1);
		 * piece.XMoves.add(1); piece.YMoves.add(1); piece.addedPawnMove = true;
		 * System.out.println(piece.XMoves.size()); } }
		 */
		if((pieceNum <=8 && pieceNum !=0) || pieceNum>24)
			pieces.get(pieceNum-1).firstMove = false;
		if (currentPlayer == 1)
			currentPlayer = 2;
		else if (currentPlayer == 2)
			currentPlayer = 1;
		printBoard();
	}

	public void printBoard() {
		for (int i = 0; i < 8; i++) {
			System.out.print("\n");
			for (int k = 0; k < 8; k++)
				System.out.printf("%4d", board[i][k]);
		}
	}

	public boolean isFriend(int row, int column, int pieceNum) {
		if (row >= 1 && row <= 8 && column <= 8 && column >= 1) {
			if (pieceNum <= 16) {
				if (board[row - 1][column - 1] <= 16 && (board[row - 1][column - 1] != 0))
					return true;
			} else {
				if (board[row - 1][column - 1] > 16)
					return true;
			}
		}
		return false;
	}

	public boolean isPiece(int row, int column, int pieceNum) {
		if (board[row - 1][column - 1] != 0) {
			return true;
		}
		return false;
	}
}

// class created to solve issue with finding source object of image
class ImageViewWithMarker extends ImageView {
	ChessBoard.ChessPiece piece;

	ImageViewWithMarker(Image image) {
		super(image);

	}
}

class MoveRect extends Rectangle {
	MoveRect() {
		super(0, 0, 100, 100);
		setFill(new Color(0, 1, 0, 0.5));
	}
}
