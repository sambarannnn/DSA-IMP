class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j <= text2.length(); j++) {
            dp[0][j] = 0;
        }
        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[text1.length()][text2.length()];
        // return lcs(text1, text2, text1.length(), text2.length(), new Integer[text1.length()+1][text2.length()+1];);
    }
    public int lcs(String text1, String text2, int l1, int l2, Integer[][] memo) {
        if(memo[l1][l2] != null) {
            return memo[l1][l2];
        }
        if(l1 == 0 || l2 == 0) {
            return memo[l1][l2] = 0;
        }
        if(text1.charAt(l1-1) == text2.charAt(l2-1)) {
            return memo[l1][l2] = 1 + lcs(text1, text2, l1-1, l2-1, memo);
        } else {
            return memo[l1][l2] = Math.max(lcs(text1, text2, l1-1, l2, memo), lcs(text1, text2, l1, l2-1, memo));
        }
    }
}
