package chess;

import java.util.ArrayList;
import java.util.Collection;

public class Pawn extends ChessPieceImpl
{
    public Pawn(ChessGame.TeamColor teamColor)
    {
        super(PieceType.PAWN, teamColor);
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition)
    {
        ArrayList<ChessMove> possibleMoves = new ArrayList<>();
        ChessPosition endPosition;
        ChessPosition jumpedSquare;

        // White pawn moves
        if(myPosition.getRow() == 2 && getTeamColor() == ChessGame.TeamColor.WHITE)
        {
            jumpedSquare = new ChessPositionImpl(myPosition.getRow() + 1, myPosition.getColumn());
            endPosition = new ChessPositionImpl(myPosition.getRow() + 2, myPosition.getColumn());
            if (isInBounds(endPosition))
            {
                if (board.getPiece(endPosition) == null && board.getPiece(jumpedSquare) == null)
                {
                    ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                    possibleMoves.add(officialMove);
                }
            }
        }
        if(getTeamColor() == ChessGame.TeamColor.WHITE)
        {
            endPosition = new ChessPositionImpl(myPosition.getRow() + 1, myPosition.getColumn());
            if (isInBounds(endPosition))
            {
                if (board.getPiece(endPosition) == null && endPosition.getRow() != 8)
                {
                    ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                    possibleMoves.add(officialMove);
                }
            }

        }
        if(getTeamColor() == ChessGame.TeamColor.WHITE)
        {
            endPosition = new ChessPositionImpl(myPosition.getRow() + 1, myPosition.getColumn() - 1);
            if (isInBounds(endPosition))
            {
                if (!(board.getPiece(endPosition) == null) && board.getPiece(endPosition).getTeamColor() != ChessGame.TeamColor.WHITE)
                {
                    if (endPosition.getRow() == 8)
                    {
                        for (PieceType promoPiece : PieceType.values()) {
                            if (promoPiece != PieceType.KING && promoPiece != PieceType.PAWN) {
                                ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, promoPiece);
                                possibleMoves.add(officialMove);
                            }
                        }
                    }
                    else
                    {
                        ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                        possibleMoves.add(officialMove);
                    }
                }
            }
        }
        if(getTeamColor() == ChessGame.TeamColor.WHITE)
        {
            endPosition = new ChessPositionImpl(myPosition.getRow() + 1, myPosition.getColumn() + 1);
            if (isInBounds(endPosition))
            {
                if (!(board.getPiece(endPosition) == null) && board.getPiece(endPosition).getTeamColor() != ChessGame.TeamColor.WHITE)
                {
                    if (endPosition.getRow() == 8)
                    {
                        for (PieceType promoPiece : PieceType.values()) {
                            if (promoPiece != PieceType.KING && promoPiece != PieceType.PAWN) {
                                ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, promoPiece);
                                possibleMoves.add(officialMove);
                            }
                        }
                    }
                    else
                    {
                        ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                        possibleMoves.add(officialMove);
                    }
                }
            }
        }
        if (getTeamColor() == ChessGame.TeamColor.WHITE)
        {
            endPosition = new ChessPositionImpl(myPosition.getRow() + 1, myPosition.getColumn());
            if (isInBounds(endPosition))
            {
                if (endPosition.getRow() == 8 && board.getPiece(endPosition) == null)
                {
                    for (PieceType promoPiece : PieceType.values())
                    {
                        if (promoPiece != PieceType.KING && promoPiece != PieceType.PAWN)
                        {
                            ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, promoPiece);
                            possibleMoves.add(officialMove);
                        }
                    }
                }
            }
        }

        // Black pawn moves
        if(myPosition.getRow() == 7 && getTeamColor() == ChessGame.TeamColor.BLACK)
        {
            jumpedSquare = new ChessPositionImpl(myPosition.getRow() - 1, myPosition.getColumn());
            endPosition = new ChessPositionImpl(myPosition.getRow() - 2, myPosition.getColumn());
            if (isInBounds(endPosition))
            {
                if (board.getPiece(endPosition) == null && board.getPiece(jumpedSquare) == null)
                {
                    ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                    possibleMoves.add(officialMove);
                }
            }
        }
        if(getTeamColor() == ChessGame.TeamColor.BLACK)
        {
            endPosition = new ChessPositionImpl(myPosition.getRow() - 1, myPosition.getColumn());
            if (isInBounds(endPosition))
            {
                if (board.getPiece(endPosition) == null && endPosition.getRow() != 1)
                {
                    ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                    possibleMoves.add(officialMove);
                }
            }
        }
        if(getTeamColor() == ChessGame.TeamColor.BLACK)
        {
            endPosition = new ChessPositionImpl(myPosition.getRow() - 1, myPosition.getColumn() + 1);
            if (isInBounds(endPosition))
            {
                if (!(board.getPiece(endPosition) == null) && board.getPiece(endPosition).getTeamColor() != ChessGame.TeamColor.BLACK)
                {
                    if (endPosition.getRow() == 1)
                    {
                        for (PieceType promoPiece : PieceType.values()) {
                            if (promoPiece != PieceType.KING && promoPiece != PieceType.PAWN) {
                                ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, promoPiece);
                                possibleMoves.add(officialMove);
                            }
                        }
                    }
                    else
                    {
                        ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                        possibleMoves.add(officialMove);
                    }
                }
            }
        }
        if(getTeamColor() == ChessGame.TeamColor.BLACK)
        {
            endPosition = new ChessPositionImpl(myPosition.getRow() - 1, myPosition.getColumn() - 1);
            if (isInBounds(endPosition))
            {
                if (!(board.getPiece(endPosition) == null) && board.getPiece(endPosition).getTeamColor() != ChessGame.TeamColor.BLACK)
                {
                    if (endPosition.getRow() == 1)
                    {
                        for (PieceType promoPiece : PieceType.values()) {
                            if (promoPiece != PieceType.KING && promoPiece != PieceType.PAWN) {
                                ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, promoPiece);
                                possibleMoves.add(officialMove);
                            }
                        }
                    }
                    else
                    {
                        ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, null);
                        possibleMoves.add(officialMove);
                    }
                }
            }
        }
        if (getTeamColor() == ChessGame.TeamColor.BLACK)
        {
            endPosition = new ChessPositionImpl(myPosition.getRow() - 1, myPosition.getColumn());
            if (isInBounds(endPosition))
            {
                if (endPosition.getRow() == 1 && board.getPiece(endPosition) == null)
                {
                    for (PieceType promoPiece : PieceType.values())
                    {
                        if (promoPiece != PieceType.KING && promoPiece != PieceType.PAWN)
                        {
                            ChessMove officialMove = new ChessMoveImpl(myPosition, endPosition, promoPiece);
                            possibleMoves.add(officialMove);
                        }
                    }
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