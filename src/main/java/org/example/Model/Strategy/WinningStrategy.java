package org.example.Model.Strategy;

import org.example.Model.Board;
import org.example.Model.Move;

public interface WinningStrategy {
    Boolean checkWin(Board board, Move move);
    void handleundo(Board board, Move move);
}
