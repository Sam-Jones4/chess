package chess;

import com.google.gson.*;

import java.lang.reflect.Type;
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

    private static JsonDeserializer<ChessPiece> pieceAdapter = new JsonDeserializer<ChessPiece>()
    {
        @Override
        public ChessPiece deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException
        {
            ChessPieceImpl chessPiece = new Gson().fromJson(jsonElement, ChessPieceImpl.class);
            if (chessPiece.getPieceType() == PieceType.PAWN)
            {
                return new Gson().fromJson(jsonElement, Pawn.class);
            }
            else if (chessPiece.getPieceType() == PieceType.KING)
            {
                return new Gson().fromJson(jsonElement, King.class);
            }
            else if (chessPiece.getPieceType() == PieceType.QUEEN)
            {
                return new Gson().fromJson(jsonElement, Queen.class);
            }
            else if (chessPiece.getPieceType() == PieceType.ROOK)
            {
                return new Gson().fromJson(jsonElement, Rook.class);
            }
            else if (chessPiece.getPieceType() == PieceType.BISHOP)
            {
                return new Gson().fromJson(jsonElement, Bishop.class);
            }
            else if (chessPiece.getPieceType() == PieceType.KNIGHT)
            {
                return new Gson().fromJson(jsonElement, Knight.class);
            }
            return new Gson().fromJson(jsonElement, ChessPieceImpl.class);
        }
    };

    public static JsonDeserializer<ChessPiece> getAdapter()
    {
        return pieceAdapter;
    }


}
