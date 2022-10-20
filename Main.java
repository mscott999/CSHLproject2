public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze("large");
        System.out.println("BFS: " + maze.breadthFirstSearch());
        System.out.println("DFS: " + maze.depthFirstSearch());
    }
}