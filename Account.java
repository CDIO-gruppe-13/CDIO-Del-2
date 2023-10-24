public class Account {
    private int balance;
    Account(int startBalance) {
        this.balance = startBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    public String toString() {
        return "The account has a balance of: " + this.balance;
    }
}