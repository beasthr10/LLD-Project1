package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Board{
    private int size;
    private List<List<Cell>> board;

    //Constructor
    public Board(int dimension) {
        size = dimension;
        board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                board.get(i).add(new Cell(i, j)); // Initialize each cell with its coordinates
            }
        }
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

    public void display() {
        for(List<Cell> row : board){
            for(Cell cell : row){
                cell.displaycell();
            }
            System.out.println("");
        }
    }


    public void reset() {

    }


    public boolean isValidPosition(Cell cell) {
        return true;
    }
}
