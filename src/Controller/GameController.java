package Controller;

import Models.Game;
import Models.GameState;
import Models.Player;
import Strategies.WinningStrategy;

import java.util.List;

public class GameController {

//    1.
//    Game game;
//
//    public void startGame(){
//        this.game = new Game();
//    }

    // only one game instance can be created above. we need to have more than one game at a time.

//    2.
//    public Game startGame(){
//        return new Game();
//    }

//    3. we got the information from the user like the dimension, players and the winning strategy so start the game accordingly
// now we need to create the Builder - creating the Game obj based on the info and we have some selective attributes as well.
    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public GameState getGameState(Game game){
        return game.getCurrentGameState();
    }

    public void makeMove(Game game){

    }

    public Player getWinner(Game game){
        return game.getWinner();
    }
}
