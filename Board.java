public class Board {

  private String name;
  private int points;
  private String description;

  public Board(String name, int points, String description) {
    this.name = name;
    this.points = points;
    this.description = description;
  }

  public String getName() {
    return this.name;
  }

  public int getPoints() {
    return this.points;
  }

  public String getDescription() {
    return this.description;
  }
}
