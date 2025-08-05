package org.example.Model.Strategy;

import org.example.Model.Board;
import org.example.Model.Move;

import java.util.List;

public class GameRuleIMP implements GameRule{
    public List<WinningStrategy> winningStrategies(Board board, Move move) {;
        return List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagnoalWinningStrategy(),
                new AntiDiagnoalWinningStrategy()
        );
    }

    @Override
    public Boolean checkDraw(Board board, Move move) {
       return null;
    }

    @Override
    public String getRuleInfo() {
        return "";
    }
}
