package chess.controller;

import java.util.Objects;

public enum GameStatus {
    START("start"),
    PLAYING("move"),
    END("end");

    private final String code;

    GameStatus(final String code) {
        this.code = code;
    }

    public static GameStatus startGame(String code) {
        if (Objects.equals(START.code, code)) {
            return START;
        }
        throw new IllegalArgumentException("게임을 시작하기 위해서는 start를 입력하세요");
    }

    public static GameStatus changeStatus(String code) {
        if (Objects.equals(START.code, code)) {
            throw new IllegalArgumentException("게임 도중에는 다시 시작할 수 없습니다.");
        }
        if (Objects.equals(PLAYING.code, code)) {
            return PLAYING;
        }
        if (Objects.equals(END.code, code)) {
            return END;
        }
        throw new IllegalArgumentException("잘못된 명령어입니다.");
    }

    public boolean isPlaying() {
        return this != GameStatus.END;
    }
}