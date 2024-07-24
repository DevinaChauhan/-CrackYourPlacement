class Solution {
    public int countPalindromicSubsequences(String s) {
        int len = s.length();
        long[][] dp = new long[len][len];
        
        // Initialize the dp array with -1 to indicate uncomputed values
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = -1;
            }
        }
        
        return (int) helper(s, dp, 0, len - 1);
    }

    public long helper(String s, long[][] dp, int i, int j) {
        int mod = 1000000007;
        
        if (i == j) {
            return 1;
        }

        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
qa1  if (s.charAt(i) == s.charAt(j)) {
            int low = i + 1, high = j - 1;
            while (low <= high && s.charAt(low) != s.charAt(i)) low++;
            while (low <= high && s.charAt(high) != s.charAt(j)) high--;
            
            if (low > high) {
                dp[i][j] = (2 * helper(s, dp, i + 1, j - 1) + 2) % mod;
            } else if (low == high) {
                dp[i][j] = (2 * helper(s, dp, i + 1, j - 1) + 1) % mod;
            } else {
                dp[i][j] = (2 * helper(s, dp, i + 1, j - 1) - helper(s, dp, low + 1, high - 1) + mod) % mod;
            }
        } else {
            dp[i][j] = (helper(s, dp, i + 1, j) + helper(s, dp, i, j - 1) - helper(s, dp, i + 1, j - 1) + mod) % mod;
        }

        return dp[i][j];
    }
}
