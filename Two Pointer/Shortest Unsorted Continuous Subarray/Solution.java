class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = -1;
        int r = -1;
        
        //find last index where num is smaller than currMax, this will be right edge of the subarray
        //if array is in sorted order, no num will be smaller than currmax, thus r will not change from -1
        int currMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < currMax) {
                r = i;
            }
            currMax = Math.max(currMax, nums[i]);
        }
        
        //find first index on left side where num is larger than currmin(from right side), this will be left edge of subarray
        //if array is sorted, no num will be smaller than currmin, this l will not change from -1;
        int currMin = Integer.MAX_VALUE;
        for(int i = nums.length-1; i >= 0; i--) {
            if(nums[i] > currMin) {
                l = i;
            }
            currMin = Math.min(currMin, nums[i]);
        }
        if(l != -1 && r != -1) {
            return r - l + 1;
        }
        return 0;
    }
}
