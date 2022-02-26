class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i = 0; i <= str1.length(); i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j <= str2.length(); j++) {
            dp[0][j] = 0;
        }
        for(int i = 1; i <= str1.length(); i++) {
            for(int j = 1; j <= str2.length(); j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int LCSlen = dp[str1.length()][str2.length()];
        int SCSlen = str1.length() + str2.length() - LCSlen;
        return SCSlen;
    }
}
