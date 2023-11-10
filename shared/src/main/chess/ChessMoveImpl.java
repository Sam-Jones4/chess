package chess;

import java.util.Objects;

public class ChessMoveImpl implements ChessMove
{
    private ChessPosition startPosition;
    private ChessPosition endPosition;
    private ChessPiece.PieceType promoPiece;

    public ChessMoveImpl(ChessPosition start, ChessPosition end, ChessPiece.PieceType promotionPiece)
    {
        startPosition = start;
        endPosition = end;
        promoPiece = promotionPiece;
    }

    @Override
    public ChessPosition getStartPosition()
    {
        return startPosition;
    }

    @Override
    public ChessPosition getEndPosition()
    {
        return endPosition;
    }

    @Override
    public ChessPiece.PieceType getPromotionPiece()
    {
        return promoPiece;
    }

    @Override
    public String toString() {
        return "ChessMoveImpl{" +
                "startPosition=" + startPosition +
                ", endPosition=" + endPosition +
                ", promoPiece=" + promoPiece +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessMoveImpl chessMove = (ChessMoveImpl) o;
        return Objects.equals(startPosition, chessMove.startPosition) && Objects.equals(endPosition, chessMove.endPosition) && promoPiece == chessMove.promoPiece;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(startPosition, endPosition, promoPiece);
    }
}
