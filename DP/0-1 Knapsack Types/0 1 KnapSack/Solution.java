class Solution 
{ 
    // static int[][] memo = new int[1001][1001];
    // Solution() {
    //     for(int[] row : memo) {
    //         Arrays.fill(row, -1);
    //     }
    // }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int[][] dp = new int[n+1][W+1];
        for(int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j < W+1; j++) {
            dp[0][j] = 0;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= W; j++) {
                if(wt[i-1] <= j) {
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j - wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
        // if(memo[n][W] != -1) {
        //     return memo[n][W];
        // }
        //  if(W == 0 || n == 0) {
        //      return memo[n][W] = 0;
        //  }
        //  if(wt[n-1] <= W) {
        //      return memo[n][W] = Math.max(val[n-1] + knapSack(W-wt[n-1], wt, val, n-1)
        //                     , knapSack(W, wt, val, n-1)
        //                     );
        //  } else {
        //      return memo[n][W] = knapSack(W, wt, val, n-1);
        //  }
    } 
}
