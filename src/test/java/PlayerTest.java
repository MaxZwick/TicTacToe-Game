import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    // Positiv-Test: Prüft, ob das zugewiesene Zeichen exakt zurückgegeben wird
    @Test
    void testGetMarker_Positive() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker(), "Der Marker sollte 'X' sein.");
    }

    // Negativ-Test: Prüft, dass ein Spieler mit 'O' nicht versehentlich als 'X' erkannt wird
    @Test
    void testGetMarker_Negative() {
        Player player = new Player('O');
        assertNotEquals('X', player.getMarker(), "Ein 'O'-Spieler darf nicht den Marker 'X' haben.");
    }
}