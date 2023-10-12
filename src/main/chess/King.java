package chess;

import java.util.ArrayList;
import java.util.Collection;

public class King extends ChessPieceImpl
{
    public King(ChessGame.TeamColor teamColor)
    {
        super(PieceType.KING, teamColor);
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition)
    {
        ArrayList<ChessMove> possibleMoves = new ArrayList<>();

        ChessPosition up = new ChessPositionImpl(myPosition.getRow() + 1, myPosition.getColumn());
        if (isInBounds(up))
        {
            if (board.getPiece(up) == null || board.getPiece(up).getTeamColor() != getTeamColor())
            {
                ChessMove officialMove = new ChessMoveImpl(myPosition, up, null);
                possibleMoves.add(officialMove);
            }
        }

        ChessPosition upLeft = new ChessPositionImpl(myPosition.getRow() + 1, myPosition.getColumn() - 1);
        if (isInBounds(upLeft))
        {
            if (board.getPiece(upLeft) == null || board.getPiece(upLeft).getTeamColor() != getTeamColor())
            {
                ChessMove officialMove = new ChessMoveImpl(myPosition, upLeft, null);
                possibleMoves.add(officialMove);
            }
        }

        ChessPosition upRight = new ChessPositionImpl(myPosition.getRow() + 1, myPosition.getColumn() + 1);
        if (isInBounds(upRight))
        {
            if (board.getPiece(upRight) == null || board.getPiece(upRight).getTeamColor() != getTeamColor())
            {
                ChessMove officialMove = new ChessMoveImpl(myPosition, upRight, null);
                possibleMoves.add(officialMove);
            }
        }

        ChessPosition left = new ChessPositionImpl(myPosition.getRow(), myPosition.getColumn() - 1);
        if (isInBounds(left))
        {
            if (board.getPiece(left) == null || board.getPiece(left).getTeamColor() != getTeamColor())
            {
                ChessMove officialMove = new ChessMoveImpl(myPosition, left, null);
                possibleMoves.add(officialMove);
            }
        }

        ChessPosition right = new ChessPositionImpl(myPosition.getRow(), myPosition.getColumn() + 1);
        if (isInBounds(right))
        {
            if (board.getPiece(right) == null || board.getPiece(right).getTeamColor() != getTeamColor())
            {
                ChessMove officialMove = new ChessMoveImpl(myPosition, right, null);
                possibleMoves.add(officialMove);
            }
        }

        ChessPosition down = new ChessPositionImpl(myPosition.getRow() - 1, myPosition.getColumn());
        if (isInBounds(down))
        {
            if (board.getPiece(down) == null || board.getPiece(down).getTeamColor() != getTeamColor())
            {
                ChessMove officialMove = new ChessMoveImpl(myPosition, down, null);
                possibleMoves.add(officialMove);
            }
        }

        ChessPosition downLeft = new ChessPositionImpl(myPosition.getRow() - 1, myPosition.getColumn() - 1);
        if (isInBounds(downLeft))
        {
            if (board.getPiece(downLeft) == null || board.getPiece(downLeft).getTeamColor() != getTeamColor())
            {
                ChessMove officialMove = new ChessMoveImpl(myPosition, downLeft, null);
                possibleMoves.add(officialMove);
            }
        }

        ChessPosition downRight = new ChessPositionImpl(myPosition.getRow() - 1, myPosition.getColumn() + 1);
        if (isInBounds(downRight))
        {
            if (board.getPiece(downRight) == null || board.getPiece(downRight).getTeamColor() != getTeamColor())
            {
                ChessMove officialMove = new ChessMoveImpl(myPosition, downRight, null);
                possibleMoves.add(officialMove);
            }
        }

        return possibleMoves;
    }
    private boolean isInBounds(ChessPosition position)
    {
        if (position.getRow() > 8 || position.getRow() < 1)
        {
            return false;
        }
        if (position.getColumn() > 8 || position.getColumn() < 1)
        {
            return false;
        }
        return true;
    }

}
