class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        for(int num : nums) {
            sum += num;
            
            max = Math.max(max, sum);
            
            if(sum < 0) sum = 0;//if sum becomes negative, just reset sum counter.
            //single negative value is taken into consideration for max as we check for max before resetting
        }
        return max;
    }
}
