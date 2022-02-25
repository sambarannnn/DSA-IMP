class Solution{

    static Boolean isSubsetSum(int N, int arr[], int X){
        // code here
        //find total sum
        int tot = 0;
        for(int num : arr) {
          tot += num;
        }
        //S1 + S2 = tot
        //S1 - S2 = X
        //thus, S1 = (tot+X) / 2
        //thus, find number of subsets whose sum is equal to s1 : (tot+X) / 2
        //follow normal count of 
      
        int sum = (tot+X) / 2;
        int[][] dp = new int[N+1][sum+1];
        
        for(int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        for(int j = 1; j <= sum; j++) {
            dp[0][j] = 0;
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= sum; j++) {
                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][sum];
    }
}
