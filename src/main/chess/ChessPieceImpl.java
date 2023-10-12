package chess;

import java.util.Collection;

public abstract class ChessPieceImpl implements ChessPiece
{
    private PieceType pieceType;
    private ChessGame.TeamColor teamColor;

    public ChessPieceImpl(PieceType pieceType, ChessGame.TeamColor teamColor)
    {
        this.pieceType = pieceType;
        this.teamColor = teamColor;
    }

    @Override
    public ChessGameImpl.TeamColor getTeamColor() {
        return teamColor;
    }

    @Override
    public PieceType getPieceType()
    {
        return pieceType;
    }

    @Override
    public abstract Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition);


}
