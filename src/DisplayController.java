import java.util.ArrayList;
import java.util.HashSet;

/**
 * Class that handles all displays for the console
 *
 * @author Cole Glass
 */
public class DisplayController {
    final String word;
    public DisplayController(Word word) {
        this.word = word.getWord();
    }

    /**
     * Displays the name of the game
     */
    public void introDisplay(){
        System.out.println("HANGMAN");
    }

    /**
     * Main display which is shown every round
     */
    public void mainDisplay(HashSet<String> guesses, ArrayList<String> wrongGuesses){
        System.out.println("+---+");
        if(wrongGuesses.size() > 0)System.out.println("O  |");else System.out.println("   |");
        if(wrongGuesses.size() > 1)System.out.println("|  |");else System.out.println("   |");
        if(wrongGuesses.size() > 2)System.out.println("|  |");else System.out.println("   |");
        System.out.println("  ===");
        if(wrongGuesses.size() > 0) System.out.println("Missed Letters: " + wrongGuessDisplay(wrongGuesses));
        else System.out.println("Missed Letters: ");
        wordDisplay(guesses);
    }

    /**
     * Returns a string of all incorrect guesses so far
     *
     * @return guesses : String
     */
    public String wrongGuessDisplay(ArrayList<String> wrongGuesses){
        String guesses = "";
        for (String letter:wrongGuesses) {
            guesses += letter;
        }
        return guesses;
    }

    /**
     * Displays the word as it has een guesses so far by the user
     */
    public void wordDisplay(HashSet<String> guesses){
        for (int i = 0; i < word.length(); i++) {
            if(guesses.contains(String.valueOf(word.charAt(i))))System.out.print(word.charAt(i));
            else System.out.print("_");
        }
        //add a line of space for formatting
        System.out.println();
    }

    /**
     * Display for game lost condition
     */
    public void defeatDispay(){
        System.out.println("Sorry! That's too many guesses. The secret word was " + word);
    }

    /**
     * Display for game won condition
     */
    public void victoryDisplay(){
        System.out.println("Yes! The secret word was " + word);
    }
}
