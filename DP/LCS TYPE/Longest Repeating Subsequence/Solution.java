class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        //LCS using the same string twice, but the indexes cannot be the same
        
        int[][] dp = new int[str.length()+1][str.length()+1];
        for(int i = 0; i <= str.length(); i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j <= str.length(); j++) {
            dp[0][j] = 0;
        }
        
        for(int i = 1; i <= str.length(); i++) {
            for(int j = 1; j <= str.length(); j++) {
                if(i != j && str.charAt(i-1) == str.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[str.length()][str.length()];
    }
}
