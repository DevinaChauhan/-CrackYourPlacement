class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();

        for(String s: strs){
            
           char[] arr=s.toCharArray();
           Arrays.sort(arr);

           String sortedstring=String.valueOf(arr);

           if(!map.containsKey(sortedstring))
           {
            map.put(sortedstring,new ArrayList<>());
           }
             map.get(sortedstring).add(s);
        }
         return new ArrayList<>(map.values());
    }
}
