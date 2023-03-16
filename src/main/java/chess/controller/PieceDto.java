package chess.controller;

import chess.domain.Piece;
import chess.domain.Team;

public class PieceDto {
    private final String team;
    private final String type;

    public PieceDto(final String team, final String type) {
        this.team = team;
        this.type = type;
    }

    public static PieceDto from(final Piece piece) {
        Class<? extends Piece> pieceClass = piece.getClass();
        Team team = piece.getTeam();

        return new PieceDto(team.getTeam(), pieceClass.toString());
    }

    public String getTeam() {
        return team;
    }

    public String getType() {
        return type;
    }
}
