package org.example.Model;

import org.example.Model.Strategy.GameRule;

import java.util.List;

public class Game {
    private Long id;
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private int nextMovePlayerIndx;
    private List<Cell> moves;
    private Player winner;
    private GameRule gamerule;

    //Getter&Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public GameState getGameState() {
        return gameState;
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
    public int getNextMovePlayerIndx() {
        return nextMovePlayerIndx;
    }
    public void setNextMovePlayerIndx(int nextMovePlayerIndx) {
        this.nextMovePlayerIndx = nextMovePlayerIndx;
    }
    public List<Cell> getMoves() {
        return moves;
    }
    public void setMoves(List<Cell> moves) {
        this.moves = moves;
    }
    public Player getWinner() {
        return winner;
    }
    public void setWinner(Player winner) {
        this.winner = winner;
    }
    public GameRule getGamerule() {
        return gamerule;
    }
    public void setGamerule(GameRule gamerule) {
        this.gamerule = gamerule;
    }


    //Methods
    public void startNewGame(){}
    public void makeMove(){}
    public String getCurrentState(){return null;}
    public boolean isMoveAllowed(Cell cell){return false;}

}
