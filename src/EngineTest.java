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
        engine.guessCount = 4;
        assertEquals(true,engine.isGameEnd());
    }
    @Test
    void isGameEndReturnsFalse() {
        Engine engine = new Engine();
        engine.guessCount = 3;
        assertEquals(false,engine.isGameEnd());
    }
}