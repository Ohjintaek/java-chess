package chess.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Square 클래스")
public class SquareTest {

    @Nested
    @DisplayName("of 메서드는")
    class of {
        @Nested
        @DisplayName("File과 Rank가 주어지면")
        class given_file_and_rank {
            Rank rank = Rank.ONE;
            File file = File.A;

            @Test
            @DisplayName("해당 위치의 Square를 반환한다")
            void it_returns_square() {
                assertThat(Square.of(rank, file))
                        .extracting("rank", "file")
                        .containsOnly(rank, file);
            }
        }
    }
}
