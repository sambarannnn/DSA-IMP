class Solution {
    public boolean canJump(int[] nums) {
        //ALTERNATE GREEDY ALGO
        int maxPossible = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > maxPossible) {
                return false;
            }
            maxPossible = Math.max(maxPossible, i + nums[i]);
            if(maxPossible >= nums.length-1) {
                return true;
            } 
        }
        return false;
        //MEMO DP SOLN
        // return canJump(nums, 0, new Boolean[nums.length+1]);
    }
    public boolean canJump(int[] nums, int index, Boolean[] memo) {
        if(index >= nums.length-1) {
            return true;
        }
        if(memo[index] != null) {
            return memo[index];
        }
        for(int i = nums[index] ; i > 0; i--) {
            if(canJump(nums, index+i, memo)) {
                return memo[index] = true;
            }
        }
        return memo[index] = false;
    }
}
