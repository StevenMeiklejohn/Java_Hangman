package example.codeclan.com.hangman;

import java.util.Scanner;

/**
 * Created by user on 28/06/2017.
 */

public class Runner {

        private Scanner sc;

    public static void main(String[] args) {

        Ui ui = new Ui();
        ui.begin();
        String word = ui.askForWord();
        String name = ui.askForName();

        ui.clearScreen();
        Word inputWord = new Word(word);
        Player player = new Player(name);
        ui.welcome(player.getName());
        Game game = new Game(player, inputWord, ui);


        ui.progress(game.getFormattedWord());
        game.gameLoop();

    }
}
