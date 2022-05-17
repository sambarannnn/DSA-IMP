class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        //for reaching 0 amount
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        //by using 0 coins, impossible to reach
        for(int j = 1; j < dp[0].length; j++) {
            dp[0][j] = Integer.MAX_VALUE-1;
        }
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(coins[i-1] <= j) {//if this coin is lesser than current amount
                    //either dont use this coin and cover this amount using other coins
                    //or use this coin (add 1 coin) and cover the remaining amount using all current coins i.e., including this one
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if(dp[coins.length][amount] == Integer.MAX_VALUE-1){ //INVALID INPUT
            return -1;
        }
        return dp[coins.length][amount];
    }
}
