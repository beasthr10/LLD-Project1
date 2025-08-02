package org.example.Model;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState cellState;

    // Constructor
    public Cell(int i, int j) {
        this.row = i;
        this.col = j;
        this.cellState = CellState.EMPTY; // Initialize cell state to EMPTY
        this.player = null;
    }
    // Getter & Setter


    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public CellState getCellState() {
        return cellState;
    }
    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }


    public void displaycell() {
        if (cellState == CellState.EMPTY) {
            System.out.print("| . |");
        } else {
            System.out.print("| " + player.getSymbol() + " |");
        }
    }
}
