package chess.domain;

public enum Team {
    WHITE("white"),
    BLACK("black");

    private String color;

    private Team(final String color) {
        this.color = color;
    }

    public String getTeam() {
        return color;
    }
}
