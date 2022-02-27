class Solution {
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length()+1][pattern.length()+1];
        dp[0][0] = true;
        for(int i = 1; i <= text.length(); i++) {
            dp[i][0] = false;
        }
        for(int j = 1; j <= pattern.length(); j++) {
            if(pattern.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            } else {
                dp[0][j] = false;
            }
        }
        
        for(int i = 1; i <= text.length(); i++) {
            for(int j = 1; j <= pattern.length(); j++) {
                if(text.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(pattern.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[text.length()][pattern.length()];
        // return check(text, pattern, text.length(), pattern.length(), new Boolean[text.length()+1][pattern.length()+1]);
    }
    public static Boolean check(String text, String pattern, int textIndex, int patternIndex, Boolean[][] memo) {

        if(memo[textIndex][patternIndex] != null) {
            return memo[textIndex][patternIndex];
        }
        if(textIndex == 0 && patternIndex == 0) {
            return memo[textIndex][patternIndex] = true;
        }
        if(textIndex == 0) {
            if(pattern.charAt(patternIndex-1) == '*') {
                return memo[textIndex][patternIndex] = check(text, pattern, textIndex, patternIndex-1, memo);
            } else {
                return memo[textIndex][patternIndex] = false;
            }
        }
        if(textIndex != 0 && patternIndex == 0) {
            return memo[textIndex][patternIndex] = false;
        }
        if(text.charAt(textIndex-1) == pattern.charAt(patternIndex-1) || pattern.charAt(patternIndex-1) == '?') {
            return memo[textIndex][patternIndex] = check(text, pattern, textIndex-1, patternIndex-1, memo);
        } else if(pattern.charAt(patternIndex-1) == '*') {
            return memo[textIndex][patternIndex] = check(text, pattern, textIndex, patternIndex-1, memo) || check(text, pattern, textIndex-1, patternIndex, memo);
        } else {
            return memo[textIndex][patternIndex] = false;
        }
    }
}
