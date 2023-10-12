package chess;

import java.util.ArrayList;
import java.util.Collection;

public class ChessGameImpl implements ChessGame
{
    ChessBoard chessBoard;
    TeamColor currentTurnTeam;

    public ChessGameImpl()
    {}


    public ChessGameImpl(ChessBoard chessBoard, TeamColor currentTurnTeam)
    {
        this.chessBoard = chessBoard;
        this.currentTurnTeam = currentTurnTeam;
    }


    @Override
    public TeamColor getTeamTurn()
    {
        return currentTurnTeam;
    }

    @Override
    public void setTeamTurn(TeamColor team)
    {
        currentTurnTeam = team;
    }

    @Override
    public Collection<ChessMove> validMoves(ChessPosition startPosition)
    {
        ArrayList<ChessMove> allValidMoves = new ArrayList<>();
        ChessPiece focusPiece = chessBoard.getPiece(startPosition);

        if (chessBoard.getPiece(startPosition) == null)
        {
            return null;
        }

        for (ChessMove move : focusPiece.pieceMoves(chessBoard, startPosition))
        {
            ChessPiece endPositionPiece = chessBoard.getPiece(move.getEndPosition());
            chessBoard.addPiece(move.getEndPosition(), focusPiece);
            chessBoard.addPiece(startPosition, null);
            if (!isInCheck(focusPiece.getTeamColor()))
            {
                allValidMoves.add(move);
            }
            chessBoard.addPiece(move.getEndPosition(), endPositionPiece);
            chessBoard.addPiece(startPosition, focusPiece);
        }

        return allValidMoves;
    }

    @Override
    public void makeMove(ChessMove move) throws InvalidMoveException
    {
        ArrayList<ChessMove> possibleMoves = new ArrayList<>();
        possibleMoves.addAll(validMoves(move.getStartPosition()));

        if (chessBoard.getPiece(move.getStartPosition()).getTeamColor() != getTeamTurn())
        {
            throw new InvalidMoveException();
        }

        if (possibleMoves.contains(move))
        {
            if (chessBoard.getPiece(move.getStartPosition()).getPieceType() != ChessPiece.PieceType.PAWN)
            {
                chessBoard.addPiece(move.getEndPosition(), chessBoard.getPiece(move.getStartPosition()));
                chessBoard.addPiece(move.getStartPosition(), null);
            }
            else
            {
                if (move.getPromotionPiece() != null)
                {
                    ChessPiece promotedPawn = null;

                    switch (move.getPromotionPiece())
                    {
                        case QUEEN -> promotedPawn = new Queen(getTeamTurn());
                        case ROOK -> promotedPawn = new Rook(getTeamTurn());
                        case BISHOP -> promotedPawn = new Bishop(getTeamTurn());
                        case KNIGHT -> promotedPawn = new Knight(getTeamTurn());
                    }
                    chessBoard.addPiece(move.getEndPosition(), promotedPawn);
                    chessBoard.addPiece(move.getStartPosition(), null);
                }
                else
                {
                    chessBoard.addPiece(move.getEndPosition(), chessBoard.getPiece(move.getStartPosition()));
                    chessBoard.addPiece(move.getStartPosition(), null);
                }
            }

        }
        else
        {
            throw new InvalidMoveException();
        }

        if (getTeamTurn() == TeamColor.BLACK)
        {
            setTeamTurn(TeamColor.WHITE);
        }
        else
        {
            setTeamTurn(TeamColor.BLACK);
        }

    }

    @Override
    public boolean isInCheck(TeamColor teamColor)
    {
        ChessPosition kingPosition = null;

        for (int i = 1; i < 9; i++)
        {
            for (int j = 1; j < 9; j++)
            {
                ChessPosition currentPosition = new ChessPositionImpl(i,j);
                if (chessBoard.getPiece(currentPosition) != null && chessBoard.getPiece(currentPosition).getPieceType() == ChessPiece.PieceType.KING && chessBoard.getPiece(currentPosition).getTeamColor() == teamColor)
                {
                    kingPosition = currentPosition;
                }
            }
        }

        // iterate over every square but only do something if it's an enemy piece
        for (int i = 1; i < 9; i++)
        {
            for (int j = 1; j < 9; j++)
            {
                ChessPosition currentPosition = new ChessPositionImpl(i,j);
                if (chessBoard.getPiece(currentPosition) != null && chessBoard.getPiece(currentPosition).getTeamColor() != teamColor)
                {
                    ChessPiece enemyPiece = chessBoard.getPiece(currentPosition);
                    for (ChessMove move: enemyPiece.pieceMoves(chessBoard, currentPosition))
                    {
                        if (move.getEndPosition().equals(kingPosition))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean isInCheckmate(TeamColor teamColor)
    {
        if (isInCheck(teamColor))
        {
            for (int i = 1; i < 9; i++)
            {
                for (int j = 1; j < 9; j++)
                {
                    ChessPosition currentPosition = new ChessPositionImpl(i,j);
                    ChessPiece focusPiece = chessBoard.getPiece(currentPosition);
                    if (focusPiece != null && chessBoard.getPiece(currentPosition).getTeamColor() == teamColor)
                    {
                        if (!validMoves(currentPosition).isEmpty())
                        {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean isInStalemate(TeamColor teamColor)
    {
        if (!isInCheck(teamColor))
        {
            for (int i = 1; i < 9; i++)
            {
                for (int j = 1; j < 9; j++)
                {
                    ChessPosition currentPosition = new ChessPositionImpl(i,j);
                    ChessPiece focusPiece = chessBoard.getPiece(currentPosition);
                    if (focusPiece != null && focusPiece.getTeamColor() == teamColor)
                    {
                        if (!validMoves(currentPosition).isEmpty())
                        {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void setBoard(ChessBoard board)
    {
        chessBoard = board;
    }

    @Override
    public ChessBoard getBoard()
    {
        return chessBoard;
    }
}
