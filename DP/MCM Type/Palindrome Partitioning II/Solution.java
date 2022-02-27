class Solution {
    public int minCut(String s) {
        //MCM TYPE DP
        //similar to palindrome 1, backtracking soln concept
        return minCut(s, 0, s.length()-1, new Integer[s.length()][s.length()]);//can memoize isPalindrome calls too
    }
    public static int minCut(String s, int i, int j, Integer[][] memo) {
        if(memo[i][j] != null) {
            return memo[i][j];
        }
        if(i == j) {
            return memo[i][j] = 0;
        }
        if(isPalindrome(s, i, j)) {
            return memo[i][j] = 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++) {
            if(isPalindrome(s, i, k)) {// if left is palindrome, the proceed rightwards
                int temp = 1 + minCut(s, k+1, j, memo);
                min = Math.min(min, temp);
            }
        }
        return memo[i][j] = min;
    }
    public static boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
