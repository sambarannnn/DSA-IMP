class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if(n < 2) {
            return 1;
        }
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
        // return findWays(n, new Integer[n+1]);
    }
    public static int findWays(int floor, Integer[] memo) {
        
        if(floor <= 0) {
            return 0;
        }
        if(memo[floor] != null) {
            return memo[floor];
        }
        if(floor == 1) {
            return memo[floor] = 1;
        }
        if(floor == 2) {
            return memo[floor] = 2;
        }
        return memo[floor] = findWays(floor-1, memo) + findWays(floor-2, memo);
    }
}
