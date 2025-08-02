package org.example.Model.Strategy;

import org.example.Model.Board;
import org.example.Model.Move;

import java.util.List;

public class GameRuleIMP implements GameRule{
    public List<WinningStrategy> winningStrategies;

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
