package example.codeclan.com.hangman;

import java.util.ArrayList;

/**
 * Created by user on 29/06/2017.
 */

public class Word {

    private String word;
    private ArrayList<Character> correctGuesses;
    private ArrayList<Character> wrongGuesses;
    private ArrayList<Character> wordArray;

    public Word(String word){
        this.word = word;
        correctGuesses = new ArrayList<Character>();
        wrongGuesses = new ArrayList<Character>();
        wordArray = new ArrayList<Character>();

        for (char c : word.toCharArray()) {
            wordArray.add(c);
        }
    }


    public String getWord() {
        return word;
    }

    public ArrayList<Character> getCorrectGuesses() {
        return correctGuesses;
    }

    public ArrayList<Character> getWrongGuesses() {
        return wrongGuesses;
    }

    public ArrayList<Character> getWordArray() {
        return wordArray;
    }
}
