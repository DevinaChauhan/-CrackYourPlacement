import java.util.*;

class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;

        // DFS to find the first island and mark all its cells as visited
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visited, queue);
                    found = true;
                }
            }
        }

        // BFS to expand the first island and find the shortest bridge to the second island
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minFlips = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] dir : directions) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
                        if (grid[x][y] == 1) {
                            return minFlips; // Found the shortest bridge
                        } else {
                            visited[x][y] = true;
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
            }
            minFlips++;
        }

        return minFlips;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited, Queue<int[]> queue) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        
        dfs(grid, i + 1, j, visited, queue);
        dfs(grid, i - 1, j, visited, queue);
        dfs(grid, i, j + 1, visited, queue);
        dfs(grid, i, j - 1, visited, queue);
    }

}
