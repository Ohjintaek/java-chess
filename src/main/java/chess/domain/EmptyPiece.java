package chess.domain;

public class EmptyPiece implements Piece {
    @Override
    public Team getTeam() {
        return Team.WHITE;
    }
}
