package ui;

import chess.*;

import java.util.Objects;
import java.util.Scanner;

public class GameUI
{
    public static void EnterCommand()
    {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            String command = scanner.next();
            if (Objects.equals(command, "help"))
            {
                System.out.print(EscapeSequences.SET_TEXT_COLOR_BLUE);
                System.out.println("redraw - redraws the chess board");
                System.out.println("leave - leave game");
                System.out.println("make move - input move you want to make");
                System.out.println("resign - forfeit the game");
                System.out.println("highlight - highlights the user's legal moves");
                System.out.println("help - with possible commands");
                System.out.print(EscapeSequences.RESET_TEXT_COLOR);
            }
            else if (command == "redraw")
            {

            }
            else if (command == "leave")
            {
                PostloginUI.EnterCommand();
            }
            else if (command == "make move")
            {

            }
            else if (command == "resign")
            {

            }
            else if (command == "highlight")
            {

            }
        }
    }

    public static void PrintWhiteBoard(ChessGameImpl game)
    {
        ChessBoard board = game.getBoard();

        String squareColor = EscapeSequences.SET_BG_COLOR_DARK_GREEN;

        for (int i = 8; i >= 1; i--)
        {
            System.out.print(squareColor);

            if (squareColor.equals(EscapeSequences.SET_BG_COLOR_DARK_GREEN)) {
                squareColor = EscapeSequences.SET_BG_COLOR_WHITE;
            } else {
                squareColor = EscapeSequences.SET_BG_COLOR_DARK_GREEN;
            }

            for (int j = 8; j >= 1; j--)
            {
                System.out.print(squareColor);

                if (squareColor.equals(EscapeSequences.SET_BG_COLOR_DARK_GREEN)) {
                    squareColor = EscapeSequences.SET_BG_COLOR_WHITE;
                } else {
                    squareColor = EscapeSequences.SET_BG_COLOR_DARK_GREEN;
                }

                ChessPositionImpl position = new ChessPositionImpl(i, j);
                if (board.getPiece(position) != null) {
                    if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.KING) {
                        if (board.getPiece(position).getTeamColor() == ChessGame.TeamColor.WHITE) {
                            System.out.print(EscapeSequences.WHITE_KING);
                        } else {
                            System.out.print(EscapeSequences.BLACK_KING);
                        }
                    } else if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.QUEEN) {
                        if (board.getPiece(position).getTeamColor() == ChessGame.TeamColor.WHITE) {
                            System.out.print(EscapeSequences.WHITE_QUEEN);
                        } else {
                            System.out.print(EscapeSequences.BLACK_QUEEN);
                        }
                    } else if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.ROOK) {
                        if (board.getPiece(position).getTeamColor() == ChessGame.TeamColor.WHITE) {
                            System.out.print(EscapeSequences.WHITE_ROOK);
                        } else {
                            System.out.print(EscapeSequences.BLACK_ROOK);
                        }
                    } else if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.BISHOP) {
                        if (board.getPiece(position).getTeamColor() == ChessGame.TeamColor.WHITE) {
                            System.out.print(EscapeSequences.WHITE_BISHOP);
                        } else {
                            System.out.print(EscapeSequences.BLACK_BISHOP);
                        }
                    } else if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.KNIGHT) {
                        if (board.getPiece(position).getTeamColor() == ChessGame.TeamColor.WHITE) {
                            System.out.print(EscapeSequences.WHITE_KNIGHT);
                        } else {
                            System.out.print(EscapeSequences.BLACK_KNIGHT);
                        }
                    } else if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.PAWN) {
                        if (board.getPiece(position).getTeamColor() == ChessGame.TeamColor.WHITE) {
                            System.out.print(EscapeSequences.WHITE_PAWN);
                        } else {
                            System.out.print(EscapeSequences.BLACK_PAWN);
                        }
                    }

                } else {
                    System.out.print(EscapeSequences.EMPTY);
                }
            }
            System.out.println(EscapeSequences.RESET_BG_COLOR);
        }
    }

    public static void PrintBlackBoard(ChessGameImpl game)
    {
        ChessBoard board = game.getBoard();

        String squareColor = EscapeSequences.SET_BG_COLOR_DARK_GREEN;

        for (int i = 1; i < 9; i++)
        {
            System.out.print(squareColor);

            if (squareColor.equals(EscapeSequences.SET_BG_COLOR_DARK_GREEN))
            {
                squareColor = EscapeSequences.SET_BG_COLOR_WHITE;
            } else
            {
                squareColor = EscapeSequences.SET_BG_COLOR_DARK_GREEN;
            }

            for (int j = 1; j < 9; j++)
            {
                System.out.print(squareColor);

                if (squareColor.equals(EscapeSequences.SET_BG_COLOR_DARK_GREEN)) {
                    squareColor = EscapeSequences.SET_BG_COLOR_WHITE;
                } else {
                    squareColor = EscapeSequences.SET_BG_COLOR_DARK_GREEN;
                }

                ChessPositionImpl position = new ChessPositionImpl(i, j);
                if (board.getPiece(position) != null) {
                    if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.KING) {
                        if (board.getPiece(position).getTeamColor() == ChessGame.TeamColor.BLACK) {
                            System.out.print(EscapeSequences.BLACK_KING);
                        } else {
                            System.out.print(EscapeSequences.WHITE_KING);
                        }
                    } else if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.QUEEN) {
                        if (board.getPiece(position).getTeamColor() == ChessGame.TeamColor.BLACK) {
                            System.out.print(EscapeSequences.BLACK_QUEEN);
                        } else {
                            System.out.print(EscapeSequences.WHITE_QUEEN);
                        }
                    } else if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.ROOK) {
                        if (board.getPiece(position).getTeamColor() == ChessGame.TeamColor.BLACK) {
                            System.out.print(EscapeSequences.BLACK_ROOK);
                        } else {
                            System.out.print(EscapeSequences.WHITE_ROOK);
                        }
                    } else if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.BISHOP) {
                        if (board.getPiece(position).getTeamColor() == ChessGame.TeamColor.BLACK) {
                            System.out.print(EscapeSequences.BLACK_BISHOP);
                        } else {
                            System.out.print(EscapeSequences.WHITE_BISHOP);
                        }
                    } else if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.KNIGHT) {
                        if (board.getPiece(position).getTeamColor() == ChessGame.TeamColor.BLACK) {
                            System.out.print(EscapeSequences.BLACK_KNIGHT);
                        } else {
                            System.out.print(EscapeSequences.WHITE_KNIGHT);
                        }
                    } else if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.PAWN) {
                        if (board.getPiece(position).getTeamColor() == ChessGame.TeamColor.BLACK) {
                            System.out.print(EscapeSequences.BLACK_PAWN);
                        } else {
                            System.out.print(EscapeSequences.WHITE_PAWN);
                        }
                    }

                } else {
                    System.out.print(EscapeSequences.EMPTY);
                }
            }
            System.out.println(EscapeSequences.RESET_BG_COLOR);
        }
    }
}
