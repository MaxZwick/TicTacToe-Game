import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    // Konstruktor: Bereitet das Spiel vor
    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1; // Spieler 1 (X) fängt immer an
        board = new Board();
    }

    // Die Hauptschleife des Spiels
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("Willkommen bei Tic-Tac-Toe!");

        // Äußere Schleife für mehrere aufeinanderfolgende Spiele (US-4)
        while (playAgain) {
            boolean gameEnded = false;
            board.clear(); // Spielfeld für das neue Spiel leeren
            currentPlayer = player1; // Spieler 1 (X) fängt wieder an

            // Innere Schleife für ein einzelnes Spiel (US-1 bis US-3)
            while (!gameEnded) {
                System.out.println("\n--- Neuer Zug ---");
                System.out.println("Current Player: " + currentPlayer.getMarker());
                board.print();

                System.out.print("row (0-2): ");
                int row = scanner.nextInt();
                System.out.print("column (0-2): ");
                int col = scanner.nextInt();

                // Prüfen, ob das Feld frei und gültig ist
                if (board.isCellEmpty(row, col)) {
                    board.place(row, col, currentPlayer.getMarker());

                    if (hasWinner()) {
                        System.out.println("\nHERZLICHEN GLÜCKWUNSCH!");
                        System.out.println("Spieler " + currentPlayer.getMarker() + " hat das Spiel gewonnen!");
                        board.print();
                        gameEnded = true;
                    } else if (board.isFull()) {
                        System.out.println("\nDas Spielfeld ist voll! Es ist ein Unentschieden.");
                        board.print();
                        gameEnded = true;
                    } else {
                        switchCurrentPlayer();
                    }
                } else {
                    System.out.println("Dieses Feld ist bereits belegt oder ungültig. Versuch es noch einmal!");
                }
            }

            // US-4: Nach dem Spiel fragen, ob man noch mal spielen will
            System.out.print("\nMöchtest du noch eine Runde spielen? (j/n): ");
            String answer = scanner.next();
            if (!answer.equalsIgnoreCase("j")) {
                playAgain = false; // Bricht die äußere Schleife ab
                System.out.println("Danke fürs Spielen! Bis zum nächsten Mal.");
            }
        }
        scanner.close();
    }

    // Wechselt den aktuellen Spieler
    private void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    // Prüft, ob der aktuelle Spieler gewonnen hat
    private boolean hasWinner() {
        char m = currentPlayer.getMarker(); // Das Zeichen des aktuellen Spielers (X oder O)

        // 1. Zeilen prüfen
        for (int i = 0; i < 3; i++) {
            if (board.getCell(i, 0) == m && board.getCell(i, 1) == m && board.getCell(i, 2) == m) {
                return true;
            }
        }
        // 2. Spalten prüfen
        for (int j = 0; j < 3; j++) {
            if (board.getCell(0, j) == m && board.getCell(1, j) == m && board.getCell(2, j) == m) {
                return true;
            }
        }
        // 3. Diagonalen prüfen
        if (board.getCell(0, 0) == m && board.getCell(1, 1) == m && board.getCell(2, 2) == m) {
            return true;
        }
        if (board.getCell(0, 2) == m && board.getCell(1, 1) == m && board.getCell(2, 0) == m) {
            return true;
        }

        return false; // Wenn nichts zutrifft, hat noch niemand gewonnen
    }

    // --- MAIN METHODE ZUM STARTEN DES SPIELS ---
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}