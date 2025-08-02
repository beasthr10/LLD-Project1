package org.example.Model;

import org.example.Model.Strategy.GameRule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private int nextMovePlayerIndx;
    private List<Move> moves;
    private Player winner;
    private GameRule gamerule;

    //Constructor(Builder Pattern)
    private Game(int dimension,List<Player> players,GameRule gamerule){
        this.board = new Board(dimension);
        this.players = players;
        this.gameState = GameState.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.winner = null;
        this.gamerule = gamerule;
    }
    public static Builder getBuilder() {
        return new Builder();
    }

    //Builder
    public static class Builder{
        private int dimension;
        private List<Player> players;
        private GameRule gamerule;
        public Builder() {
            this.dimension = 0; // Default dimension
            this.players = new ArrayList<>();
            this.gamerule = null; // Default game rule
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setGamerule(GameRule gamerule) {
            this.gamerule = gamerule;
            return this;
        }

        public Game build() {
            runValidations();
            return new Game(dimension, players, gamerule);
        }

        private void runValidations() {
            validateforbotcount();
            validateSymbolsforPlayers();
            validateDimension();
            validateforPlayers();
        }
        public void validateforPlayers() {
            if (players == null || players.isEmpty()) {
                throw new IllegalArgumentException("At least one player is required.");
            }
            if (players.size() < 2) {
                throw new IllegalArgumentException("At least two players are required.");
            }
        }
        public void validateSymbolsforPlayers() {
            // Check if all players have unique symbols
            HashSet<String> symbols = new HashSet<>();
            for (Player player : players) {
                if (symbols.contains(player.getSymbol())) {
                    throw new IllegalArgumentException("Players must have unique symbols.");
                }
                symbols.add(player.getSymbol());
            }
        }
        public void validateDimension() {
            if (dimension < 3) {
                throw new IllegalArgumentException("Dimension must be at least 3.");
            }
        }
        public void validateforbotcount(){
            int botCount = 0;
            for (Player player : players) {
                if (player.getPlayerType() == PlayerType.BOT) {
                    botCount++;
                }
            }
            if (botCount == players.size()) {
                throw new IllegalArgumentException("At least one player must be a human.");
            }
        }

    }

    //Getter&Setter
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
    public List<Move> getMoves() {
        return moves;
    }
    public void setMoves(List<Move> moves) {
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
    public void printboard() {
         board.display();
    }

}
