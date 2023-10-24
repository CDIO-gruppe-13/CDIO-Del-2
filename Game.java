public class Game {
    private Player[] players;
    private Cup cup;
    private BoardField[] boardFields;

    Game(int players, int diceSides) {
        this.players = new Player[players];
        var scanner = new java.util.Scanner(System.in);
        for (var i = 0; i < players; i++) {
            System.out.print("Player " + (i+1) + " name: ");
            this.players[i] = new Player(scanner.nextLine(), 1000);
        }

        System.out.print("How many sides should the two dice have? ");
        this.cup = new Cup(scanner.nextInt());
        scanner.close();
    }
    void startGame() {
        
    }

    // int getTurn() {}

    // String toString() {}
}