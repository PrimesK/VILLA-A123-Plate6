package villaGraph;
import java.util.*;

public class item2 {
	private int[][] adjMatrix;
    private Map<String, Integer> edgeCountMap = new HashMap<>();

    public item2(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public void listEdges() {
        int n = adjMatrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { // To avoid counting edges twice
                if (adjMatrix[i][j] > 0) {
                    String edge = i + "-" + j;
                    edgeCountMap.put(edge, adjMatrix[i][j]);
                }
            }
        }
    }

    public void printEdges() {
        for (Map.Entry<String, Integer> entry : edgeCountMap.entrySet()) {
            System.out.println("Edge: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }

	public static void main(String[] args) {
		 /*Write a java program that accepts an adjacency matrix of a graph. The program should list the edges of this graph and give
		the number of times each edge appears.*/
        int[][] matrix1 = {
            {0, 1, 1, 0},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 0}
        };

        int[][] matrix2 = {
            {0, 2, 0, 0},
            {2, 0, 3, 0},
            {0, 3, 0, 1},
            {0, 0, 1, 0}
        };

        int[][] matrix3 = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };

        int[][] matrix4 = {
            {0, 1, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {0, 0, 1, 0}
        };

        int[][] matrix5 = {
            {0, 1, 1},
            {1, 0, 1},
            {1, 1, 0}
        };

        List<int[][]> useCases = Arrays.asList(matrix1, matrix2, matrix3, matrix4, matrix5);

        for (int i = 0; i < useCases.size(); i++) {
            System.out.println("Use Case " + (i + 1) + ":");
            item2 graph = new item2(useCases.get(i));
            graph.listEdges();
            graph.printEdges();
            System.out.println();
        }

	}

}
