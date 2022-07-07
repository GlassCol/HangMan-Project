import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class DisplayControllerTest {
    Word word = new Word("word");
    DisplayController controller = new DisplayController(word);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void wordDisplay() {
        HashSet<String> guesses = new HashSet<>();
        guesses.add("o");
        assertEquals("_o__", controller.wordDisplay(guesses));
    }
}