class Solution {
    public int nthUglyNumber(int n) {
      
    public int withHeap(int n){
        PriorityQueue<Long> pq = new PriorityQueue<>();
     
        int count = 1;
        pq.offer(1l);
        while(count != n){
            long ele = pq.poll();
            
            if(!pq.contains(ele * 2)){
                pq.offer(ele * 2);
            }
            if(!pq.contains(ele * 3)){
                pq.offer(ele * 3);
            }
            if(!pq.contains(ele * 5)){
                pq.offer(ele * 5);
            }
            count ++;
        }
        int ans = Integer.parseInt(String.valueOf(pq.poll()));
        return ans;
    }
}
