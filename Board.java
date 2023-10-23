public class Board {
    private String name;
    private int points;
    private String description;

    public Board(String name, int points, String description) {
        this.name = name;
        this.points = points;
        this.description = description;
    }
    /*
     * public void printFunctionTest() {
     * System.out.println(name);
     * System.out.println(points);
     * }
     * 
     * //Test to check constructor
     * public static void main(String[] args) {
     * Board field_one = new Board("Tower", 250,
     * "You walk up to a huge tower, and climb the stairs - on the top of the stairs you find 250 gold!"
     * );
     * 
     * field_one.printFunctionTest();
     * }
     */

}