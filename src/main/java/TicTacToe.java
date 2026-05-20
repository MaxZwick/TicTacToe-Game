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
        boolean gameEnded = false;

        System.out.println("Willkommen bei Tic-Tac-Toe!");

        while (!gameEnded) {
            System.out.println("\n--- Neuer Zug ---");
            System.out.println("Current Player: " + currentPlayer.getMarker());
            board.print();

            System.out.print("row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("column (0-2): ");
            int col = scanner.nextInt();

            // Prüfen, ob das Feld frei und gültig ist (US-1)
            if (board.isCellEmpty(row, col)) {
                board.place(row, col, currentPlayer.getMarker());

                // Für US-1 prüfen wir vorerst nur, ob das Brett voll ist (Unentschieden)
                if (board.isFull()) {
                    System.out.println("Das Spielfeld ist voll! Unentschieden.");
                    board.print();
                    gameEnded = true;
                } else {
                    switchCurrentPlayer(); // Nächster Spieler ist dran
                }
            } else {
                System.out.println("Dieses Feld ist bereits belegt oder ungültig. Versuch es noch einmal!");
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

    // Wird später in US-3 richtig programmiert!
    private boolean hasWinner() {
        return false;
    }

    // --- MAIN METHODE ZUM STARTEN DES SPIELS ---
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}

