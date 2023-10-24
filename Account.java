public class Account {

  private int balance;

  Account(int startBalance) {
    this.balance = startBalance;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    if (balance < 0) {
      this.balance = 0;
    } else {
      this.balance = balance;
    }
  }

  public String toString() {
    return "The account has a balance of: " + this.balance;
  }
}
