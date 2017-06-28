package example.codeclan.com.hangman;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 28/06/2017.
 */

public class TestPlayer {

    private Player player;

    @Before
    public void Before(){
        player = new Player("Steve");
    }

    @Test
    public void testPlayerHasName(){
        assertEquals("Steve", player.getName());
    }
}

