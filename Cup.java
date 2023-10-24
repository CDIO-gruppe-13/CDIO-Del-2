import java.util.Vector;

/**
 * The {@code Cup} class simulates the cup typically used in board games to roll
 * multiple dice.
 */
public class Cup {
    private Vector<Dice> dice = new Vector<Dice>();
    private int amountOfDice;

    /**
     * Constructs a {@code Cup} object that contains a specified amount of
     * {@code Dice} objects
     * 
     * @param amountOfDice integar value of the number of dice in the cup
     */
    public Cup(int amountOfDice, int diceSides) {
        this.amountOfDice = amountOfDice;
        for (var i = 0; i < this.amountOfDice; i++) {
            var dice = new Dice(diceSides);
            this.dice.add(dice);
        }
    }

    /**
     * Rolls all the dice in the cup
     */
    public void rollDice() {
        for (var i = 0; i < this.amountOfDice; i++) {
            this.dice.get(i).rollDice();
        }

    }

    /**
     * @return an array of integars that contain the value of each dice in the cup
     */
    public int[] getDiceValues() {
        int[] values = new int[this.amountOfDice];
        for (var i = 0; i < this.amountOfDice; i++) {
            values[i] = this.dice.get(i).getValue();
        }
        return values;
    }

    /** 
     * @return the sum of all dice
     */
    public int getDiceSum() {
        int sum = 0;
        for (var i = 0; i < this.amountOfDice; i++) {
            sum += this.dice.get(i).getValue();
        }
        return sum;
    }

    /** 
     * @return if the values of the dice are the same
     */
    public boolean isDiceEqual() {
        for (var i = 1; i < this.amountOfDice; i++) {
            if (this.dice.get(i - 1).getValue() != this.dice.get(i).getValue()) {
                return false;
            }
        }
        return true;
    }
}
