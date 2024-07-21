class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<Integer> combination=new ArrayList<>();
        int start=0;
        Helper(candidates,target,result,combination,start);
        return result;
    }

    public void Helper(int[] candidates, int target,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> combination,int start)
    {
       
       if(target<0)
       return;

      else  if(target==0)
       result.add(new ArrayList<>(comb));

       else
       {
           for(int i=start;i<candidates.length;i++)
           {
            combination.add(candidates[i]);
            Helper(candidates,target-candidates[i],result,combination,i+1);
            combination.remove(combination.size()-1);
           }
       }
    }
}

   
