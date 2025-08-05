package org.example.Model.Strategy;

import org.example.Model.Board;
import org.example.Model.Move;

public class AntiDiagnoalWinningStrategy implements WinningStrategy{
    @Override
    public Boolean checkWin(Board board, Move move) {
        return false;
    }

    @Override
    public void handleundo(Board board, Move move) {

    }
}
