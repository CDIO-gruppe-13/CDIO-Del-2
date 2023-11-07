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
  private int turn = 0;
  Scanner scanner;

  Game(int players, int diceSides) {
    this.scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Which language? (english, deutsch, dansk, nihongo)");
      var language = this.scanner.nextLine();
      if (
        language.equals("english") ||
        language.equals("deutsch") ||
        language.equals("dansk") ||
        language.equals("nihongo")
      ) {
        this.language = new Language(language);
        break;
      } else {
        System.out.println("Wrong input.");
      }
    }
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
    this.cup = new Cup(2, diceSides);
  }

  void startGame() {
    // double start;
    // double end;

    var loadSaveFile = false;
    try {
      var saveFile = new File("SaveData.txt");
      if (saveFile.exists()) {
        while (true) {
          this.language.printSaveQuestion();
          var input = this.scanner.nextLine();
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
          System.out.println(
            this.players[i].getName() +
            ": " +
            this.language.getAccountMessage() +
            this.players[i].account.getBalance()
          );
        }
      }
    } catch (Exception e) {
      this.language.printNotLoaded();
    }
    if (!loadSaveFile) {
      for (var i = 0; i < this.players.length; i++) {
        this.language.printPlayerNameInput(i + 1);
        this.players[i] = new Player(this.scanner.nextLine(), 1000);
      }
    }

    gameloop:while (true) {
      this.language.printPlayerOptions(this.players[this.turn].getName());
      var input = this.scanner.nextLine();
      if (input.equals("q") || input.equals("quit")) {
        break gameloop;
      }
      if (input.equals("r") || input.equals("roll")) {
        // start = System.nanoTime();
      } else if (input.equals("s") || input.equals("save")) {
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
      var balance = this.players[this.turn].account.getBalance();
      var boardPosition = sum % this.boardFields.length;
      this.players[this.turn].account.setBalance(
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

      System.out.println(
        this.language.getAccountMessage() +
        this.players[this.turn].account.getBalance() +
        System.lineSeparator()
      );

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
      switchTurn();
      System.out.println(turn);
      System.out.println(this.players.length);
      // end = System.nanoTime();
      // System.out.println(
      //   "This test took " + (end - start) / 1000000000 + " seconds"
      // );
    }
    this.scanner.close();
  }

  public void switchTurn() {
    this.turn = (this.turn + 1) % this.players.length;
  }
}
