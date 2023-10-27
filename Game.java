import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Game {

  private Player[] players;
  private Cup cup;
  private final int[] boardValues = {
    0,
    100,
    250,
    -100,
    100,
    -20,
    180,
    0,
    -70,
    60,
    -80,
    -50,
    650,
  };
  private BoardField[] boardFields;
  private Language language;

  Game(int players, int diceSides) {
    this.language = new Language("english");
    this.players = new Player[players];
    var boardNames = this.language.getBoardNames();
    this.boardFields = new BoardField[boardNames.length / 2];
    for (var i = 0; i < (boardNames.length / 2); i++) {
      this.boardFields[i] =
        new BoardField(
          boardNames[i * 2],
          this.boardValues[i],
          boardNames[i * 2 + 1]
        );
    }

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
          this.language.printSaveQuestion();
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
      this.language.printNotLoaded();
    }
    if (!loadSaveFile) {
      for (var i = 0; i < this.players.length; i++) {
        this.language.printPlayerNameInput(i + 1);
        this.players[i] = new Player(scanner.nextLine(), 1000);
      }
    }

    int turn = 0;

    gameloop:while (true) {
      this.language.printPlayerOptions(this.players[turn].getName());
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
          this.language.printNotSaved();
        }
        continue;
      } else {
        this.language.printWrongInput();
        continue;
      }
      this.cup.rollDice();
      var sum = this.cup.getDiceSum();
      var balance = this.players[turn].account.getBalance();
      var boardPosition = sum % this.boardFields.length;
      this.players[turn].account.setBalance(
          balance + this.boardFields[boardPosition].getPoints()
        );
      var diceValues = this.cup.getDiceValues();
      this.language.printDiceValues(diceValues);
      this.language.printSum(cup.getDiceSum());

      this.language.printLandedOn(
          boardPosition,
          this.boardFields[boardPosition].getName()
        );

      System.out.println(this.boardFields[boardPosition].getDescription());

      System.out.println(this.players[turn].account.toString() + "\n");

      // check for winner
      for (var i = 0; i < this.players.length; i++) {
        if (this.players[i].account.getBalance() >= 3000) {
          this.language.printWinner(this.players[i].getName());

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
}
