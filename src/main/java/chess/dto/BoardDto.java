package chess.dto;

import chess.game.Board;
import chess.piece.Piece;
import chess.position.Column;
import chess.position.Position;
import chess.position.Row;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardDto {

    private static final int MAX_COLUMN_NUMBER = 8;
    private static final int MINIMUM_COLUMN_NUMBER = 1;
    private List<List<PieceDto>> value;

    private BoardDto(final List<List<PieceDto>> value) {
        this.value = value;
    }

    public static BoardDto toDto(Board board) {
        final List<List<PieceDto>> boardPieces = new ArrayList<>();
        final Map<Position, Piece> pieces = board.getValue();
        return createBoardDto(boardPieces, pieces);
    }

    public static BoardDto toDto(Map<Position, Piece> pieces) {
        final List<List<PieceDto>> boardPieces = new ArrayList<>();
        return createBoardDto(boardPieces, pieces);
    }

    private static PieceDto createPieceDto(final Map<Position, Piece> pieces, final Position position) {
        if (pieces.containsKey(position)) {
            return PieceDto.toDto(pieces.get(position), position);
        }
        return PieceDto.toEmptyDto("BLANK", position);
    }

    private static BoardDto createBoardDto(final List<List<PieceDto>> boardPieces, final Map<Position, Piece> pieces) {
        for (int i = MAX_COLUMN_NUMBER; i >= MINIMUM_COLUMN_NUMBER; i--) {
            final List<PieceDto> line = new ArrayList<>();
            for (int j = MINIMUM_COLUMN_NUMBER; j <= MAX_COLUMN_NUMBER; j++) {
                final Position position = Position.of(Column.of(j), Row.of(i));
                line.add(createPieceDto(pieces, position));
            }
            boardPieces.add(line);
        }

        return new BoardDto(boardPieces);
    }

    public List<List<PieceDto>> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "value=" + value +
                '}';
    }
}