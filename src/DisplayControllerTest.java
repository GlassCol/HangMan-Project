import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DisplayControllerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void wrongGuessDisplaysCorrectly() {
        Word word = new Word();
        DisplayController controller = new DisplayController(word);
        ArrayList<String> wrongGuesses = new ArrayList();
        wrongGuesses.add("t");        wrongGuesses.add("a");
        assertEquals("ta", controller.wrongGuessDisplay(wrongGuesses));
    }
}