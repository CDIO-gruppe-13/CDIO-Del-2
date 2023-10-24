public class Player {

  private String name;
  Account account;

  Player(String name, int startBalance) {
    this.name = name;
    this.account = new Account(startBalance);
  }

  public String toString() {
    return this.name + ": " + this.account.toString();
  }
}
