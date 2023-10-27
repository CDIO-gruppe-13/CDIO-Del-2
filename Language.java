import java.io.BufferedReader;
import java.io.FileReader;

public class Language {

  private String saveQuestion;
  private String playerNameInput;
  private String playerOptions;
  private String wrongInput;
  private String diceValues;
  private String sum;
  private String landedOn;
  private String winner;
  private String notSaved;
  private String notLoaded;
  
  private String[] boardFields;

  Language(String language) {
    try {
      var br = new BufferedReader(new FileReader("languages.csv"));
      var line = "";
      while ((line = br.readLine()) != null) {
        var data = line.split(";");
        if (language.equals(data[0])) {
          {
            this.saveQuestion = data[1];
            this.playerNameInput = data[2];
            this.playerOptions = data[3];
            this.wrongInput = data[4];
            this.diceValues = data[5];
            this.sum = data[6];
            this.landedOn = data[7];
            this.winner = data[8];
            this.notSaved = data[9];
            this.notLoaded = data[10];
            this.boardFields = new String[data.length - 11];
            for (var i = 11; i < data.length; i++) {
             this.boardFields[i-11] = data[i];
            }
            break;
          }
        }
      }
      for (var i = 0; i < this.boardFields.length; i++) {
        System.out.println(this.boardFields[i]);
      }
      br.close();
    } catch (Exception e) {}
  }

  public void printSaveQuestion() {
    System.out.println(this.saveQuestion);
  }

  public void printPlayerNameInput(int number) {
    System.out.println(String.format(this.playerNameInput, number));
  }

  public void printPlayerOptions(String name) {
    System.out.println(String.format(this.playerOptions, name));
  }

  public void printWrongInput() {
    System.out.println(this.wrongInput);
  }

  public void printDiceValues(int[] diceValues) {
    System.out.print(this.diceValues + ":");
    for (var j = 0; j < diceValues.length; j++) {
      System.out.print(" " + diceValues[j]);
    }
  }

  public void printSum(int sumValue) {
    System.out.println(String.format(", %s: %d", this.sum, sumValue));
  }

  public void printLandedOn(int boardPosition, String boardName) {
    System.out.println(
      String.format("%s %d: %s", this.landedOn, boardPosition, boardName)
    );
  }

  public void printWinner(String name) {
    System.out.println(String.format("%s: %s!", this.winner, name));
  }
  public void printNotSaved() {
    System.out.println(this.notSaved);
  }
  public void printNotLoaded() {
    System.out.println(this.notLoaded);
  }
  public String[] getBoardNames() {
    return this.boardFields;
  }
}
