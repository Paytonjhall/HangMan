import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
//THIS PROJECT TOOK ME ABOUT 90 MINUTES TO COMPLETE
    ArrayList<String> words = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        //Set up dictionary for words
        Hangman hangman = new Hangman();
        hangman.registerWords();
        //Welcome user
        System.out.println("Welcome to Hang-man");
        System.out.println("We will randomly choose a word for you to play, get ready!");
        Thread.sleep(1000);
        System.out.println("If you put in more than one letter, we will use the first letter.");
        hangman.chooseWord();
        Thread.sleep(1000);

        //Loops and asks user kf they want to keep playing.
       while(hangman.playAgain()){
          if(hangman.words.size() == 0) {
              System.out.println("Sorry, you have played with every word we know, sorry.");
              return;
          }
          else{
              Thread.sleep(1000);
              hangman.chooseWord();
          }
       }
        System.out.println("Thanks for playing!");
    }

    public void registerWords(){
        //Just made these words up.
        words.add("cat");
        words.add("dog");
        words.add("fish");
        words.add("pony");
        words.add("okapi");
        words.add("horse");
        words.add("canine");
        words.add("eaglet");
        words.add("panther");
        words.add("elephant");
    }

    public void chooseWord(){
        //Randomly choose word
        Random rand = new Random();
        int chooser = rand.nextInt(words.size());
        String chosenWord = words.get(chooser);
        words.remove(chooser);
        //Remove word from list
        //Start game.
        Game game = new Game();
        game.playGame(chosenWord);
    }

    public boolean playAgain(){
        //Ask user to play again.
        System.out.println("Would you like to play again? (y/n)");
        Scanner scan = new Scanner(System.in);
        String input = "";
        input = scan.nextLine();
        if(input.charAt(0)=='y' || input.charAt(0) == 'Y') return true;
        else return false;

    }
}
