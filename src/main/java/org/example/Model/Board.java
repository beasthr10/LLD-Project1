package org.example.Model;

import java.util.List;

public class Board{
    private int size;
    private List<List<Cell>> board;

    public Board(int dimension) {

    }

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

    public void display() {}


    public void reset() {

    }


    public boolean isValidPosition(Cell cell) {
        return false;
    }
}
