public class Player {
    private char marker;

    // Der Konstruktor: Wird aufgerufen, wenn ein neuer Spieler erstellt wird
    public Player(char marker) {
        this.marker = marker;
    }

    // Gibt das Zeichen des Spielers (z.B. 'X' oder 'O') zurück
    public char getMarker() {
        return marker;
    }
}
