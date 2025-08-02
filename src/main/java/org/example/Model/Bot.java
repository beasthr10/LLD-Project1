package org.example.Model;

public class Bot extends Player{

    public Bot(Long id, String name, String symbol, PlayerType playerType, DifficultyLevel botdifficultyLevel) {
        super(id, name, symbol, playerType);
        this.botdifficultyLevel = botdifficultyLevel;
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
