class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetsWithDup=new ArrayList<>();
        Arrays.sort(nums);
       
         backtrack(nums,subsetsWithDup,new ArrayList(),0);
         return subsetsWithDup;

    }

    public void backtrack(int[]nums,List<List<Integer>> subsetsWithDup,List<Integer> tempList,int start)
    { 
        subsetsWithDup.add(new ArrayList<>(tempList));

        for(int i=start;i<nums.length;i++)
        {
         
          tempList.add(nums[i]);
            backtrack(nums,subsetsWithDup,tempList,i+1);
            tempList.remove(tempList.size()-1);
            
        }
    }
}
