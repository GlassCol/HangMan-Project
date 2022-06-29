import java.util.Objects;
import java.util.Scanner;

/**
 * Class that handles all input from the user
 *
 * @author Cole Glass
 */
public class InputController {
    Scanner input = new Scanner(System.in);

    /**
     * Gets the user input for which letter they want to guess next
     *
     * @return choice : String
     */
    public String getUserChoice() {
        boolean Valid = false;
        String choice = "";
        try{;
            while(choice.length() > 1 || Valid == false){
                if(choice.length() > 0)  System.out.println("Sorry please choose only one letter character");
                System.out.println("Guess a letter: ");
                choice = input.nextLine();
                if(choice.matches("[a-zA-Z]")) Valid = true;
            }
        }catch(Exception e){
    System.out.println("Error try again: ");
    getUserChoice();
}
        return choice;
    }

    /**
     * Gets the user input for a yes or no question
     *
     * @return boolean
     */
    public boolean getYesOrNo() {
        boolean Valid = false;
        String choice = "";
        while (!Valid) {
            System.out.println("Would you like to play again? (y or n)");
            choice = input.nextLine();
            if (Objects.equals(choice, "y") || Objects.equals(choice, "n")) {
                Valid = true;
            }
        }
        return choice.equals("y");
    }
}
