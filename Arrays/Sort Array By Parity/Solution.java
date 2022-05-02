class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int evenLast = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                int temp = nums[evenLast];
                nums[evenLast] = nums[i];
                nums[i] = temp;
                evenLast++;
            }
        }
        return nums;
    }
}
