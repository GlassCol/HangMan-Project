import java.util.ArrayList;
import java.util.HashSet;

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
    String currentGuess;
    int guessCount = 0;
    Start start = new Start();

    /**
     * Method which runs the game
     */
    public void run() {
        displayController.introDisplay();
        displayController.mainDisplay(playerGuesses, wrongGuesses);
        while(!gameEnd){
            currentGuess = input.getUserChoice();
            if(playerGuesses.contains(currentGuess))System.out.println("That has already been guessed.");
            playerGuesses.add(currentGuess);
            if(!word.getWord().contains(currentGuess)) {
                wrongGuesses.add(currentGuess);
                guessCount++;
            }
            displayController.mainDisplay(playerGuesses, wrongGuesses);
            gameEnd = isGameEnd();
        }
        if(guessCount > 3)displayController.defeatDispay();
        else displayController.victoryDisplay();
       boolean reRun = input.getYesOrNo();
       if(reRun){
           start.reRun();
       }
    }

    /**
     * Checks whether or not the game should end
     *
     * @return boolean
     */
public boolean isGameEnd(){
        if(guessCount > 3)return true;
    for (int i = 0; i < word.getWord().length(); i++) {
        if(!playerGuesses.contains(word.getWord().charAt(i)))return false;
    }
            return true;
}

}
