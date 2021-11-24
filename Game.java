import java.util.SortedSet;
import java.util.TreeSet;
import java.util.*;

public class Game {
    private String word = "";
    private String guessedWord = "";
    private int guesses = 0;
    private boolean win = false;
    private boolean lose = false;
    SortedSet<Character> guessedLetters = new TreeSet<>();
    public void playGame(String word){
        this.word = word;
        this.guesses = guesses;
        setGuessedWord();

        //Guess loop.
        do{
            output();
            String input = "";
            input = getGuess();
            input.toLowerCase();
            //Check input for valid input and if it has already been guessed or not.
            if(checkGoodGuess(input)){
                if(checkGuess(input.charAt(0))){
                    if(!guessMade(input.charAt(0)));

                }
            }
            //check if the word has been guessed.
            win = checkWin();
        }
        while(!win);
            System.out.println("You won! The word was: " + word);
            return;
    }

    private void setGuessedWord(){
        //This will get a string with the same length as our word with only _'s
        for(int i = 0 ; i < word.length(); i ++){
            guessedWord += '-';
        }
    }


    private void output(){
        //output information for user: guess count, letters guessed, etc.
        System.out.println(guessedWord);
        System.out.println("You have made " + guesses + " guesses");
        System.out.print("You have guessed the following letters:");
        for(Character car: guessedLetters){
            System.out.print(" " + car);
        }
        System.out.println();
        System.out.print("Please enter your next guess: ");
    }

    private boolean checkGuess(char guess){
        //Check if letter has arleady been guessed.
        for(Character car: guessedLetters){
            if(car == guess){
                System.out.println("You have already guessed this letter!");
                return false;
            }
        }
        return true;
    }

    private boolean checkWin() {
        //check if user has won.
        if (guessedWord.equals(word)) return true;
        else return false;
    }

    private boolean checkGoodGuess(String guess){
        //Check if the guess is a valid input.
        if(guess.length() == 0){
            System.out.println("Your guess is empty, try again:");
            return false;
        }
        else if(!Character.isLetter(guess.charAt(0))){
            System.out.println("You didn't guess a letter, try again");
            return false;
        }
        return true;
    }

    private String getGuess(){
        //scan guess from line.
        Scanner scan = new Scanner(System.in);
        String input = "";
        input = scan.nextLine();
        return input;
    }

    private boolean guessMade(char guess){
        //Perform logic for guess.
        int changecount = 0;
        for(int i = 0; i < word.length(); i++){
            if(guessedWord.charAt(i) == '-' && word.charAt(i) == guess){
                String val1 = guessedWord.substring(0, i);
                String val2 = guessedWord.substring(i+1);
                guessedWord= val1 + guess + val2;
                changecount ++;
            }
        }
        guessedLetters.add(guess);
        //check if letter was in the word.
        if (changecount > 0) {
            System.out.println("Great Guess! There was " + changecount + " " + guess + "(s)!");
            guesses++;
            return true;
        }
        else{
            System.out.println("Sorry, there weren't any " + guess + "'s in this word");
            guesses++;
            return false;
        }
    }
}
