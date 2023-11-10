package chess;

import java.util.ArrayList;
import java.util.Collection;

public class Knight extends ChessPieceImpl
{
    public Knight(ChessGame.TeamColor teamColor)
    {
        super(PieceType.KNIGHT, teamColor);
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition)
    {
        ArrayList<ChessMove> possibleMoves = new ArrayList<>();
        ChessPosition endPosition;

        endPosition = new ChessPositionImpl(myPosition.getRow() + 2, myPosition.getColumn() + 1);
        if (isInBounds(endPosition))
        {
            if (board.getPiece(endPosition) == null || board.getPiece(endPosition).getTeamColor() != getTeamColor())
            {
                ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                possibleMoves.add(officialMove);
            }
        }

        endPosition = new ChessPositionImpl(myPosition.getRow() + 2, myPosition.getColumn() - 1);
        if (isInBounds(endPosition))
        {
            if (board.getPiece(endPosition) == null || board.getPiece(endPosition).getTeamColor() != getTeamColor())
            {
                ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                possibleMoves.add(officialMove);
            }
        }

        endPosition = new ChessPositionImpl(myPosition.getRow() - 2, myPosition.getColumn() + 1);
        if (isInBounds(endPosition))
        {
            if (board.getPiece(endPosition) == null || board.getPiece(endPosition).getTeamColor() != getTeamColor())
            {
                ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                possibleMoves.add(officialMove);
            }
        }

        endPosition = new ChessPositionImpl(myPosition.getRow() - 2, myPosition.getColumn() - 1);
        if (isInBounds(endPosition))
        {
            if (board.getPiece(endPosition) == null || board.getPiece(endPosition).getTeamColor() != getTeamColor())
            {
                ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                possibleMoves.add(officialMove);
            }
        }

        endPosition = new ChessPositionImpl(myPosition.getRow() + 1, myPosition.getColumn() - 2);
        if (isInBounds(endPosition))
        {
            if (board.getPiece(endPosition) == null || board.getPiece(endPosition).getTeamColor() != getTeamColor())
            {
                ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                possibleMoves.add(officialMove);
            }
        }

        endPosition = new ChessPositionImpl(myPosition.getRow() - 1, myPosition.getColumn() - 2);
        if (isInBounds(endPosition))
        {
            if (board.getPiece(endPosition) == null || board.getPiece(endPosition).getTeamColor() != getTeamColor())
            {
                ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                possibleMoves.add(officialMove);
            }
        }

        endPosition = new ChessPositionImpl(myPosition.getRow() + 1, myPosition.getColumn() + 2);
        if (isInBounds(endPosition))
        {
            if (board.getPiece(endPosition) == null || board.getPiece(endPosition).getTeamColor() != getTeamColor())
            {
                ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                possibleMoves.add(officialMove);
            }
        }

        endPosition = new ChessPositionImpl(myPosition.getRow() - 1, myPosition.getColumn() + 2);
        if (isInBounds(endPosition))
        {
            if (board.getPiece(endPosition) == null || board.getPiece(endPosition).getTeamColor() != getTeamColor())
            {
                ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
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
