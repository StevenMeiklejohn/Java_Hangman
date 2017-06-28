package example.codeclan.com.hangman;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by user on 28/06/2017.
 */

public class TestGame {

    private Player player;
    private Game game;
    private Ui ui;


    @Before
    public void before(){
        player = new Player("Deirdre Barlow");
        ui = new Ui();
        game = new Game(player, "balls", ui);
    }

    @Test
    public void testCanGuessCorrectly(){
        assertEquals(true, game.makeGuess('a'));
        assertEquals(1, game.getCorrectGuesses());
    }

    @Test
    public void testCanGuessInCorrectly(){
        assertEquals(false, game.makeGuess('z'));
        assertEquals(1, game.getWrongGuesses());
    }

    @Test
    public void testGameCanDisplayFormattedWord(){
        game.makeGuess('b');
        assertEquals("b____", game.getFormattedWord());
    }

    @Test
    public void testGameCanBeWon(){
        game.makeGuess('b');
        game.makeGuess('a');
        game.makeGuess('l');
        game.makeGuess('l');
        game.makeGuess('s');
        assertTrue(game.checkWin());
    }

    @Test
    public void testPlayerCanLose(){
        game.makeGuess('d');
        game.makeGuess('m');
        game.makeGuess('n');
        game.makeGuess('p');
        game.makeGuess('t');
        game.makeGuess('z');
        game.makeGuess('x');

        assertTrue(game.checkLose());
    }


}
