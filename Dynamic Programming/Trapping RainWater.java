class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int []left=new int[n];
        int []right=new int[n];
        int water=0;
        left[0]=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            left[i]=Math.max(arr[i],left[i-1]);
        }

        right[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
        {
            right[i]=Math.max(arr[i],right[i+1]);
        }
        for(int i=0;i<n;i++)
        {
            water+=Math.min(left[i],right[i])-arr[i];

        }
        return water;



    }
}
