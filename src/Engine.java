import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Main engine which pushes the game through its various stages
 *
 * @author Cole Glass
 */
public class Engine {
    final Word word = new Word();
    private final InputController input = new InputController();
    private final DisplayController displayController = new DisplayController(word);
    private boolean gameEnd = false;
    HashSet playerGuesses = new HashSet();
    ArrayList<String> wrongGuesses = new ArrayList<>();
    String currentGuess, userName;
    int guessCount = 0;
    Start start = new Start();

    /**
     * Method which runs the game
     */
    public void run() {
        displayController.introDisplay();
        userName = input.getName();
        displayController.mainDisplay(playerGuesses, wrongGuesses);
        while (!gameEnd) {
            currentGuess = input.getUserChoice();
            if (playerGuesses.contains(currentGuess)) System.out.println("That has already been guessed.");
            playerGuesses.add(currentGuess);
            if (!word.getWord().contains(currentGuess)) {
                wrongGuesses.add(currentGuess);
                guessCount++;
            }
            displayController.mainDisplay(playerGuesses, wrongGuesses);
            gameEnd = isGameEnd();
        }
        if (guessCount > 3) displayController.defeatDisplay();
        else {
            displayController.victoryDisplay();
            if(checkHighScore())System.out.println("Congratulations you got the high score!");
            record();
        }
        boolean reRun = input.getYesOrNo();
        if (reRun) {
            start.reRun();
        }
    }

    /**
     * Checks whether the game should end
     * @return boolean
     */
    public boolean isGameEnd() {
        if (guessCount > 3) return true;
        return (playerGuesses.size() - wrongGuesses.size()) == checkForUnique();
    }

    /**
     * Returns the number of individual characters in te winning word to be used for checking if the player has won
     * @return count : int
     */
    public int checkForUnique(){
        return (int) word.getWord()
                .chars()
                .distinct()
                .count();
    }
    /**
     * Takes the score and username and writes it to the records file
     */
    public void record(){
        try {
            Writer writer = new FileWriter("src/Records.txt", true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("\n" + userName + ", " + (10 - guessCount));
            System.out.println("\n" + userName + ", " + (10 - guessCount));
            bw.close();
        }catch(Exception e){System.out.println("Unable to record score");}
    }

    /**
     * Checks if the players score is larger than any score in the record
     * @return boolean
     */
    public boolean checkHighScore() {
        ArrayList<Integer> recordList = new ArrayList<>();
        try {
            String recordString = Files.readString(Path.of("src/Records.txt"));
            String[] recordArray = recordString.split("\n");
            recordList = (ArrayList<Integer>) Arrays.stream(recordArray)
                    .map(e -> {
                        String[] tempArray = e.split(", |\r");
                        return Integer.valueOf(tempArray[1]);
                    })
                    .collect(Collectors.toList());

        } catch (Exception e) {
            System.out.println("Unable to check high score");
        }
        return (Collections.max(recordList) <= (10 - guessCount));
    }
}
