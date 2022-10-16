public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze("small");
        System.out.println("BFS: " + maze.breadthFirstSearch());
        System.out.println("DFS: " + maze.depthFirstSearch());
    }
}