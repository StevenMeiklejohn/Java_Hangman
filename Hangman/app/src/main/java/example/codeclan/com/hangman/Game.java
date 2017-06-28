package example.codeclan.com.hangman;

import java.util.ArrayList;
import java.util.List;



public class Game {


    private Player player;
    private String word;
    private ArrayList<Character> correctGuesses;
    private ArrayList<Character> wrongGuesses;
    private ArrayList<Character> wordArray;
    private Ui ui;
    private Boolean inPlay;


    public Game(Player player, String word, Ui ui){
        this.player = player;
        this.word = word;
        this.ui = ui;
        inPlay = true;
        correctGuesses = new ArrayList<Character>();
        wrongGuesses = new ArrayList<Character>();
        wordArray = new ArrayList<Character>();
        for (char c : word.toCharArray()) {
            wordArray.add(c);
        }
    }

    public Player getPlayer(){
        return this.player;
    }

    public int getCorrectGuesses() {
        return correctGuesses.size();
    }

    public int getWrongGuesses() {
        return wrongGuesses.size();
    }

    public boolean makeGuess (Character letter){
        int multiple = checkMultiple(letter);
        boolean correct = wordArray.contains(letter);
        if (correct){
            for(int i = 0; i < multiple; i++) {
                correctGuesses.add(letter);
            }
            ui.correctGuess();
        }
        else {
            wrongGuesses.add(letter);
            ui.wrongGuess();
        }
        return correct;
    }



    public int checkMultiple(char guess){
        int count = 0;
        for(char c: wordArray){
            if(c == guess){
                count ++;
            }
        }
        return count;
    }

    public String getFormattedWord(){
        String formatted ="";
        for (char letter: word.toCharArray()){
            char display = '_';
            if(correctGuesses.contains(letter)){
                display = letter;
            }
            formatted += display;
        }
        return formatted;
    }



    public Boolean checkWin(){
        if(this.word.length() == correctGuesses.size()){
            ui.win();
            inPlay = false;
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checkLose(){
        if(wrongGuesses.size() >= 7){
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
