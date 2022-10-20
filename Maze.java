import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Maze {
    // ASCII grid representing the searchable maze.
    private char[][] grid;
    // Coordinate of starting position.
    private int[] start;
    // Coordinate of goal.
    private int[] goal;

    public Maze(String size) {
        if (size.equals("small")) {
            grid = new char[][]{
                {'#', '#', '#', '#', '#', '#', '#'},
                {'#', '-', '-', '-', '-', 'O', '#'},
                {'#', '-', '#', '#', '#', '-', '#'},
                {'#', '-', '-', '#', '-', '-', '#'},
                {'#', '#', '-', '-', '-', '#', '#'},
                {'#', 'X', '-', '#', '#', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#'},
            };
            start = new int[]{1, 5};
            goal = new int[]{5, 1};
        } else if (size.equals("medium")) {
            grid = new char[][]{
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '-', '-', '-', '-', '-', '-', '#', 'O', '#'},
                {'#', '-', '#', '#', '#', '#', '-', '-', '-', '#'},
                {'#', '-', '-', '-', '-', '#', '#', '-', '#', '#'},
                {'#', '#', '#', '#', '-', '#', '#', '-', '-', '#'},
                {'#', '-', '-', '-', '-', '-', '#', '#', '-', '#'},
                {'#', '-', '#', '#', '#', '-', '-', '-', '-', '#'},
                {'#', '-', '#', 'X', '#', '#', '#', '#', '-', '#'},
                {'#', '-', '-', '-', '#', '-', '-', '-', '-', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            };
            start = new int[]{1, 8};
            goal = new int[]{7, 3};
        }
    }

    // Search function that returns an ArrayList of strings representing the directions to take to reach the goal. BFS searches coordinates closest to the starting position first.
    public ArrayList<String> breadthFirstSearch() {
        // Queue of unsearched nodes.
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(new Node(this, start));
        // List of searched coordinates.
        ArrayList<int[]> visited = new ArrayList<>();
        // List of directions to reach goal.
        ArrayList<String> returnList= new ArrayList<>();
        boolean goalFound = false;
        while (!goalFound) {
            Node currentNode = frontier.remove();
            if (Arrays.equals(currentNode.getCoordinate(), goal)) {
                goalFound = true;
                while (currentNode.hasParent()) {
                    returnList.add(currentNode.getDirection());
                    currentNode = currentNode.getParent();
                }
                Collections.reverse(returnList);
                return returnList;
            } else {
                visited.add(currentNode.getCoordinate());
                for (int[] coordinate : currentNode.getSuccessors()) {
                    Node childNode = new Node(this, coordinate, currentNode);
                    boolean addToFrontier = true;
                    for (int[] past : visited) {
                        if (Arrays.equals(past, childNode.getCoordinate())) {
                            addToFrontier = false;
                            break;
                        }
                    }
                    for (Node future : frontier) {
                        if (Arrays.equals(future.getCoordinate(), childNode.getCoordinate())) {
                            addToFrontier = false;
                            break;
                        }
                    }
                    if (addToFrontier) {
                        frontier.add(childNode);
                    }
                }
            }
        }
        return null;
    }

    // Search function that returns an ArrayList of strings representing the directions to take to reach the goal. DFS searches an entire path of coordinates until it reaches a dead end, unlike BFS.
    public ArrayList<String> depthFirstSearch() {
        // Stack of unsearched nodes.
        Stack<Node> frontier = new Stack<>();
        frontier.push(new Node(this, start));
        // List of searched coordinates.
        ArrayList<int[]> visited = new ArrayList<>();
        // List of directions to reach goal.
        ArrayList<String> returnList= new ArrayList<>();
        boolean goalFound = false;
        while (!goalFound) {
            Node currentNode = frontier.pop();
            if (Arrays.equals(currentNode.getCoordinate(), goal)) {
                goalFound = true;
                while (currentNode.hasParent()) {
                    returnList.add(currentNode.getDirection());
                    currentNode = currentNode.getParent();
                }
                Collections.reverse(returnList);
                return returnList;
            } else {
                visited.add(currentNode.getCoordinate());
                for (int[] coordinate : currentNode.getSuccessors()) {
                    Node childNode = new Node(this, coordinate, currentNode);
                    boolean addToFrontier = true;
                    for (int[] past : visited) {
                        if (Arrays.equals(past, childNode.getCoordinate())) {
                            addToFrontier = false;
                            break;
                        }
                    }
                    for (Node future : frontier) {
                        if (Arrays.equals(future.getCoordinate(), childNode.getCoordinate())) {
                            addToFrontier = false;
                            break;
                        }
                    }
                    if (addToFrontier) {
                        frontier.push(childNode);
                    }
                }
            }
        }
        return null;
    }

    // Returns ASCII grid of maze.
    public char[][] getGrid() {
        return grid;
    }
}
