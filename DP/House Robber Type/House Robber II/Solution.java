class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int[] withFirst = new int[nums.length-1];
        int[] withLast = new int[nums.length-1];
        for(int i = 0; i < nums.length; i++) {
            if(i != 0) {
                withLast[i-1] = nums[i];
            }
            if(i != nums.length-1) {
                withFirst[i] = nums[i];
            }
        }
        return Math.max(linearRob(withFirst), linearRob(withLast));
    }
    public int linearRob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        //make a dynamic array to store maximum amount that can be robbed till that partucalar house
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i-1] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length];
        //now after visiting last house, we have the max value we ccan rob in the last element of dp array
        // return rob (nums, nums.length, new Integer[nums.length+1]);
    }
}
