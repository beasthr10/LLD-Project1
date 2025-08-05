package org.example.Model.Strategy;

import org.example.Model.Board;
import org.example.Model.Move;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy{
    private Map<Integer, HashMap<String,Integer>> counts = new HashMap<>();
    @Override
    public Boolean checkWin(Board board, Move move) {
        int colno = move.getCell().getCol();
        String symbol = move.getPlayer().getSymbol();
        if(!counts.containsKey(colno)) {
            counts.put(colno, new HashMap<>());
        }
        HashMap<String, Integer> colMap = counts.get(colno);
        if(!colMap.containsKey(symbol)) {
            colMap.put(symbol, 0);
        }
        colMap.put(symbol, colMap.get(symbol) + 1);
        if(colMap.get(symbol) == board.getSize()) {
            return true;
        }
        return false;
    }

    @Override
    public void handleundo(Board board, Move move) {
        int colno = move.getCell().getCol();
        String symbol = move.getPlayer().getSymbol();
        Map<String, Integer> colMap = counts.get(colno);
        colMap.put(symbol, colMap.get(symbol) - 1);
    }
}
