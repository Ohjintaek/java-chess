package chess.domain.position;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Direction {

    LEFT(-1, 0,
        (p1, p2) -> p1.getFileDifference(p2) > 0 && p1.isSameRank(p2)),
    RIGHT(1, 0,
        (p1, p2) -> p1.getFileDifference(p2) < 0 && p1.isSameRank(p2)),
    UP(0, 1,
        (p1, p2) -> p1.isSameFile(p2) && p1.getRankDifference(p2) < 0),
    DOWN(0, -1,
        (p1, p2) -> p1.isSameFile(p2) && p1.getRankDifference(p2) > 0),
    LEFTUP(-1, 1,
        (p1, p2) -> p1.getFileDifference(p2) > 0 && p1.getRankDifference(p2) < 0),
    RIGHTUP(1, 1,
        (p1, p2) -> p1.getFileDifference(p2) < 0 && p1.getRankDifference(p2) < 0),
    LEFTDOWN(-1, -1,
        (p1, p2) -> p1.getFileDifference(p2) > 0 && p1.getRankDifference(p2) > 0),
    RIGHTDOWN(1, -1,
        (p1, p2) -> p1.getFileDifference(p2) < 0 && p1.getRankDifference(p2) > 0);

    private static final String CAN_NOT_JUDGE_DIRECTION = "[ERROR] 방향을 판단할 수 없습니다.";

    private final int fileIncrement;
    private final int rankIncrement;
    private final BiPredicate<Position, Position> condition;

    Direction(final int fileIncrement, final int rankIncrement, final BiPredicate<Position, Position> condition) {
        this.fileIncrement = fileIncrement;
        this.rankIncrement = rankIncrement;
        this.condition = condition;
    }

    public static Direction judge(final Position source, final Position target) {
        return Arrays.stream(Direction.values())
            .filter(direction -> direction.condition.test(source, target))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(CAN_NOT_JUDGE_DIRECTION));
    }

    public static Position getIncreasedPositionByDirection(final Position source, final Direction direction) {
        return source.getIncreasedPositionByDifference(direction.fileIncrement, direction.rankIncrement);
    }
}