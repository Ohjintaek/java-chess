package chess.piece.detail;

public enum Color {
    BLACK, WHITE, NONE;

    public boolean isBlack() {
        return this == BLACK;
    }

    public boolean hasSameColor(final Color color) {
        return this == color;
    }

    public Color reverse() {
        if (this == BLACK) {
            return WHITE;
        }

        if (this == WHITE) {
            return BLACK;
        }

        return NONE;
    }
}