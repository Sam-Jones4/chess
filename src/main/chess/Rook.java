package chess;

import java.util.ArrayList;
import java.util.Collection;

public class Rook extends ChessPieceImpl
{
    public Rook(ChessGame.TeamColor teamColor)
    {
        super(PieceType.ROOK, teamColor);
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition)
    {
        ArrayList<ChessMove> possibleMoves = new ArrayList<>();
        ChessPosition endPosition;

        for (int i = 1; i < 9; i++)
        {
            endPosition = new ChessPositionImpl(myPosition.getRow() + i, myPosition.getColumn());
            if (isInBounds(endPosition))
            {
                if (board.getPiece(endPosition) != null)
                {
                    if (board.getPiece(endPosition).getTeamColor() != getTeamColor())
                    {
                        ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                        possibleMoves.add(officialMove);
                        break;
                    }
                    else
                    {
                        break;
                    }
                }
                else
                {
                    ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                    possibleMoves.add(officialMove);
                }
            }
        }

        for (int i = 1; i < 9; i++)
        {
            endPosition = new ChessPositionImpl(myPosition.getRow() - i, myPosition.getColumn());
            if (isInBounds(endPosition))
            {
                if (board.getPiece(endPosition) != null)
                {
                    if (board.getPiece(endPosition).getTeamColor() != getTeamColor())
                    {
                        ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                        possibleMoves.add(officialMove);
                        break;
                    }
                    else
                    {
                        break;
                    }
                }
                else
                {
                    ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                    possibleMoves.add(officialMove);
                }
            }
        }

        for (int i = 1; i < 9; i++)
        {
            endPosition = new ChessPositionImpl(myPosition.getRow(), myPosition.getColumn() + i);
            if (isInBounds(endPosition))
            {
                if (board.getPiece(endPosition) != null)
                {
                    if (board.getPiece(endPosition).getTeamColor() != getTeamColor())
                    {
                        ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                        possibleMoves.add(officialMove);
                        break;
                    }
                    else
                    {
                        break;
                    }
                }
                else
                {
                    ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                    possibleMoves.add(officialMove);
                }
            }
        }

        for (int i = 1; i < 9; i++)
        {
            endPosition = new ChessPositionImpl(myPosition.getRow(), myPosition.getColumn() - i);
            if (isInBounds(endPosition))
            {
                if (board.getPiece(endPosition) != null)
                {
                    if (board.getPiece(endPosition).getTeamColor() != getTeamColor())
                    {
                        ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                        possibleMoves.add(officialMove);
                        break;
                    }
                    else
                    {
                        break;
                    }
                }
                else
                {
                    ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                    possibleMoves.add(officialMove);
                }
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
