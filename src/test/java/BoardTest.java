import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    // @BeforeEach sorgt dafür, dass vor JEDEM einzelnen Test ein frisches, leeres Spielfeld erstellt wird
    @BeforeEach
    void setUp() {
        board = new Board();
    }

    // --- Tests für isCellEmpty() ---

    @Test
    void testIsCellEmpty_Positive() {
        // Positiv-Test: Auf einem frischen Board muss das Feld (0,0) leer sein
        assertTrue(board.isCellEmpty(0, 0), "Das Feld (0,0) sollte anfangs leer sein.");
    }

    @Test
    void testIsCellEmpty_Negative() {
        // Negativ-Test 1: Wir setzen einen Stein. Das Feld darf nun NICHT mehr leer sein.
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0), "Nach dem Setzen eines Steins darf das Feld nicht mehr leer sein.");

        // Negativ-Test 2: Wir fragen Koordinaten ab, die gar nicht auf dem 3x3 Feld existieren (z.B. 5,5)
        assertFalse(board.isCellEmpty(5, 5), "Ungültige Koordinaten sollten als 'nicht leer' (false) gewertet werden.");
    }


    // --- Tests für isFull() ---

    @Test
    void testIsFull_Negative() {
        // Negativ-Test: Ein komplett neues (leeres) Board darf nicht als 'voll' gelten
        assertFalse(board.isFull(), "Ein frisches Board darf nicht voll sein.");
    }

    @Test
    void testIsFull_Positive() {
        // Positiv-Test: Wir füllen das komplette Spielfeld mit einer Schleife künstlich auf
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        // Jetzt MUSS das Board voll sein
        assertTrue(board.isFull(), "Wenn alle Felder belegt sind, muss das Board als voll erkannt werden.");
    }
}