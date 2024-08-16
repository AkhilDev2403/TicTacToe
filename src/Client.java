import Controller.GameController;
import Models.*;
import Strategies.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
//        1.
//        GameController gc = new GameController();
//        gc.startGame();
//        gc.makeMove();

//        2.
//        GameController gc = new GameController();
//        Game g1 = gc.startGame();
//
//        Game g2 = gc.startGame();
//        gc.makeMove(g2);
//        gc.getWinner(g2);


//        3.
        GameController gc = new GameController();

        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("101", "Akhil", new Symbol('X', "Black"), PlayerType.HUMAN));
        players.add(new BotPlayer("102", "ZZZ", new Symbol('0', "white"), PlayerType.BOT, DifficultyLevel.EASY));

        Game g1 = gc.startGame(3, players, List.of(new RowWinningStrategy()));
        gc.makeMove(g1);


    }
}
