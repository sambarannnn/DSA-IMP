class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        //memo function has n values as j varies from 1 to N-1
        //i varies from 1 to N-1
        return mcm(arr, 1, N-1, new Integer[N][N]);
    }
    public static int mcm(int[] arr, int i, int j, Integer[][] memo) {
        if(memo[i][j] != null) {
            return memo[i][j];
        }
        if(i == j) {
            return memo[i][j] = 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++) {
            int temp = mcm(arr, i, k, memo) + mcm(arr, k+1, j, memo) + arr[i-1]*arr[k]*arr[j];
            min = Math.min(temp, min);
        }
        return memo[i][j] = min;
    }
}
