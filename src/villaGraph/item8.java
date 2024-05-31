package villaGraph;
import java.util.*;

public class item8 {
    public static boolean areIsomorphic(int[][] graph1, int[][] graph2) {
        if (graph1.length != graph2.length || graph1[0].length != graph2[0].length) {
            return false; // Different number of vertices or edges
        }

        Map<String, String> mapping = new HashMap<>();
        Set<String> mappedVertices = new HashSet<>();

        for (int i = 0; i < graph1.length; i++) {
            String signature1 = Arrays.toString(graph1[i]);
            String signature2 = Arrays.toString(graph2[i]);

            if (!mapping.containsKey(signature1)) {
                if (mappedVertices.contains(signature2)) {
                    return false; // A vertex is already mapped to a different vertex in the other graph
                }
                mapping.put(signature1, signature2);
                mappedVertices.add(signature2);
            } else {
                if (!mapping.get(signature1).equals(signature2)) {
                    return false; // The mapping is inconsistent
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        /*Write a Java program that checks whether two graphs are isomorphic or not, given a set of vertices.*/
        int[][] graph1 = {
            {0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };

        int[][] graph2 = {
            {0, 1, 1, 0},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {0, 1, 1, 0}
        };

        System.out.println("Graph 1 and Graph 2 are isomorphic: " + areIsomorphic(graph1, graph2));

        int[][] graph3 = {
            {0, 1, 1, 0},
            {1, 0, 0, 1},
            {1, 0, 0, 0},
            {0, 1, 0, 0}
        };

        int[][] graph4 = {
            {0, 1, 1, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 1},
            {0, 0, 1, 0}
        };

        System.out.println("Graph 3 and Graph 4 are isomorphic: " + areIsomorphic(graph3, graph4));

        int[][] graph5 = {
            {0, 1, 0, 1},
            {1, 0, 0, 0},
            {0, 0, 0, 1},
            {1, 0, 1, 0}
        };

        int[][] graph6 = {
            {0, 0, 0, 1},
            {0, 0, 1, 0},
            {0, 1, 0, 0},
            {1, 0, 0, 0}
        };

        System.out.println("Graph 5 and Graph 6 are isomorphic: " + areIsomorphic(graph5, graph6));

        int[][] graph7 = {
            {0, 1, 0, 0, 1},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 0, 1},
            {0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0}
        };

        int[][] graph8 = {
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 0},
            {0, 0, 0, 0, 1},
            {0, 1, 0, 0, 1},
            {1, 0, 1, 1, 0}
        };

        System.out.println("Graph 7 and Graph 8 are isomorphic: " + areIsomorphic(graph7, graph8));
        
        int[][] graph9 = {
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
            };

            // Graph 10: 3-node path
            int[][] graph10 = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
            };

            System.out.println("Graph 9 and Graph 10 are isomorphic: " + areIsomorphic(graph9, graph10));
        
    }
}
