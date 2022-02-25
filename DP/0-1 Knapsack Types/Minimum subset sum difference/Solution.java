class Solution
{

	public int minDifference(int arr[], int n) { 
	    // Your code goes here
	    //max sum for the arr = S
	    //S1+S2 = S
	    //S2 = S-S1
	    //MINIMIZE S2-S1
	    //MINIMIZE S-2S1
	    //ALWAYS TAKE S2 > S1
	    //THE PARTITIONS INTERCHANGE AFTER HALF POINT OF VALID SUM VALUES
	    //WE NOW KNOW THAT S1 HAS VALID RANGE OF 0 TO S
	    //WE NEED TO FIND THE CORRECT CANDIDATES FROM THIS RANGE
	    
	    
        int sum = 0;
        for(int num : arr) {
            sum += num;
        }
        //S1 has a range of {0,sum}
        //use the subset sum method to find the last row of the dp table
        //here, we will have calculated S1{0, sum} boolean for all the elements in the array
        boolean[] sum_candidates = subsetSum(arr, n, sum);
        //WE WILL SELECT CANDIDATES ONLY UPTO S/2 SINCE AFTER THAT WE WILL ATTRIBUTE THE RANGE TO S2
        //ONCE WE HAVE THE VALID CANDIDATES, WE CAN PERFORM S-2S1 ON ALL OF THEM AND PICK THE MIN
        //OR starting from sum / 2 and moving leftwards, the first s1 value should be our answer
        //as this would give us the shortest gap between s1 and s2
        int s1 = sum / 2;
        while(sum_candidates[s1] != true) {
            s1--;
        }
        return sum - 2*s1;
	} 
	private boolean[] subsetSum(int[] arr, int n, int sum) {
	    boolean[][] dp = new boolean[n+1][sum+1];
	    for(int i = 0; i < dp.length; i++) {
	        for(int j = 0; j < dp[0].length; j++) {
	            if(i == 0)
	                dp[i][j] = false;
	            if(j == 0) 
	                dp[i][j] = true;
	        }
	    }
	    for(int i = 1; i < dp.length; i++) {
	        for(int j = 1; j < dp[0].length; j++) {
	            if(arr[i-1] <= j) {
	                dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
	            } else {
	                dp[i][j] = dp[i-1][j];
	            }
	        }
	    }
	    return dp[dp.length-1];
	}
}
