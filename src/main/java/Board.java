public class Board {
    private char[][] cells;

    // Konstruktor: Erstellt ein 3x3 Spielfeld und leert es
    public Board() {
        cells = new char[3][3];
        clear();
    }

    // Macht alle Felder leer (füllt sie mit einem Leerzeichen ' ')
    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    // Prüft, ob die Zelle bei (x, y) leer ist
    public boolean isCellEmpty(int x, int y) {
        // Sicherstellen, dass die Eingabe überhaupt auf dem Spielfeld liegt
        if (x >= 0 && x < 3 && y >= 0 && y < 3) {
            return cells[x][y] == ' ';
        }
        return false;
    }

    // Setzt das Zeichen des Spielers an die Position (x, y)
    public void place(int x, int y, char marker) {
        if (x >= 0 && x < 3 && y >= 0 && y < 3) {
            cells[x][y] = marker;
        }
    }

    // Prüft, ob das Spielfeld komplett voll ist (keine Leerzeichen mehr)
    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return false; // Sobald ein Feld leer ist, ist es nicht voll
                }
            }
        }
        return true;
    }

    // Gibt das Spielfeld so aus, wie es im Beispiel-Screenshot gefordert ist
    public void print() {
        System.out.println("-------"); // Obere Begrenzung
        for (int i = 0; i < 3; i++) {
            System.out.print("|"); // Linker Rand
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] + "|"); // Das Zeichen und der Trenner
            }
            System.out.println(); // Zeilenumbruch
        }
        System.out.println("-------"); // Untere Begrenzung
    }

    // Gibt das Zeichen an einer bestimmten Position zurück (Hilfsmethode für die Gewinnprüfung)
    public char getCell(int x, int y) {
        return cells[x][y];
    }
}
