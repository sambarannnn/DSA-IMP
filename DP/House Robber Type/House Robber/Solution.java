class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        //make a dynamic array to store maximum amount that can be robbed till that partucalar house
        int[] dp = new int[nums.length+1];
        dp[0] = 0;//if u rob no house, u have 0 amount
        dp[1] = nums[0];//max till first house is just first house's amount
        //every point in dp array is the max amount we can rob till this house
        for(int i = 1; i < nums.length; i++) {//for each house, calculate max amount
                    //dp[i] = previous max
                    //or old max + new house(we skip previous max as we cannot rob consecutive houses)
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }
        //now after visiting last house, we have the max value we ccan rob in the last element of dp array
        return dp[nums.length];
        // return rob (nums, nums.length, new Integer[nums.length+1]);
    }
    public int rob(int[] nums, int length, Integer[] memo) {
        if(length <= 0) {
            return 0;
        }
        if(memo[length] != null) {
            return memo[length];
        }
        return memo[length] = Math.max(nums[length-1] + rob(nums, length-2, memo), rob(nums, length-1, memo));
    }
}
