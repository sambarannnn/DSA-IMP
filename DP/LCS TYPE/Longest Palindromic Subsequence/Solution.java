class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        //LCS BETWEEN s and s.reverse
        int[][] dp = new int[s.length()+1][rev.length()+1];
        for(int i = 0; i <= s.length(); i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j <= rev.length(); j++) {
            dp[0][j] = 0;
        }
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= rev.length(); j++) {
                if(s.charAt(i-1) == rev.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int LPSlen = dp[s.length()][rev.length()];
        return LPSlen;
    }
}
