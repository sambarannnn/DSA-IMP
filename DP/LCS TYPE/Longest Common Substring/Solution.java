class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        int longest = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(S1.charAt(i-1) == S2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    longest = Math.max(dp[i][j], longest);//making the substring diagonally
                } else {
                    dp[i][j] = 0;//reset it to 0
                }
            }
        }
        return longest;
    }
}
