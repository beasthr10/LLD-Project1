package org.example.controller;

import org.example.Model.Game;
import org.example.Model.GameState;
import org.example.Model.Player;
import org.example.Model.Strategy.GameRule;

import java.util.List;

public class GameController {

    //entry point for starting a game
    public Game startGame(int dimension, List<Player> players, GameRule gamerule) {
        Game game = Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setGamerule(gamerule)
                .build();
        return game;
    }
    public GameState getState(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        return game.getGameState();
    }
    public void makeMove(Game game) {
        game.makeMove();
    }
    public void undo(Game game){
        game.undo();
    }

    public void printBoard(Game game) {
        if (game == null || game.getBoard() == null) {
            throw new IllegalArgumentException("Game or Board cannot be null");
        }
        game.printboard();
    }

}
