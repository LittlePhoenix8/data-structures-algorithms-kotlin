package hackerrank.interviewpreparationkit.graphs;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
 * */
public class ShortestReachInGraph1 {
    public static class Graph {
        private final List<List<Integer>> adjacent;
        private final int size;

        public Graph(int size) {
            this.size = size;
            adjacent = new ArrayList<>();
            for(int i = 0; i < size + 1; i++) {
                adjacent.add(new ArrayList<>());
            }
        }

        public void addEdge(int first, int second) {
            adjacent.get(first).add(second);
            adjacent.get(second).add(first);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            int[] distances = new int[size];
            Arrays.fill(distances, -1);
            if (distances.length <= 1) {
                return distances;
            }
            //dfs from start add edge sum
            Queue<Integer> queue = new LinkedList<>();
            queue.add(startId);
            distances[startId] = 0;
            while (!queue.isEmpty()) {
                Integer current = queue.poll();
                for (int adj : adjacent.get(current)) {
                    if (distances[adj] == -1) {
                        queue.add(adj);
                        distances[adj] = distances[current] + 6;
                    }
                }
            }
            return distances;
        }
    }

    public static void main(String[] args) {
        ShortestReachInGraph1.Graph graph = new ShortestReachInGraph1.Graph(6);
        int[][] edges = new int[][] { new int[]{ 1, 2 }, new int[]{ 2, 3 }, new int[]{ 3, 4 }, new int[]{ 1, 5 } };
        for (int[] pair : edges) {
            graph.addEdge(pair[0], pair[1]);
        }
        int[] distances = graph.shortestReach(1);
        for (int i : distances) {
            System.out.print(i + ", "); //[6, 12, 18, 6, -1]
        }
        System.out.println("");

        ShortestReachInGraph1.Graph graph2 = new ShortestReachInGraph1.Graph(6);
        int[][] edges2 = new int[][] { new int[]{ 1, 2 }, new int[]{ 2, 3 }, new int[]{ 3, 4 }, new int[]{ 1, 5 } };
        for (int[] pair : edges2) {
            graph2.addEdge(pair[0], pair[1]);
        }
        int[] distance2 = graph2.shortestReach(1);
        for (int i : distance2) {
            System.out.print(i + ", "); //[6, 12, 18, 6, -1]
        }
    }
}
