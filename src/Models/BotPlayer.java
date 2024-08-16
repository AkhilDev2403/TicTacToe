package Models;

public class BotPlayer extends Player {
    private DifficultyLevel difficultyLevel;

    public BotPlayer(String id, String name, Symbol symbol, PlayerType playerType, DifficultyLevel difficultyLevel) {
        super(id, name, symbol, playerType);
        this.difficultyLevel = difficultyLevel;
    }

}
