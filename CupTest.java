import java.util.Arrays;

/**
 * Tests to make sure dice are fair and statistically accurate. Simulates 1000 rolls and counts pairs and occurences of different sums.
 */
public class CupTest {
    public static void main(String[] args) {
        var cup = new Cup(2, 6);
        var pairs = 0;
        int[] sums = new int[11];
        double sum = 0;
        double start = System.nanoTime();
        for (var i = 0; i < 1000; i++) {
            cup.rollDice();
            sum = sum + cup.getDiceSum();
            sums[cup.getDiceSum() - 2] += 1;
            if (cup.isDiceEqual()) {
                pairs = pairs + 1;
            }
            System.out.println(String.format("Dice values: %s, sum: %d, is equal: %s",
                    Arrays.toString(cup.getDiceValues()), cup.getDiceSum(), String.valueOf(cup.isDiceEqual())));
        }
        double end = System.nanoTime();
        System.out.println("Number of pairs: " + pairs + " (statistically 166.67 is expected)");
        System.out.println("The mean of the sums is: " + sum / 1000 + " (statistically 7 is expected)");

        // Visualises the distribution of occurences of sums 
        for (var i = 0; i < sums.length; i++) {
            System.out.print((i + 2) + " (" + sums[i] + ")\t: ");
            for (var j = 0; j < Math.round(sums[i] / 10); j++) {
                System.out.print(("#"));
            }
            System.out.println((""));
        }
        System.out.println("This test took "+ (end - start)/1000000000 + " seconds");
    }
}