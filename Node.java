import java.util.ArrayList;

public class Node {
    // Coordinate of Node on ASCII grid.
    private int[] coordinate;
    // Direction taken to reach current node from parent node.
    private String direction;
    private Maze maze;
    private Node parent;

    public Node(Maze maze, int[] coordinate, Node parent) {
        this.maze = maze;
        this.coordinate = coordinate;
        this.parent = parent;
        if (parent != null) {
            if (coordinate[0] > parent.getCoordinate()[0]) {
                direction = "down";
            } else if (coordinate[0] < parent.getCoordinate()[0]) {
                direction = "up";
            } else if (coordinate[1] > parent.getCoordinate()[1]) {
                direction = "right";
            } else {
                direction = "left";
            }
        } else {
            direction = null;
        }
    }

    public Node(Maze maze, int[] coordinate) {
        this(maze, coordinate, null);
    }

    // Used to determine whether or not this node is the starting node of the maze.
    public boolean hasParent() {
        if (parent == null) {
            return false;
        } else {
            return true;
        }
    }
    
    // Returns a list of all coordinates on the maze accessible from this node.
    public ArrayList<int[]> getSuccessors() {
        ArrayList<int[]> returnList = new ArrayList<>();
        if (maze.getGrid()[coordinate[0] - 1][coordinate[1]] != '#') {
            int[] tempCoordinate = {coordinate[0] - 1, coordinate[1]};
            returnList.add(tempCoordinate);
        }
        if (maze.getGrid()[coordinate[0] + 1][coordinate[1]] != '#') {
            int[] tempCoordinate = {coordinate[0] + 1, coordinate[1]};
            returnList.add(tempCoordinate);
        }
        if (maze.getGrid()[coordinate[0]][coordinate[1] - 1] != '#') {
            int[] tempCoordinate = {coordinate[0], coordinate[1] - 1};
            returnList.add(tempCoordinate);
        }
        if (maze.getGrid()[coordinate[0]][coordinate[1] + 1] != '#') {
            int[] tempCoordinate = {coordinate[0], coordinate[1] + 1};
            returnList.add(tempCoordinate);
        }
        return returnList;
    }

    // Returns coordinate of node.
    public int[] getCoordinate() {
        return coordinate;
    }

    // returns direction taken to reach this node.
    public String getDirection() {
        return direction;
    }

    // Returns parent node.
    public Node getParent() {
        return parent;
    }
}