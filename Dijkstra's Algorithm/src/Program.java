import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Program {

    public static void main(String[] args) {

        // Expected: [0, 7, 13, 27, 10, -1]
        System.out.println(Arrays.toString(
                dijkstrasAlgorithm(0,
                                new int[][][]{
                                        {{1, 7}},
                                        {{2, 6}, {3, 20}, {4, 3}},
                                        {{3, 14}},
                                        {{4, 2}},
                                        {},
                                        {}
                                })));

        // Expected: [-1, 0, -1, -1]
        System.out.println(Arrays.toString(
                dijkstrasAlgorithm(1,
                        new int[][][]{
                                {},
                                {},
                                {},
                                {}
                        })));
    }

    private static int[] dijkstrasAlgorithm(int start, int[][][] edges) {

        // O(v^2 + e) time | O(v) space
        // where v is the number of vertices and e is the number of edges in the input graph.

        int numberOfVertices = edges.length;
        int[] minDistances = new int[edges.length];

        Arrays.fill(minDistances, Integer.MAX_VALUE);
        minDistances[start] = 0;

        Set<Integer> visited = new HashSet<>();

        while (visited.size() != numberOfVertices) {
            // This while loop will run for O(v) times.
            int[] getVertexData = getVertexWithMinimumDistances(minDistances, visited);
            int vertex = getVertexData[0];
            int currentMinimumDistance = getVertexData[1];

            if (currentMinimumDistance == Integer.MAX_VALUE) break;

            visited.add(vertex);

            for (int[] edge : edges[vertex]) {
                // This for loop will run only for O(e) times.

                int destination = edge[0];
                int distanceToDestination = edge[1];

                if (visited.contains(destination)) continue;

                int newPathDistance = currentMinimumDistance + distanceToDestination;
                int currentDestinationDistance = minDistances[destination];

                if (newPathDistance < currentDestinationDistance) {
                    minDistances[destination] = newPathDistance;
                }
            }
        }

        int[] finalDistances = new int[minDistances.length];
        for (int i = 0; i < minDistances.length; i++) {
            int distance = minDistances[i];
            if (distance == Integer.MAX_VALUE) finalDistances[i] = -1;
            else finalDistances[i] = distance;
        }

        return finalDistances;
    }

    private static int[] getVertexWithMinimumDistances(int[] distances, Set<Integer> visited) {
        // This method will run for O(v) times.

        int currentMinimumDistance = Integer.MAX_VALUE;
        int vertex = -1;

        for (int vertexIdx = 0; vertexIdx < distances.length; vertexIdx++) {
            if (visited.contains(vertexIdx)) continue;

            int distance = distances[vertexIdx];

            if (distance <= currentMinimumDistance) {
                vertex = vertexIdx;
                currentMinimumDistance = distance;
            }
        }

        return new int[]{vertex, currentMinimumDistance};
    }
}
