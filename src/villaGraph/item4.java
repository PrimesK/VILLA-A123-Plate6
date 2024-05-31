package villaGraph;
import java.util.*;

public class item4{
    private Map<Integer, Integer> degreeMap = new HashMap<>();

    public void addEdge(int u, int v) {
        degreeMap.put(u, degreeMap.getOrDefault(u, 0) + 1);
        degreeMap.put(v, degreeMap.getOrDefault(v, 0) + 1);
    }

    public void printVertexDegrees() {
        for (Map.Entry<Integer, Integer> entry : degreeMap.entrySet()) {
            System.out.println("Vertex: " + entry.getKey() + ", Degree: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
    	/*Write a java program, given the pair of vertex associated to the edges of an undirected graph, it will output the degree of
		vertex.*/
        List<int[][]> useCases = new ArrayList<>();
        useCases.add(new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}}); // Linear graph
        useCases.add(new int[][] {{0, 1}, {1, 2}, {2, 0}}); // Cycle graph
        useCases.add(new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 1}}); // Graph with cycle
        useCases.add(new int[][] {{0, 1}, {1, 2}, {2, 3}}); // Another linear graph
        useCases.add(new int[][] {}); // No edges, no degrees

        for (int i = 0; i < useCases.size(); i++) {
            item4 graph = new item4();
            String hold = " ";
            for (int[] edge : useCases.get(i)) {
                if (edge.length == 2) {
                    graph.addEdge(edge[0], edge[1]);
                    hold += edge[0]+"-"+edge[1]+" ";
                }
            }
            System.out.println("Use Case " + (i + 1) + ":"+hold);
            graph.printVertexDegrees();
            System.out.println();
        }
    }
}
