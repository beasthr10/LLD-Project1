package org.example.Model.Strategy;

import org.example.Model.Board;
import org.example.Model.Move;

public class GameRuleIMP implements GameRule{
    @Override
    public Boolean checkDraw(Board board, Move move) {
        return null;
    }

    @Override
    public Boolean checkWin(Board board, Move move) {
        return null;
    }

    @Override
    public String getRuleInfo() {
        return "";
    }
}
