package example.codeclan.com.hangman;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 28/06/2017.
 */

public class Ui {

    private Scanner sc;
//    private String word;
//    private String name;

    public Ui(){
//        this.word = "";
//        this.name = null;
    }


    public void begin(){
        System.out.println("Hello and welcome to Hangman!");
    }

    public void welcome(String name){
        System.out.println("OK " + name + " Let's play!");
    }

    public String askForWord(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a word...");
        System.out.println("");
        return sc.nextLine();
    }

//    public String getWord(){
//        return this.word;
//    }

    public String askForName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter player name");
        System.out.println("");
        return sc.nextLine();
    }

    public Character askForGuess(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a letter to make a guess.");
        System.out.println("");
        return sc.nextLine().charAt(0);
    }


    public void clearScreen() {
        char c = '\n';
        int length = 25;
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        System.out.print(String.valueOf(chars));
    }


    public void progress(String word){
        System.out.println("Current progress:");
        System.out.println(word);
    }

    public void displayFormattedWord(String formattedWord){
        System.out.println(formattedWord);
    }

    public void win(){
        System.out.println("Yasssss! Congrats, you win!");
    }

    public void lose(){
        System.out.println("Pfft....Not today pal.");
    }

    public void wrongGuess(){
        System.out.println("Nope. Try again");
    }

    public void correctGuess(){
        System.out.println("Good Guess!");
    }


}
