
class Solution {
    public String findOrder(String[] dict, int N, int K) {
        // Step 1: Create a graph and a degree array
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[K];
        
        // Initialize graph
        for (int i = 0; i < K; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        // Step 2: Build the graph
        for (int i = 0; i < N - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            int minLength = Math.min(word1.length(), word2.length());
            
            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    int u = word1.charAt(j) - 'a';
                    int v = word2.charAt(j) - 'a';
                    graph.get(u).add(v);
                    inDegree[v]++;
                    break;
                }
            }
        }
        
        // Step 3: Perform topological sort using Kahn's algorithm (BFS)
        StringBuilder result = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        
        // Add all nodes with in-degree 0 to the queue
        for (int i = 0; i < K; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.append((char) (current + 'a'));
            
            // Reduce the in-degree of neighbors
            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                // If in-degree becomes 0, add to queue
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If result length is not equal to K, there is a cycle (invalid input)
        if (result.length() != K) {
            return "";
        }
        
        return result.toString();
    }
}
    
    
