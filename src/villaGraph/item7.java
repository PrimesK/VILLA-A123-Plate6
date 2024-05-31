package villaGraph;
import java.util.*;

public class item7 {
    private int[][] incidenceMatrix;
    private int numVertices;
    private List<int[]> edges;

    public item7(int numVertices, List<int[]> edges) {
        this.numVertices = numVertices;
        this.edges = edges;
        this.incidenceMatrix = new int[edges.size()][numVertices];
    }

    public void constructIncidenceMatrix() {
        for (int i = 0; i < edges.size(); i++) {
            int[] edge = edges.get(i);
            int u = edge[0];
            int v = edge[1];
            int count = edge[2];

            incidenceMatrix[i][u]++;
            incidenceMatrix[i][v]++;
        }
    }

    public void printIncidenceMatrix() {
        for (int i = 0; i < incidenceMatrix.length; i++) {
            for (int j = 0; j < incidenceMatrix[i].length; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
    	/*Write a java program that accepts vertex pairs associated to the edges of an undirected graph and the number of times
		each edge appears. The program should construct an incidence matrix for the graph.*/
        List<int[][]> useCases = new ArrayList<>();
        useCases.add(new int[][] {{0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {3, 4, 1}}); // Simple undirected graph
        useCases.add(new int[][] {{0, 1, 2}, {1, 2, 1}, {2, 0, 3}}); // Undirected graph with multiple edges
        useCases.add(new int[][] {{0, 0, 1}, {1, 1, 1}, {2, 2, 1}, {2, 3, 1}, {3, 2, 1}}); // Undirected graph with loops
        useCases.add(new int[][] {{0, 1, 1}, {1, 2, 2}, {2, 3, 1}, {3, 4, 3}}); // Undirected graph with varied edge counts
        useCases.add(new int[][] {{0, 1, 2}, {1, 2, 2}, {2, 0, 1}, {1, 4, 1}}); // Undirected graph with varied edge counts and one isolated vertex

        int numVertices = 5; // Assume the number of vertices for simplicity. Adjust as needed.
        
        for (int i = 0; i < useCases.size(); i++) {
            System.out.println("Use Case " + (i + 1) + ":");
            item7 graph = new item7(numVertices, Arrays.asList(useCases.get(i)));
            graph.constructIncidenceMatrix();
            graph.printIncidenceMatrix();
            System.out.println();
        }
    }
}
