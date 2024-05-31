package villaGraph;
import java.util.*;

public class item6 {
    private int[][] adjMatrix;
    private int numVertices;

    public item6(int numVertices) {
        this.numVertices = numVertices;
        this.adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int u, int v) {
        if (u >= numVertices || v >= numVertices) {
            System.out.println("Invalid edge: (" + u + ", " + v + ")");
            return;
        }
        adjMatrix[u][v]++;
    }

    public void printAdjacencyMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
    	/*Write a java program that receives the vertex pairs associated to the edges of a graph, the program should construct an
		adjacency matrix for the graph. (Produce a version that works when loops, multiple edges, or directed edges are present.)*/
        List<int[][]> useCases = new ArrayList<>();
        useCases.add(new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}}); // Simple directed graph
        useCases.add(new int[][] {{0, 1}, {1, 2}, {2, 0}, {0, 1}}); // Directed graph with multiple edges
        useCases.add(new int[][] {{0, 0}, {1, 1}, {2, 2}, {2, 3}, {3, 2}}); // Directed graph with loops
        useCases.add(new int[][] {{0, 1}, {1, 0}, {2, 3}, {3, 2}}); // Directed graph with bidirectional edges
        useCases.add(new int[][] {{0, 1}, {1, 0}, {1, 0}}); // Directed graph with multiple edges in both directions

        int maxVertices = 5; // Assume the number of vertices for simplicity. Adjust as needed.
        
        for (int i = 0; i < useCases.size(); i++) {
            System.out.println("Use Case " + (i + 1) + ":");
            item6 graph = new item6(maxVertices);
            for (int[] edge : useCases.get(i)) {
                if (edge.length == 2) {
                    graph.addEdge(edge[0], edge[1]);
                }
            }
            graph.printAdjacencyMatrix();
            System.out.println();
        }
    }
}
