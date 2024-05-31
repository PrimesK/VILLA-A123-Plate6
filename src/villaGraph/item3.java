package villaGraph;
import java.util.*;

public class item3 {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int u, int v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    private boolean hasCycleUtil(int v, Set<Integer> visited, int parent) {
        visited.add(v);

        for (int neighbor : adjList.getOrDefault(v, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (hasCycleUtil(neighbor, visited, v)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();

        for (int node : adjList.keySet()) {
            if (!visited.contains(node)) {
                if (hasCycleUtil(node, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
    	/*Write a java program that will determine if a graph has a cycle or not.*/
        List<int[][]> useCases = new ArrayList<>();
        useCases.add(new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}}); // No cycle
        useCases.add(new int[][] {{0, 1}, {1, 2}, {2, 0}}); // Cycle exists
        useCases.add(new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 1}}); // Cycle exists
        useCases.add(new int[][] {{0, 1}, {1, 2}, {2, 3}}); // No cycle
        useCases.add(new int[][] {}); // No edges, no cycle

        for (int i = 0; i < useCases.size(); i++) {
            item3 graph = new item3();
            String hold = " ";
            for (int[] edge : useCases.get(i)) {
                if (edge.length == 2) {
                    graph.addEdge(edge[0], edge[1]);
                    hold += edge[0]+"-"+edge[1]+" ";
                }
            }
            System.out.println("Use Case " + (i + 1) + ":"+hold);
            System.out.println("Has cycle? " + graph.hasCycle());
            System.out.println();
        }
    }
}
