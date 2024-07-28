import java.util.*;

class Solution
{

    private static final int[] ROWS = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] COLS = {1, 2, 2, 1, -1, -2, -2, -1};

  
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{KnightPos[0], KnightPos[1], 0}); // {row, col, distance}
        
     
        Set<String> visited = new HashSet<>();
        visited.add(KnightPos[0] + "," + KnightPos[1]);
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int dist = current[2];
            
            
            if (row == TargetPos[0] && col == TargetPos[1]) {
                return dist;
            }
            
            
            for (int i = 0; i < 8; i++) {
                int newRow = row + ROWS[i];
                int newCol = col + COLS[i];
                
                if (isValidMove(newRow, newCol, N) && !visited.contains(newRow + "," + newCol)) {
                    queue.offer(new int[]{newRow, newCol, dist + 1});
                    visited.add(newRow + "," + newCol);
                }
            }
        }
        
        return -1;
    }
    
    
    private boolean isValidMove(int row, int col, int N) {
        return row >= 1 && row <= N && col >= 1 && col <= N;
    }
}
