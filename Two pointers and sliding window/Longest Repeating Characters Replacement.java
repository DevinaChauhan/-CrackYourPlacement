class Solution
{
    public int characterReplacement(String s,int k)
    {
        int largestCount=0,beg=0,maxLen=0;
        int[] arr = new int[26];
        for(int end=0;end<s.length();end++)
        {
            arr[s.charAt(end)-'A']++;


            largestCount=Math.max(largestCount,arr[s.charAt(end) - 'A']);

            if(end-beg+1-largestCount>k)
            {
                arr[s.charAt(beg)-'A']--;
                beg++;
            }

            maxLen=Math.max(maxLen,end-beg+1);
        }
        return maxLen;
        }
    }
