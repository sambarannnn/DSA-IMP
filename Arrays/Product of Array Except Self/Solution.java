class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int currProd = nums[0];//from left
        
        for(int i = 1; i < nums.length; i++) {
            res[i] = currProd;
            currProd = currProd * nums[i];
        }
        currProd = nums[nums.length-1];//from right
        
        for(int i = nums.length-2; i >= 0; i--) {
            res[i] = res[i] * currProd;
            currProd = currProd * nums[i];
        }
        return res;
    }
}
