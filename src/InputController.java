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
        try {
            System.out.println("Guess a letter: ");
            String choice = input.nextLine();
            if (choice.length() > 1) {
                System.out.println("Sorry please choose only one letter character");
                return getUserChoice();
            }
            if (choice.matches("[a-zA-Z]")) return choice;
            else {
                System.out.println("Please only choose a letter: ");
                return getUserChoice();
            }
        }catch (Exception e){System.out.println("Invalid input"); return getUserChoice();}
    }

    /**
     * Gets the name of the user from user input
     * @return userName : String
     */
    public String getName(){
        try {
            System.out.println("Please enter your name: ");
            return input.nextLine();
        }catch(Exception e){System.out.println("Invalid input"); return getName();}
    }

    /**
     * Gets the user input for a yes or no question
     *
     * @return boolean
     */
    public boolean getYesOrNo() {
        try {
            System.out.println("Would you like to play again? (y or n)");
            String choice = input.nextLine();
            if (Objects.equals(choice, "y") || Objects.equals(choice, "n")) {
                return choice.equals("y");
            } else {
                return getYesOrNo();
            }
        }catch(Exception e){System.out.println("Invalid Input"); return(getYesOrNo());}
    }
}
