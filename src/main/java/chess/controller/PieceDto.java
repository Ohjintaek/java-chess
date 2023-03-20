package chess.controller;

import chess.domain.chesspiece.*;

public class PieceDto {
    private final String team;
    private final String type;

    private PieceDto(final String team, final String type) {
        this.team = team;
        this.type = type;
    }

    public static PieceDto from(final Piece piece) {
        String type = "EMPTY_PIECE";
        if (piece instanceof Pawn) {
            type = "PAWN";
        }
        if (piece instanceof Knight) {
            type = "KNIGHT";
        }
        if (piece instanceof Bishop) {
            type = "BISHOP";
        }
        if (piece instanceof Rook) {
            type = "ROOK";
        }
        if (piece instanceof Queen) {
            type = "QUEEN";
        }
        if (piece instanceof King) {
            type = "KING";
        }
        return new PieceDto(piece.getSide(), type);
    }

    public String getSide() {
        return team;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return
                type;
    }
}
