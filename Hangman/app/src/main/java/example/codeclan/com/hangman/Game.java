package example.codeclan.com.hangman;

import java.util.ArrayList;
import java.util.List;



public class Game {


    private Player player;
    private Word word;
    private Ui ui;
    private Boolean inPlay;


    public Game(Player player, Word word, Ui ui){
        this.player = player;
        this.word = word;
        this.ui = ui;
        inPlay = true;


    }

    public Player getPlayer(){
        return this.player;
    }

    public int getCorrectGuesses() {
        return word.getCorrectGuesses().size();
    }

    public int getWrongGuesses() {
        return word.getWrongGuesses().size();
    }

    public boolean makeGuess (Character letter){
        int multiple = checkMultiple(letter);
        boolean correct = word.getWordArray().contains(letter);
        if (correct){
            for(int i = 0; i < multiple; i++) {
                word.getCorrectGuesses().add(letter);
            }
            ui.correctGuess();
        }
        else {
            word.getWrongGuesses().add(letter);
            ui.wrongGuess();
        }
        return correct;
    }



    public int checkMultiple(char guess){
        int count = 0;
        for(char c: word.getWordArray()){
            if(c == guess){
                count ++;
            }
        }
        return count;
    }

    public String getFormattedWord(){
        String formatted ="";
        for (char letter: word.getWord().toCharArray()){
            char display = '_';
            if(word.getCorrectGuesses().contains(letter)){
                display = letter;
            }
            formatted += display;
        }
        return formatted;
    }



    public Boolean checkWin(){
        if(word.getWord().length() == word.getCorrectGuesses().size()){
            ui.win();
            inPlay = false;
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checkLose(){
        if(word.getWrongGuesses().size() >= 7){
            ui.lose();
            inPlay = false;
            return true;
        }
        else{
            return false;
        }
    }

    public void gameLoop(){
        while(inPlay) {
//            checkWin();
//            checkLose();
            if (!checkWin() && !checkLose()) {
                Character guess = ui.askForGuess();
                makeGuess(guess);
                ui.progress(getFormattedWord());
            }
        }
    }





}
