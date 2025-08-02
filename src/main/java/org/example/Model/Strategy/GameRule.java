package org.example.Model.Strategy;

import org.example.Model.Board;
import org.example.Model.Move;

public interface GameRule {
    Boolean checkDraw(Board board, Move move);
    Boolean checkWin(Board board, Move move);
    String getRuleInfo();
}
