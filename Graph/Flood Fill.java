class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }

        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};

        Queue<int[]> q = new LinkedList<>();
        int st = image[sr][sc];
        
        q.offer(new int[]{sr , sc});

        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0;i<n;i++){
                int[] p = q.poll();
                image[p[0]][p[1]] = color;
                for(int j = 0;j<4;j++){
                    int x = p[0]+dx[j];
                    int y = p[1]+dy[j];

                    if(x<0 || x>=image.length || y<0 || y>=image[0].length || image[x][y] != st){
                        continue;
                    }
                    image[x][y] = color;
                    q.offer(new int[]{x , y});
                }
                
            }

        }
        return image;
    }
}
