import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Objects;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InputControllerTest {


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getGoodUserChoice() {
        ByteArrayInputStream in = new ByteArrayInputStream("y".getBytes());
        Scanner input = new Scanner(in);
        boolean Valid = false;
        String choice = "";
        try {
            while (choice.length() > 1 || !Valid) {
                if (choice.length() > 0) System.out.println("Sorry please choose only one letter character");
                System.out.println("Guess a letter: ");
                choice = input.nextLine();
                if (choice.matches("[a-zA-Z]")) Valid = true;
            }
        } catch (Exception e) {
            System.out.println("Error try again: ");
        }
        assertEquals("y", choice);
    }
    @Test
    void getLongUserChoice() {
        ByteArrayInputStream in = new ByteArrayInputStream("Random".getBytes());
        Scanner input = new Scanner(in);
        boolean Valid = false;
        String choice = "";
        try {
            while (choice.length() > 1 || !Valid) {
                if (choice.length() > 0) {
                    System.out.println("Sorry please choose only one letter character");
                    assertEquals(true, choice.length() > 0);
                }
                System.out.println("Guess a letter: ");
                choice = input.nextLine();
                if (choice.matches("[a-zA-Z]")) Valid = true;
            }
        } catch (Exception e) {
            System.out.println("Error try again: ");
        }
    }

    @Test
    void getNumericalUserChoice() {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        Scanner input = new Scanner(in);
        boolean Valid = false;
        String choice = "";
        try {
            while (choice.length() > 1 || !Valid) {
                if (choice.length() > 0)
                    System.out.println("Sorry please choose only one letter character");
                System.out.println("Guess a letter: ");
                choice = input.nextLine();
                if (choice.matches("[a-zA-Z]")) Valid = true;
                else assertEquals( false, choice == "[a-zA-Z]");
            }
        } catch (Exception e) {
            System.out.println("Error try again: ");
        }
    }

    @Test
    void getYes() {
        ByteArrayInputStream in = new ByteArrayInputStream("y".getBytes());
        Scanner input = new Scanner(in);
        boolean Valid = false;
        String choice;
        while (!Valid) {
            System.out.println("Would you like to play again? (y or n)");
            choice = input.nextLine();
            if (Objects.equals(choice, "y") || Objects.equals(choice, "n")) {
                Valid = true;
            }
        }
        assertTrue(true);
    }
    @Test
    void getNo() {
        ByteArrayInputStream in = new ByteArrayInputStream("n".getBytes());
        Scanner input = new Scanner(in);
        boolean Valid = false;
        String choice;
        while (!Valid) {
            System.out.println("Would you like to play again? (y or n)");
            choice = input.nextLine();
            if (Objects.equals(choice, "y") || Objects.equals(choice, "n")) {
                Valid = true;
            }
        }
        assertTrue(true);
    }
    @Test
    void getOther() {
        ByteArrayInputStream in = new ByteArrayInputStream("Random".getBytes());
        Scanner input = new Scanner(in);
        boolean Valid = false;
        String choice;
        while (!Valid) {
            System.out.println("Would you like to play again? (y or n)");
            choice = input.nextLine();
            if (Objects.equals(choice, "y") || Objects.equals(choice, "n")) {
                Valid = true;
            }
            else   assertFalse(false);
            break;
        }

    }
}