package Models;

public abstract class Player {
    private String id;
    private String name;
    private Symbol playerSymbol;
    private PlayerType playerType;

    public Player(String id, String name, Symbol playerSymbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.playerSymbol = playerSymbol;
        this.playerType = playerType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(Symbol symbol) {
        this.playerSymbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
