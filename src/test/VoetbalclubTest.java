import dev.flur.practicum2.Voetbalclub;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VoetbalclubTest {
    private Voetbalclub v;

    @BeforeEach
    public void init() {
        v = new Voetbalclub();
    }

    @DisplayName("Name is FC")
    @Test
    public void testNameEqualsFC() {
        assertEquals("FC", v.getNaam());
    }

    @DisplayName("Name is null")
    @Test
    public void testNameEqualsNull() {
        v = new Voetbalclub(null);
        assertEquals("FC", v.getNaam());
    }

    @DisplayName("Check wins")
    @Test
    public void testWins() {
        v.verwerkResultaat('w');
        assertEquals(1, v.getAantalGewonnen());
    }

    @DisplayName("Check losses")
    @Test
    public void testLosses() {
        v.verwerkResultaat('v');
        assertEquals(1, v.getAantalVerloren());
    }

    @DisplayName("Check ties")
    @Test
    public void testTies() {
        v.verwerkResultaat('g');
        assertEquals(1, v.getAantalGelijk());
    }

    @DisplayName("Check wrong input")
    @Test
    public void testWrongInput() {
        v.verwerkResultaat('X');
        assertEquals("FC 0 0 0 0 0", v.toString());
    }

    @DisplayName("Count wins")
    @Test
    public void testCountWins() {
        v.verwerkResultaat('w');
        assertEquals("FC 1 1 0 0 3", v.toString());
    }

    @DisplayName("Count losses")
    @Test
    public void testCountLosses() {
        v.verwerkResultaat('v');
        assertEquals("FC 1 0 0 1 0", v.toString());
    }

    @DisplayName("Count ties")
    @Test
    public void testCountTies() {
        v.verwerkResultaat('g');
        assertEquals("FC 1 0 1 0 1", v.toString());
    }

    @DisplayName("Repeated Scores")
    @Test
    public void testRepeatedWinScores() {
        for (int i = 1; i < 5; i++) {
            v.verwerkResultaat('w');
            assertEquals(i * 3, v.aantalPunten());
        }
    }

    @DisplayName("Name is empty string")
    @Test
    public void testNameEmptyString() {
        v = new Voetbalclub("");
        assertEquals("FC", v.getNaam());
    }

    @DisplayName("Process multiple results")
    @Test
    public void testMultipleResults() {
        v.verwerkResultaat('w');
        v.verwerkResultaat('g');
        v.verwerkResultaat('v');
        assertEquals(1, v.getAantalGewonnen());
        assertEquals(1, v.getAantalGelijk());
        assertEquals(1, v.getAantalVerloren());
        assertEquals(3 + 1, v.aantalPunten());
    }

    @DisplayName("Total games played")
    @Test
    public void testTotalGamesPlayed() {
        v.verwerkResultaat('w');
        v.verwerkResultaat('w');
        v.verwerkResultaat('g');
        v.verwerkResultaat('v');
        assertEquals(4, v.aantalGespeeld());
    }

    @DisplayName("ToString after multiple results")
    @Test
    public void testToStringMultipleResults() {
        v.verwerkResultaat('w');
        v.verwerkResultaat('g');
        v.verwerkResultaat('v');
        assertEquals("FC 3 1 1 1 4", v.toString());
    }

    @DisplayName("Repeated invalid input")
    @Test
    public void testRepeatedInvalidInput() {
        v.verwerkResultaat('X');
        v.verwerkResultaat('X');
        v.verwerkResultaat('X');
        assertEquals("FC 0 0 0 0 0", v.toString());
    }

    @DisplayName("Case sensitivity")
    @Test
    public void testCaseSensitivity() {
        v.verwerkResultaat('W');
        v.verwerkResultaat('w');
        assertEquals(1, v.getAantalGewonnen());
        assertEquals("FC 1 1 0 0 3", v.toString());
    }

    @DisplayName("Name with only spaces")
    @Test
    public void testNameWithSpaces() {
        v = new Voetbalclub("   ");
        assertEquals("FC", v.getNaam());
    }

    @DisplayName("Score not affected by losses or invalid input")
    @Test
    public void testScoreUnaffected() {
        v.verwerkResultaat('w');
        v.verwerkResultaat('v');
        v.verwerkResultaat('X');
        assertEquals(3, v.aantalPunten());
    }

    @DisplayName("Large number of games")
    @Test
    public void testLargeNumberOfGames() {
        for (int i = 0; i < 1000; i++) {
            v.verwerkResultaat('w');
        }
        assertEquals(1000, v.getAantalGewonnen());
        assertEquals(3000, v.aantalPunten());
        assertEquals(1000, v.aantalGespeeld());
    }

    @DisplayName("Null input")
    @Test
    public void testNullInput() {
        v.verwerkResultaat('\0');
        assertEquals("FC 0 0 0 0 0", v.toString());
    }

}
