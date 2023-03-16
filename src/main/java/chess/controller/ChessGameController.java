package chess.controller;

import chess.domain.ChessBoard;
import chess.domain.ChessBoardFactory;
import chess.view.InputView;
import chess.view.OutputView;

public class ChessGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public ChessGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        ChessBoard chessBoard = new ChessBoardFactory().generate();
        printChessBoard(chessBoard);
    }

    private void printChessBoard(ChessBoard chessBoard) {
        outputView.printChessBoard(ChessBoardDto.of(chessBoard.getPieces()));
    }
}
