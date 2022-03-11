class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        dp[0] = nums[0];//current max subarray till now including this index
        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
            maxSum = Math.max(maxSum, dp[i]);//max of all foud current maxes
        }
        return maxSum;
        
        //KADANE'S ALGO IMP
        // int sum = 0;
        // int maxSum = Integer.MIN_VALUE;
        // for(int num : nums) {
        //     sum += num;
        //     maxSum = Math.max(maxSum, sum);
        //     if(sum < 0) {
        //         sum = 0;
        //     }
        // }
        // return maxSum;
    }
    
}
