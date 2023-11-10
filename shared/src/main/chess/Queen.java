package chess;

import java.util.ArrayList;
import java.util.Collection;

public class Queen extends ChessPieceImpl
{
    public Queen(ChessGame.TeamColor teamColor)
    {
        super(PieceType.QUEEN, teamColor);
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition)
    {
        ArrayList<ChessMove> possibleMoves = new ArrayList<>();
        Bishop bishop = new Bishop(getTeamColor());
        Rook rook = new Rook(getTeamColor());

        possibleMoves.addAll(bishop.pieceMoves(board, myPosition));
        possibleMoves.addAll(rook.pieceMoves(board,myPosition));

        return possibleMoves;
    }
}
