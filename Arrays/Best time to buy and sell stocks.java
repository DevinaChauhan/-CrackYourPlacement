class Solution {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int op = 0;// overall profit
        int pist = 0;// profit if sold today
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lsf){// if we found new buy value  which is more smaller then previous one
                lsf = prices[i];
            }
            pist = prices[i] - lsf;
            if(op < pist){
                op = pist;
            }
        }
        return op;
    }
}
