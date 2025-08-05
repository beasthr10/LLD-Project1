package org.example.Model.Strategy;

import org.example.Model.Board;
import org.example.Model.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{

    private Map<Integer, HashMap<String,Integer>> counts = new HashMap<>();
    @Override
    public Boolean checkWin(Board board, Move move) {
        int rowno = move.getCell().getRow();
        String symbol = move.getPlayer().getSymbol();
        if(!counts.containsKey(rowno)) {
            counts.put(rowno, new HashMap<>());
        }
        HashMap<String, Integer> rowMap = counts.get(rowno);
        if(!rowMap.containsKey(symbol)) {
            rowMap.put(symbol, 0);
        }
        rowMap.put(symbol, rowMap.get(symbol) + 1);
        if(rowMap.get(symbol) == board.getSize()) {
            return true;
        }
        return false;
    }

    @Override
    public void handleundo(Board board, Move move) {
        int rowno = move.getCell().getRow();
        String symbol = move.getPlayer().getSymbol();
        Map<String, Integer> rowMap = counts.get(rowno);
        rowMap.put(symbol, rowMap.get(symbol) - 1);
    }
}
