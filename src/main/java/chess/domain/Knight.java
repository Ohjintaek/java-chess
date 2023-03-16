package chess.domain;

import java.util.ArrayList;
import java.util.List;

public class Knight implements Piece {
    private static final List<Knight> blackKnights = new ArrayList<>();
    private static final List<Knight> whiteKnights = new ArrayList<>();

    static {
        addKnights(blackKnights, Team.BLACK);
        addKnights(whiteKnights, Team.WHITE);
    }

    private final Team team;

    private Knight(final Team team) {
        this.team = team;
    }

    private static void addKnights(final List<Knight> Knights, final Team team) {
        for (int i = 0; i < 2; i++) {
            Knights.add(new Knight(team));
        }
    }

    public static List<Knight> of(final Team team) {
        if (team == Team.BLACK) {
            return List.copyOf(blackKnights);
        }
        return List.copyOf(whiteKnights);
    }

    @Override
    public Team getTeam() {
        return team;
    }
}
