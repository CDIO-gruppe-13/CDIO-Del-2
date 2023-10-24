public class Boardgame {
    private Player[] players = { new Player(), new Player() };
    private Cup cup = new Cup(2);

    public void Startgame() {
        var scanner = new java.util.Scanner(System.in);
        for (var i = 0; i < this.players.length; i++) {
            System.out.print("Player " + (i + 1) + " name: ");
            var playerName = scanner.nextLine();
            this.players[i].name = playerName;
        }

    }

}
