package org.example.Model;

import java.util.List;

public class NormalBoard implements Board{
    private int size;
    private List<List<Cell>> board;

    //Getter&Setter
    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public List<List<Cell>> getBoard() {
        return board;
    }
    public int getSize() {
        return size;
    }

    //Methods
    @Override
    public void display() {}

    @Override
    public void reset() {

    }

    @Override
    public boolean isValidPosition(Cell cell) {
        return false;
    }
}
