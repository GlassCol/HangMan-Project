import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Class that handles all displays for the console
 *
 * @author Cole Glass
 */
public class DisplayController {
    private final String word;
    private final String artPath = "src/Art.txt";
    String[] artArray = new String[4];

    public DisplayController(Word word) {
        this.word = word.getWord();
    }

    /**
     * Displays the name of the game
     */
    public static void introDisplay() {
        System.out.println("   HANGMAN");
    }

    /**
     * Main display which is shown every round
     */
    public void mainDisplay(HashSet<String> guesses, ArrayList<String> wrongGuesses) {
        try {
            String artStream = Files.readString(Path.of(artPath));
            artArray = artStream.split("\n\r");
            System.out.println(switch (wrongGuesses.size()) {
                case 1 -> artArray[1];
                case 2 -> artArray[2];
                case 3 -> artArray[3];
                default -> artArray[0];
            });
            if (wrongGuesses.size() > 0) System.out.println("Missed Letters: " +
                    String.join("", wrongGuesses));
            else System.out.println("Missed Letters: ");
            wordDisplay(guesses);
        } catch (Exception e) {
            System.out.println("No such file found");
        }
    }

    /**
     * Displays the word as it has been guessed so far by the user
     */
    public String wordDisplay(HashSet<String> guesses) {
        ArrayList<String> wordList = (ArrayList<String>) word.chars()
                .mapToObj(e -> String.valueOf((char) e))
                .collect(Collectors.toList());
        String display = wordList.stream()
                .map(e -> {
                    if (guesses.contains(String.valueOf(e))) return String.valueOf(e);
                    return ("_");
                })
                .collect(Collectors.joining());
        System.out.println(display);
        //add a line of space for formatting
        System.out.println();
        //for use if you want it (i.e. for unit testing)
        return display;
    }

    /**
     * Display for game lost condition
     */
    public void defeatDisplay() {
        System.out.println("Sorry! That's too many guesses. The secret word was " + word);
    }

    /**
     * Display for game won condition
     */
    public void victoryDisplay() {
        System.out.println("Yes! The secret word was " + word);
    }
}
