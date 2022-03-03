class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) {
            return 0;
        }
        //keep running currcounter
        //like keeping running prod or sum in similar qs
        int currCount = 0;
        int res = 0;
        for(int i = 1; i < nums.length-1; i++) {
            if(nums[i] - nums[i-1] == nums[i+1] - nums[i]) {
                currCount++;
            } else {
                currCount = 0;
            }
            res += currCount;
        }
        return res;
    }
}
