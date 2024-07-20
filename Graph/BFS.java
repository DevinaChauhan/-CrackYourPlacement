

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] visited = new boolean[v];
        //as per question to start bfs from 0, and only consider its descedents 
        return bfs(0, adj, visited);
    }
    
    private ArrayList<Integer> bfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(node);
        visited[node] = true;
        
        while(!queue.isEmpty()){
            Integer curr = queue.poll();
            
            ans.add(curr);
            for(int neigh : adj.get(curr)) {
                if(!visited[neigh]) {
                    queue.add(neigh);
                    visited[neigh] = true;
                }
            }
        }
        
        return ans;
        
    }
}
