class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            max = Math.max(num, max);
        }
        //make it same as house robber problem
        //and we will avoid adjacent indexes (houses), indexes, whoch are not present in array will have zero amount to rob
        int[] indexSums = new int[max+1];
        for(int num : nums)  {
            indexSums[num] += num;
        }
        int[] dp = new int[indexSums.length+1];
        dp[0] = 0;
        dp[1] = indexSums[0];
        for(int i = 1; i < indexSums.length; i++) {
            dp[i+1] = Math.max(indexSums[i] + dp[i-1], dp[i]);
        }
        return dp[indexSums.length];
        //MEMOIZED RECURSION BELOW
        // return earn(indexSums, indexSums.length, new Integer[indexSums.length+1]);
    }
    public int earn(int[] nums, int length, Integer[] memo) {
        if(length <= 0) {
            return 0;
        }
        if(memo[length] != null) {
            return memo[length];
        }
        return memo[length] = Math.max(nums[length-1] + earn(nums, length-2, memo), earn(nums, length-1, memo));
    }
}
