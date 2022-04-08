package chess.domain.state;

import chess.domain.Board;
import chess.domain.Score;
import chess.domain.postion.Position;

import java.util.List;

public final class Ready implements State {

    private final Board board;

    public Ready(final Board board) {
        this.board = board;
    }

    @Override
    public State start() {
        return new White(board);
    }

    @Override
    public State end() {
        return new End();
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public State changeTurn(final List<Position> positions) {
        throw new IllegalArgumentException("Ready 상태에서는 chageTurn할 수 없습니다.");
    }

    @Override
    public Score status() {
        return Score.from(board());
    }

    @Override
    public Board board() {
        return board;
    }
}