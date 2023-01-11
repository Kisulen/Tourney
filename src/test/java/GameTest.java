import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    List<Player> playersList = new ArrayList<>();
    Game game = new Game();

    Player player1 = new Player(1, "John", 120);
    Player player2 = new Player(2, "Lily", 90);
    Player player3 = new Player(3, "Tom", 75);
    Player player4 = new Player(4, "Adam", 143);
    Player player5 = new Player(5, "Rebecca", 143);
    Player player6 = new Player(6, "Fred", 138);
    Player player7 = new Player(7, "Leslie", 168);
    Player player8 = new Player(8, "Hamish", 191);


    @Test
    public void firstPlayerWins () {
        Game game = new Game();
        Player player1 = new Player(2, "Lily", 90);
        Player player2 = new Player(3, "Tom", 75);
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Lily", "Tom");

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void secondPlayerWins () {
        Game game = new Game();
        Player player1 = new Player(2, "Lily", 90);
        Player player2 = new Player(5, "Rebecca", 143);
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Lily", "Rebecca");

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void draw () {
        Game game = new Game();
        Player player1 = new Player(4, "Adam", 143);
        Player player2 = new Player(5, "Rebecca", 143);
        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Adam", "Rebecca");

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void firstPlayerNotRegistered () {
        Game game = new Game();
        Player player1 = new Player(1, "John", 120);
        Player player2 = new Player(6, "Fred", 138);

        game.register(player2);

Assertions.assertThrows(NotRegisteredException.class, () -> {
    game.round("John", "Fred");
});
    }

    @Test
    public void secondPlayerNotRegistered () {
        Game game = new Game();
        Player player1 = new Player(7, "Leslie", 168);
        Player player2 = new Player(8, "Hamish", 191);

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Leslie", "Hamish");
        });
    }

    @Test
    public void noneOfThePlayersAreRegistered () {
        Game game = new Game();
        Player player1 = new Player(1, "John", 120);
        Player player2 = new Player(6, "Fred", 138);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("John", "Fred");
        });
    }


}
