package org.example.Model.Strategy;

import org.example.Model.Board;
import org.example.Model.Move;

public interface GameRule {
    Boolean checkDraw(Board board, Move move);
    java.util.List<WinningStrategy> winningStrategies(Board board, Move move);
    String getRuleInfo();
}
