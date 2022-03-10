class Solution {
    public int jump(int[] nums) {
        return jump(nums, 0, new Integer[nums.length+1]);
    }
    public int jump(int[] nums, int index, Integer[] memo) {
        if(index >= nums.length-1) {
            return 0;
        }
        if(memo[index] != null) {//memo holds min number of jumps to last index starting from this index
            return memo[index];
        }
        int min = 10001; // 1 <= nums.length <= 10^4 thus, max number of jumps
        for(int i = 1; i <= nums[index]; i++) {
            min = Math.min(min, 1 + jump(nums, index + i, memo));
        }
        return memo[index] = min;
    }
}
