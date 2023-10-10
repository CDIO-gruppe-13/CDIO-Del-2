import java.util.Random;

/**
 * The {@code Dice} class creates a rollable dice with a definable number of
 * sides
 */
public class Dice {
    private int sides;
    private int value;

    /**
     * @param sides of the dice
     */
    public Dice(int sides) {
        if (sides < 0) {
            throw new IllegalArgumentException("The number of sides on a dice cannot be negative");
        }
        this.sides = sides;
    }

    /**
     * Calculates a random number within the range of the number of sides on the
     * dice and assigns it to the value of the dice
     */
    public void rollDice() {
        Random rand = new Random();
        this.value = rand.nextInt(sides) + 1;
    }

    /**
     * @return the value of the dice
     */
    public int getValue() {
        return this.value;
    }

}