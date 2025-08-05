package org.example.Model;

import org.example.Model.Strategy.GameRule;
import org.example.Model.Strategy.WinningStrategy;

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

    public void makeMove(){
        // Get the player
        // Take the input from the player
        // Update the cell state
        // Store to the moves
        // Calculate next player
        // check winner
        // check draw
        Player currentPlayer = players.get(nextMovePlayerIndx);
        System.out.println("Player " + currentPlayer.getName() + " makes a move.");
        Move currentMove = currentPlayer.makeMove(board);

        if(!isMoveAllowed(currentMove)){
            System.out.println("Invalid move. Try again.");
        }
        int currentRow = currentMove.getCell().getRow();
        int currentCol = currentMove.getCell().getCol();
        System.out.println("Player " + currentPlayer.getName() + " placed a " + currentPlayer.getSymbol() + " at row " + currentRow + " and column " + currentCol);
        Cell currentCell = board.getBoard().get(currentRow).get(currentCol);
        currentCell.setCellState(CellState.FILLED);
        currentCell.setPlayer(currentPlayer);

        Move newmove = new Move(currentMove.getCell(),currentPlayer);
        moves.add(newmove);

        nextMovePlayerIndx +=1;
        nextMovePlayerIndx %= players.size();

        // Check for winner
           if(gamerule.winningStrategies(board,currentMove).stream().anyMatch(strategy -> strategy.checkWin(board,currentMove))){
            gameState = GameState.WIN;
            winner = currentPlayer;
            System.out.println("Player " + currentPlayer.getName() + " wins!");
           }
           else if(moves.size() == board.getSize()*board.getSize()){
            gameState = GameState.DRAW;
            System.out.println("The game is a draw!");
           }
           else {
            gameState = GameState.IN_PROGRESS;
            System.out.println("Game is still in progress.");
           }

    }
    public String getCurrentState(){return null;}

    public boolean isMoveAllowed(Move move){
        return false;
         //validation case if row and col is out of board size
        //validation case if cell is already occupied
    }
    public void undo() {
        if (moves.isEmpty()) {
            System.out.println("No moves to undo.");
            return;
        }
        if(!gameState.equals(GameState.IN_PROGRESS)){
            System.out.println("Cannot undo moves when the game is not in progress.");
            return;
        }
        //Get the last move
        //Remove the last move from the moves list
        //Update the cell state to EMPTY
        //Set the player of the cell to null
        //Update the nextMovePlayerIndx to the previous player
        //update the HashMap
        //Print the message that the last move is undone

        Move lastMove = moves.get(moves.size() - 1);
        moves.remove(lastMove);
        // Update the cell state to EMPTY
        Cell lastCell = lastMove.getCell();
        lastCell.setCellState(CellState.EMPTY);
        lastCell.setPlayer(null);
        nextMovePlayerIndx = (nextMovePlayerIndx - 1 + players.size()) % players.size();
        System.out.println("Last move undone. Player " + lastMove.getPlayer().getName() + "'s turn again.");

        for(WinningStrategy )


    }
    


    public void printboard() {
         board.display();
    }

}
