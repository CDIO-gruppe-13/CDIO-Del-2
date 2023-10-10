import java.util.Vector;

/**
 * The {@code Cup} class simulates the cup typically used in board games to roll
 * multiple die.
 */
public class Cup {
    private Vector<Dice> die = new Vector<Dice>();
    private int amountOfDie;

    /**
     * Constructs a {@code Cup} object that contains a specified amount of
     * {@code Dice} objects
     * 
     * @param amountOfDie integar value of the number of die in the cup
     */
    public Cup(int amountOfDie) {
        this.amountOfDie = amountOfDie;
        for (var i = 0; i < this.amountOfDie; i++) {
            var dice = new Dice(6);
            this.die.add(dice);
        }
    }

    /**
     * Rolls all the die in the cup
     */
    public void rollDie() {
        for (var i = 0; i < this.amountOfDie; i++) {
            this.die.get(i).rollDice();
        }

    }

    /**
     * @return an array of integars that contain the value of each dice in the cup
     */
    public int[] getDieValues() {
        int[] values = new int[this.amountOfDie];
        for (var i = 0; i < this.amountOfDie; i++) {
            values[i] = this.die.get(i).getValue();
        }
        return values;
    }

    /** 
     * @return the sum of all die
     */
    public int getDieSum() {
        int sum = 0;
        for (var i = 0; i < this.amountOfDie; i++) {
            sum += this.die.get(i).getValue();
        }
        return sum;
    }

    /** 
     * @return if the values of the die are the same
     */
    public boolean isDieEqual() {
        for (var i = 1; i < this.amountOfDie; i++) {
            if (this.die.get(i - 1).getValue() != this.die.get(i).getValue()) {
                return false;
            }
        }
        return true;
    }
}
