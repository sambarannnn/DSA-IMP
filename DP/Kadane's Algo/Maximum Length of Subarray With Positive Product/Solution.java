class Solution {
    public int getMaxLen(int[] nums) {
        int posLen = 0;
        int negLen = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                posLen = 0;
                negLen = 0;
            } else if(nums[i] > 0) {
                posLen++;
                if(negLen > 0) {
                    negLen++;
                }
            } else if(nums[i] < 0){
                int temp = posLen;
                if(negLen > 0) {
                    posLen = negLen + 1;
                    negLen = temp + 1;
                } else {
                    posLen = 0;
                    negLen = temp+1;
                }
            } 
            ans = Math.max(ans, posLen);
        }
        return ans;
    }
}
