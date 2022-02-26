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
        StringBuilder lcs_builder = new StringBuilder();
        int i = n,j = m;
        while(i > 0 && j > 0){    // if any of this i and j becomes 0 means one string is empty 
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                lcs.append(text1.charAt(i-1));    //if character matches then add that to result string and move diagonally up
                i--;j--;
            }
            else{ // else find the max of up and right position of dp table and move accordingly to up or left
                if(dp[i][j-1] > dp[i-1][j]) 
                    j--;    
                else i--;
            }
        }
        String LCS_res = lcs.reverse().toString();
        return LCS_res;
    }
}
