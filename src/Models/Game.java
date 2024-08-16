package Models;

import Strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> move;
    private Player winner;
    private GameState currentGameState;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(Builder builder){
        this.board = new Board(builder.dimension);
        this.players = builder.players;
        this.move = new ArrayList<>();
        this.winner = null;
        this.currentGameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.winningStrategies = builder.winningStrategies;
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

    public List<Move> getMove() {
        return move;
    }

    public void setMove(List<Move> move) {
        this.move = move;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getCurrentGameState() {
        return currentGameState;
    }

    public void setCurrentGameState(GameState currentGameState) {
        this.currentGameState = currentGameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

//     we have multiple attributes(beforehand) to validate and create objects - that's why we are going for Builder.
//     we require only the necessary info here. we only need setters here
//     Builder helps to build the Game object (inner class)

    public static class Builder{
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;


        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Game build(){
            validate();
            return new Game(this);     // crate constructor for this Game class and nobody should create Game constr directly so make it private
        }

        private void validate(){

//          1.Check player count
            if(players.size() != dimension-1){
                throw new RuntimeException("Invalid Player count.");
            }

//          2. Only one bot allowed
            int botCount = 0;
            for(Player player : players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }
            if(botCount > 1){
                throw new RuntimeException("More than one bot is not allowed.");
            }

//          3. Every player should've separate symbol
            Set<Character> symbolSet = new HashSet<>();
            for (Player player : players){
                if(symbolSet.contains(player.getPlayerSymbol().getSymbol())){
                    throw new RuntimeException("Symbol already in use.");
                }
                symbolSet.add(player.getPlayerSymbol().getSymbol());
            }
        }
    }
}
