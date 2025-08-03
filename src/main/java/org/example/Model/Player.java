package org.example.Model;

import java.util.Scanner;

public class Player {
    private Long id;
    private String name;
    private String symbol;
    private PlayerType playerType;
    private Scanner scanner;

    //Constructure
    public Player(Long id, String name, String symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    //Getter&Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public PlayerType getPlayerType() {
        return playerType;
    }
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
    public Scanner getScanner() {
        return scanner;
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    //Methods
    private void leave_game(){}

    public Move makeMove(Board board) {
        System.out.println("Enter the row and column to place your symbol (e.g., 1 2): ");
        int row = scanner.nextInt() - 1; // Adjust for 0-based index
        int col = scanner.nextInt() - 1; // Adjust for 0-based index

        Cell cell = new Cell(row, col);
        if (board.isValidPosition(cell)) {
            return new Move(cell, this);
        } else {
            System.out.println("Invalid move. Try again.");
            return makeMove(board); // Retry if the move is invalid
        }
    }
}
