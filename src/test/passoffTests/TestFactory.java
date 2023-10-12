package passoffTests;

import chess.*;

/**
 * Used for testing your code
 * Add in code using your classes for each method for each FIXME
 */
public class TestFactory {

    //Chess Functions
    //------------------------------------------------------------------------------------------------------------------
    public static ChessBoard getNewBoard()
    {
		return new ChessBoardImpl();
    }

    public static ChessGameImpl getNewGame()
    {
		return new ChessGameImpl();
    }

    public static ChessPiece getNewPiece(ChessGameImpl.TeamColor pieceColor, ChessPiece.PieceType type)
    {
		return switch (type)
        {
            case PAWN -> new Pawn(pieceColor);
            case KING -> new King(pieceColor);
            case QUEEN -> new Queen(pieceColor);
            case ROOK -> new Rook(pieceColor);
            case BISHOP -> new Bishop(pieceColor);
            case KNIGHT -> new Knight(pieceColor);
        };
    }

    public static ChessPosition getNewPosition(Integer row, Integer col)
    {
		return new ChessPositionImpl(row, col);
    }

    public static ChessMove getNewMove(ChessPosition startPosition, ChessPosition endPosition, ChessPiece.PieceType promotionPiece)
    {
		return new ChessMoveImpl(startPosition, endPosition, promotionPiece);
    }
    //------------------------------------------------------------------------------------------------------------------


    //Server API's
    //------------------------------------------------------------------------------------------------------------------
    public static String getServerPort()
    {
        return "8080";
    }
    //------------------------------------------------------------------------------------------------------------------


    //Websocket Tests
    //------------------------------------------------------------------------------------------------------------------
    public static Long getMessageTime()
    {
        /*
        Changing this will change how long tests will wait for the server to send messages.
        3000 Milliseconds (3 seconds) will be enough for most computers. Feel free to change as you see fit,
        just know increasing it can make tests take longer to run.
        (On the flip side, if you've got a good computer feel free to decrease it)
         */
        return 3000L;
    }
    //------------------------------------------------------------------------------------------------------------------
}
