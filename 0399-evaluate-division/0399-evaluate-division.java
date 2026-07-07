import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: Build the graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];
            
            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());
            
            graph.get(u).put(v, val);       // u -> v (val)
            graph.get(v).put(u, 1.0 / val); // v -> u (1 / val)
        }
        
        // Step 2: Process each query using DFS
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            
            // If either variable doesn't exist in our graph, it's invalid
            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                results[i] = -1.0;
            } else if (src.equals(dest)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, src, dest, visited);
            }
        }
        
        return results;
    }
    
    private double dfs(Map<String, Map<String, Double>> graph, String curr, String dest, Set<String> visited) {
        // If we reach the destination, path product starts at 1.0
        if (curr.equals(dest)) {
            return 1.0;
        }
        
        visited.add(curr);
        Map<String, Double> neighbors = graph.get(curr);
        
        for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
            String nextNode = neighbor.getKey();
            double edgeWeight = neighbor.getValue();
            
            if (!visited.contains(nextNode)) {
                double productRes = dfs(graph, nextNode, dest, visited);
                // If a valid path to dest was found through this neighbor
                if (productRes != -1.0) {
                    return edgeWeight * productRes;
                }
            }
        }
        
        return -1.0; // No valid path found
    }
}