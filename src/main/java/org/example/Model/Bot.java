package org.example.Model;

public class Bot extends Player{

    public Bot(Long id, String name, String symbol, PlayerType playerType) {
        super(id, name, symbol, playerType);
    }
    private DifficultyLevel botdifficultyLevel;

    //Getter&Setter
    public DifficultyLevel getBotdifficultyLevel() {
        return botdifficultyLevel;
    }
    public void setBotdifficultyLevel(DifficultyLevel botdifficultyLevel) {
        this.botdifficultyLevel = botdifficultyLevel;
    }
}
