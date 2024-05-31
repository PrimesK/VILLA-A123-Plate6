package villaGraph;
import java.util.*;

public class item1 {
	private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int u, int v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    private void DFS(int v, Set<Integer> visited) {
        visited.add(v);
        for (int neighbor : adjList.getOrDefault(v, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                DFS(neighbor, visited);
            }
        }
    }

    public boolean isConnected() {
        if (adjList.isEmpty()) return false;

        Set<Integer> visited = new HashSet<>();
        int startNode = adjList.keySet().iterator().next();
        DFS(startNode, visited);

        return visited.size() == adjList.size();
    }

    public int connectedComponents() {
        if (adjList.isEmpty()) return 0;

        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for (int node : adjList.keySet()) {
            if (!visited.contains(node)) {
                DFS(node, visited);
                count++;
            }
        }

        return count;
    }

	public static void main(String[] args) {
		/*Write a java program that receives a list of edges of a simple graph, the program should determine whether it is connected
		and find the number of connected components if it is not connected.*/
		List<int[][]> useCases = new ArrayList<>();
        useCases.add(new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}}); // Connected
        useCases.add(new int[][] {{0, 1}, {2, 3}, {4, 5}}); // Not connected
        useCases.add(new int[][] {{0, 1}, {1, 2}, {3, 4}}); // Not connected
        useCases.add(new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 0}}); // Connected
        useCases.add(new int[][] {{}}); // No edges, not connected

        for (int i = 0; i < useCases.size(); i++) {
            item1 graph = new item1();
            String hold=" ";
            for (int[] edge : useCases.get(i)) {
                if (edge.length == 2) {
                    graph.addEdge(edge[0], edge[1]);
                    hold += edge[0]+"-"+edge[1]+" ";
                }
            }
            System.out.println("Use Case " + (i + 1) + ":"+hold);
            System.out.println("Is connected? " + graph.isConnected());
            if (!graph.isConnected()) {
                System.out.println("Number of connected components: " + graph.connectedComponents());
            }
            System.out.println();
        }
    }
	

}
