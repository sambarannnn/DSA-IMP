class Solution {
    public int jump(int[] nums) {
        //GREEDY O(N)
        int jumps = 0;
        int currMax = 0;
        int currEnd = 0;
        for(int i = 0; i < nums.length-1; i++) {//DONT INCLUDE LAST INDEX AS THAT IS DESTINATION
            if(i > currMax) {
                return -1;//unreachable index
            }
            currMax = Math.max(currMax, i + nums[i]);
            if(i == currEnd) {
                jumps++;
                currEnd = currMax;
                
            } 
        }
        return jumps;
        //dp below O(N^2)
        // return jump(nums, 0, new Integer[nums.length+1]);
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
