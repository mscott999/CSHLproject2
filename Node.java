public class Node {
    private int[] coordinate;
    private String direction;
    private Maze maze;
    private Node parent;

    public Node(Maze maze, int[] coordinate) {
        this.maze = maze;
        this.coordinate = coordinate;
    }
}