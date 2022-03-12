class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //there are two cases
        //case 1 : maxsubarray sum is in middle of the array : use normal kadane's algo
        //case 2 : maxsubarray sum curves around the array thus, minsubarray sum is in the middle, for this case, subtract the minsubarray sum from totalsum of the array to find the two ends of the maxsubarraysum
        int sum = 0;
        for(int num : nums) sum += num;
        int max1 = kadane(nums);
        int max2 = sum - minKadane(nums);
        return max1 < 0 ? max1 : Math.max(max1, max2);
        //corner case : if all elements are negative, max1 will be max element and max2 will be 0 as minsubarraysum will be sum of all elements of this all negative array and max2 = total - minsubarraysum
    }
    public static int minKadane(int[] nums) {
        int min = Integer.MAX_VALUE;
        int currSum = 0;
        for(int num : nums) {
            currSum += num;
            min = Math.min(min, currSum);
            if(currSum > 0) {
                currSum = 0;
            }
        }
        return min;
    }
    public static int kadane(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for(int num : nums) {
            currSum += num;
            max = Math.max(max, currSum);
            if(currSum < 0) {
                currSum = 0;
            }
        }
        return max;
    }
}
