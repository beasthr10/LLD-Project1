package org.example;

import org.example.Model.Game;
import org.example.Model.GameState;
import org.example.Model.Player;
import org.example.Model.PlayerType;
import org.example.Model.Strategy.GameRuleIMP;
import org.example.Model.Strategy.WinningStrategy;
import org.example.controller.GameController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       // S1. set dimentions of the board
        // S2. create a board with the given dimensions
        // S3. create a player with a name and a symbol
        // S4. create a game with the board and players
        // S5. start the game
        // S6. make moves until the game is over
        // S7. check the game state and declare the winner if any
        // S8. print the game result
        int dimension = 3;
        List<Player> players = new ArrayList<>();
        players.add(new Player(1L,"Harsh","X", PlayerType.HUMAN));
        players.add(new Player(2L,"Deepak","O",PlayerType.HUMAN));
        GameRuleIMP gameRule = new GameRuleIMP();

        //Now game is created
        GameController gameController = new GameController();
        Game game = gameController.startGame(dimension,players,gameRule);

        Scanner scanner = new Scanner(System.in);

        while(gameController.getState(game).equals(GameState.IN_PROGRESS)) {
            // Print the current board
            gameController.printBoard(game);

            System.out.println("Undo last move? (yes/no)");
            String undoResponse = scanner.nextLine();
            if (undoResponse.equalsIgnoreCase("yes")) {
                gameController.undo(game);
                continue; // Skip to the next iteration to reprint the board
            }
            // Make the move
            gameController.makeMove(game, players.get(game.getNextMovePlayerIndx()), 0, 0);

        }
        // Print the final board and game result
        System.out.println("Game Over!");
        GameState gameState = gameController.getState(game);

        if (gameState.equals(GameState.WIN)) {
            System.out.println("Winner: " + game.getWinner().getName() + " with symbol " + game.getWinner().getSymbol());
        } else if (gameState.equals(GameState.DRAW)) {
            System.out.println("The game is a draw!");
        } else {
            System.out.println("Game ended unexpectedly.");
        }
        gameController.printBoard(game);
    }
}