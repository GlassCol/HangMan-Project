import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isGameEndReturnsTrue() {
        Engine engine = new Engine();
        engine.wrongGuesses.add("z");engine.wrongGuesses.add("x");engine.wrongGuesses.add("c");
        engine.wrongGuesses.add("v");
        assertEquals(true,engine.isGameEnd());
    }
    @Test
    void isGameEndReturnsFalse() {
        Engine engine = new Engine();
        engine.wrongGuesses.add("z");engine.wrongGuesses.add("x");engine.wrongGuesses.add("c");
        assertEquals(false,engine.isGameEnd());
    }
    @Test
    void highScoreTest(){
        Engine engine = new Engine();
        assertEquals(true, engine.checkHighScore());
    }
    @Test
    void notHighScoreTest(){
        Engine engine = new Engine();
        engine.wrongGuesses.add("z");engine.wrongGuesses.add("x");engine.wrongGuesses.add("c");
        assertEquals(false, engine.checkHighScore());
    }
    @Test
    void checkForUniqueTest(){
        Engine engine = new Engine();
        engine.word.word = "guess";
        assertEquals(4, engine.checkForUnique());
    }
}