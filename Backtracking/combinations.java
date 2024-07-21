class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> combination=new ArrayList<>();
 
        backtrack(1,result,combination,n,k);

        return result;

    }
    public void backtrack(int start,List<List<Integer>> result,List<Integer> combination,int n,int k )
    {
        if(combination.size()==k)
        {
        result.add(new ArrayList<>(combination));
        return;
        }

        for(int i=start;i<=n;i++)
        {   combination.add(i);
            backtrack(i+1,result,combination,n,k);
            combination.remove(combination.size()-1);
        }
    }
}
