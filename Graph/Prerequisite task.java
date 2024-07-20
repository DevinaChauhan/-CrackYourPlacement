
class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
       ArrayList<Integer>[]G=new ArrayList[N];
       int[] degree=new int[N];
       ArrayList<Integer> bfs=new ArrayList<>();
       for(int i=0;i<N;i++)
       {
           G[i]=new ArrayList<>();
           
       }
       
       for(int [] e:prerequisites)
       {
           G[e[1]].add(e[0]);
           degree[e[0]]++;
           
       }
       
       for(int i=0;i<N;i++)
       {
          if(degree[i]==0)
          bfs.add(i);
       }
       
     for(int i=0;i<bfs.size();i++)
     {
         for(int j:G[bfs.get(i)])
         {
             if(--degree[j]==0)
             bfs.add(j);
         }
     }
     
     return bfs.size()==N?true:false;
         }
     }
