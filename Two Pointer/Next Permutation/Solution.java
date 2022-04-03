class Solution {
    public void nextPermutation(int[] nums) {
        int trough_index = nums.length - 2;
        while(trough_index >= 0 && nums[trough_index+1] <= nums[trough_index])
            trough_index--;
        //now index is at first trough from the right
        //check if index is -1 which would mean
        if(trough_index != -1) {
            //we need to find the first element greater than this trough from the right
            int nge_index = nums.length - 1;
            while(nums[nge_index] <= nums[trough_index])
                nge_index--;
            //now, nge_index is pointing to the first greater element from te right
            //lets swap these two
            int temp = nums[trough_index];
            nums[trough_index] = nums[nge_index];
            nums[nge_index] = temp;
        }
        //now, does,nt matter if we have performed the above if statement or not, we have a decreasing sequence on our hands that we need to reverse the decreasing subsequence starting from trough_index+1
        //using two pointer approach
        int left = trough_index+1;
        int right = nums.length-1;
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
