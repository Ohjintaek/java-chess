package chess.domain;

import chess.domain.chesspiece.EmptyPiece;
import chess.domain.chesspiece.InitialPawn;
import chess.domain.chesspiece.Pawn;
import chess.domain.chesspiece.Queen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("InitialPawn 클래스")
class InitialPawnTest {

    @Nested
    @DisplayName("from 메서드는")
    class from {
        @Nested
        @DisplayName("진영이 주어지면")
        class given_team {
            @Test
            @DisplayName("해당 진영의 InitialPawn을 1개 반환한다")
            void it_returns_initial_pawn() {
                InitialPawn initialPawn = InitialPawn.from(Side.BLACK);
                assertThat(initialPawn).isInstanceOf(InitialPawn.class);
                assertThat(initialPawn.isBlack()).isTrue();
            }
        }
    }

    @Nested
    @DisplayName("isMovable 메서드는")
    class isMovable {
        Pawn movedWhitePawn = Pawn.from(Side.WHITE);
        Square movedFrom = Square.of(Rank.THREE, File.B);
        Queen blackQueen = Queen.from(Side.BLACK);
        Queen whiteQueen = Queen.from(Side.WHITE);

        @Test
        @DisplayName("앞의 한 칸에 기물이 없으면 true를 반환한다")
        void it_returns_movable1() {
            Square movableSquare = Square.of(Rank.FOUR, File.B);

            assertThat(movedWhitePawn.isMovable(movedFrom, movableSquare, EmptyPiece.getInstance())).isTrue();
        }

        @Test
        @DisplayName("대각선 한 칸에 적 기물이 있으면 true를 반환한다")
        void it_returns_movable2() {
            Square diagonalSquare1 = Square.of(Rank.FOUR, File.A);
            Square diagonalSquare2 = Square.of(Rank.FOUR, File.C);

            assertThat(movedWhitePawn.isMovable(movedFrom, diagonalSquare1, blackQueen)).isTrue();
            assertThat(movedWhitePawn.isMovable(movedFrom, diagonalSquare2, blackQueen)).isTrue();
        }

        @Test
        @DisplayName("갈 수 없는 위치라면 false를 반환한다")
        void it_returns_not_movable1() {
            Square unableSquare = Square.of(Rank.FIVE, File.B);
            Square sameRankSquare = Square.of(Rank.THREE, File.C);
            Square backSquare = Square.of(Rank.TWO, File.B);

            assertThat(movedWhitePawn.isMovable(movedFrom, unableSquare, blackQueen)).isFalse();
            assertThat(movedWhitePawn.isMovable(movedFrom, sameRankSquare, blackQueen)).isFalse();
            assertThat(movedWhitePawn.isMovable(movedFrom, backSquare, blackQueen)).isFalse();
        }

        @Test
        @DisplayName("앞의 한 칸에 기물이 있으면 false를 반환한다")
        void it_returns_not_movable2() {
            Square movableSquare = Square.of(Rank.FOUR, File.B);

            assertThat(movedWhitePawn.isMovable(movedFrom, movableSquare, blackQueen)).isFalse();
        }

        @Test
        @DisplayName("대각선 한 칸 앞에 적 기물이 아니면 false를 반환한다")
        void it_returns_not_movable3() {
            Square movableSquare = Square.of(Rank.FOUR, File.C);

            assertThat(movedWhitePawn.isMovable(movedFrom, movableSquare, whiteQueen)).isFalse();
            assertThat(movedWhitePawn.isMovable(movedFrom, movableSquare, EmptyPiece.getInstance())).isFalse();
        }
    }
}