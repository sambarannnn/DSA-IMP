//(WRONG TITLE)
//title should be COIN CHANGE BUT FOR ALL PERMUTATIONS
class Solution {
    public int combinationSum4(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for(int j = 1; j <= amount; j++) {
            dp[0][j] = 0;
        }
        
        for(int j = 1; j <= amount; j++) {
            for(int i = 1; i <= coins.length; i++) {
                if(coins[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[coins.length][j - coins[i-1]];//count ways to reach j - coins[i-1] (remaining sum) sum using ALL COINS
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
