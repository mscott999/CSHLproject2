import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    private char[][] grid;
    private int[] start;
    private int[] goal;

    public Maze(String size) {
        if (size.equals("small")) {
            
        } else if (size.equals("medium")) {

        } else {

        }
    }

    public String[] breadthFirstSearch() {
        // Queue to track all unexplored coordinates of maze.
        Queue<Node> frontier = new LinkedList<>();
        frontier.add();
        // List of visited coordinates of maze.
        ArrayList<int[]> visited = new ArrayList<>();
        // List of Directions to reach goal.
        ArrayList<String> returnList = new ArrayList<>();

        boolean goalFound = false;
        while (!goalFound) {
            Node currentNode = frontier.remove();
        }
    }
    
}
