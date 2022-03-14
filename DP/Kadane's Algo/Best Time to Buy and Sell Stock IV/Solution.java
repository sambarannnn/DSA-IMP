class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[k+1][prices.length];
        for(int i = 0; i <= k; i++) {//if we are doing all transactions in one day, 
            dp[i][0] = 0;
        }
        for(int j = 0; j < prices.length; j++) {//if we are doing 0 transactions
            dp[0][j] = 0;
        }
        
        for(int i = 1; i <= k; i++) {
            int localMax = dp[i-1][0] - prices[0];
            for(int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j-1], localMax + prices[j]);
                //we can keep a local max variable to cut this inner loop
                // for(int p = 0; p < j; p++) {
                //     dp[i][j] = Math.max(dp[i][j], dp[i-1][p] + prices[j] - prices[p]);
                // }
                localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
            }
        }
        return dp[k][prices.length-1];
    }
}
