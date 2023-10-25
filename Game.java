import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Game {

  private Player[] players;
  private Cup cup;
  private BoardField[] boardFields = {
    // roll 0 (not possible)
    new BoardField(
      "The Void",
      0,
      "Oh no, you've rolled zero! Your turn is now skipped!"
    ),
    // roll 1 (not possible)
    new BoardField(
      "Theif's den",
      100,
      "You are the one and only theif! You steal 100 points from the other player."
    ),
    new BoardField(
      "The Tower",
      250,
      "You walk up to a huge tower, and climb the stairs - on the top of the stairs you find 250 gold!"
    ),
    new BoardField(
      "The Crater",
      -100,
      "You carefully approach the crater - when you peek into the dark 20 feet drop, a gust of wind blows you over the edge. When you wake up at the buttom, you have to take the bus to the top again - the ticket is 100 gold."
    ),
    new BoardField(
      "Palace Gates",
      100,
      "You approache the huge gates of the palace. You look up, and you feel tiny standing below those huge metalgates. You look downm and it seems someone dropped 100 gold on the ground - it's your lucky day!"
    ),
    new BoardField(
      "Cold Desert",
      -20,
      "The cold, dark desert in the night is a weird contrast to it's unforgiving heat during the day. You walk by a blanket-selling-shop and buy one for 20 gold."
    ),
    new BoardField(
      "Walled City",
      180,
      "The walls of the Walled City keep you safe from harm from the outside - but you also yearn for the freedom on the outside - you tell your stories at a bar down town, and the locals tip you 180 gold for intertaining them that night."
    ),
    new BoardField(
      "The Monastrey",
      0,
      "A monastery is a place for salvation and rest - here is no gold, only peace."
    ),
    new BoardField(
      "Black Cave",
      -70,
      "You've heard rumors of the Black Cave. Terriple rumors. You walk up to the cave, but the tickets are 70 gold a piece. You buy one, and joins the next guided tour. It was SUPER scary!"
    ),
    new BoardField(
      "Huts in the Mountains",
      60,
      "The wind is howling in these mountains - it freezing and you need shelter. Luckily you come across a couple of huts in the mountain. In there you find rest, warmth and 60 gold."
    ),
    new BoardField(
      "The Werewall",
      -80,
      "Oh wall, why do you have so big teeth? Oh no, it's a werewall! Don't get bitten! (You get bitten, and a has to pay 80 gold for a tetanus shot) - but you also get a lollipop! Roll the dice again!"
    ),
    // player gets an extra turn after warewall.
    new BoardField(
      "The Pit",
      -50,
      "The Pit is so deep you can't even see the bottom of it - you read a sign saying 'Wishing Pit' - you try your luck, make a wish and throw 50 gold down the pit - your wish doesn't come true."
    ),
    new BoardField(
      "The Goldmine",
      650,
      "We're rich! Hallelujah! Someone forgot to lock the doors at the gold mine, you go in there and fill your pockets - it adds up to 650 gold!"
    ),
  };

  Game(int players, int diceSides) {
    this.players = new Player[players];

    // System.out.print("How many sides should the two dice have? ");
    this.cup = new Cup(2, diceSides);
  }

  void startGame() {
    Scanner scanner = new Scanner(System.in);
    var loadSaveFile = false;
    try {
      var saveFile = new File("SaveData.txt");
      if (saveFile.exists()) {
        while (true) {
          System.out.println(
            "Do you wish to load the save file? yes (y), no (n)"
          );
          var input = scanner.nextLine();
          if (input.equals("y") || input.equals("yes")) {
            loadSaveFile = true;
            break;
          } else if (input.equals("n") || input.equals("no")) {
            break;
          } else {
            continue;
          }
        }
      }
      if (loadSaveFile) {
        var fileScanner = new Scanner(saveFile);
        for (var i = 0; fileScanner.hasNextLine(); i++) {
          var playerData = fileScanner.nextLine().split(",");
          var playerName = playerData[0];
          var playerBalance = Integer.parseInt(playerData[1]);
          this.players[i] = new Player(playerName, playerBalance);
        }
        fileScanner.close();
        for (var i = 0; i < this.players.length; i++) {
          System.out.println(this.players[i].toString());
        }
      }
    } catch (Exception e) {
      System.out.println("An error occured when loading a save file");
    }
    if (!loadSaveFile) {
      for (var i = 0; i < this.players.length; i++) {
        System.out.print("Player " + (i + 1) + " name: ");
        this.players[i] = new Player(scanner.nextLine(), 1000);
      }
    }

    int turn = 0;

    gameloop:while (true) {
      System.out.println(
        "Turn: " +
        this.players[turn].getName() +
        ", roll (r), quit (q), save (s): "
      );
      var input = scanner.nextLine();
      if (input.equals("q") || input.equals("quit")) {
        break gameloop;
      }
      if (input.equals("r") || input.equals("roll")) {} else if (
        input.equals("s") || input.equals("save")
      ) {
        try {
          var fileWriter = new FileWriter("SaveData.txt");
          for (var i = 0; i < this.players.length; i++) {
            fileWriter.write(
              String.format(
                "%s,%d\n",
                this.players[i].getName(),
                this.players[i].account.getBalance()
              )
            );
          }
          fileWriter.close();
        } catch (Exception e) {
          System.out.println("The game was not able to be saved");
        }
        continue;
      } else {
        System.out.println("Wrong input, try again");
        continue;
      }
      this.cup.rollDice();
      var sum = this.cup.getDiceSum();
      var balance = this.players[turn].account.getBalance();
      var boardPosition = sum % this.boardFields.length;
      this.players[turn].account.setBalance(
          balance + this.boardFields[boardPosition].getPoints()
        );
      var dieValues = this.cup.getDiceValues();
      System.out.print("Die values:");
      for (var j = 0; j < dieValues.length; j++) {
        System.out.print(" " + dieValues[j]);
      }
      System.out.println(", Sum: " + cup.getDiceSum());

      System.out.println(
        "Landed on field nr. " +
        boardPosition +
        ": " +
        this.boardFields[boardPosition].getName()
      );
      System.out.println(this.boardFields[boardPosition].getDescription());

      System.out.println(this.players[turn].account.toString() + "\n");

      // check for winner
      for (var i = 0; i < this.players.length; i++) {
        if (this.players[i].account.getBalance() >= 3000) {
          System.out.println(
            "The winner is: " + this.players[i].getName() + "!"
          );
          break gameloop;
        }
      }
      if (
        this.boardFields[boardPosition].getName().equals("The Werewall")
      ) continue;
      turn = (turn + 1) % this.players.length;
    }
    scanner.close();
  }
  // int getTurn() {}

  // String toString() {}
}
