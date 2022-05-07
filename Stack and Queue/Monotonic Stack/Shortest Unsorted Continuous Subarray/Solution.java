class Solution {
    public int findUnsortedSubarray(int[] nums) {
        //using monotonic stack
        //first try to find next smaller element from lhs
        Stack<Integer> stack = new Stack<Integer>();
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                l = Math.min(l, stack.pop());//min in case of duplicates
            }
            stack.push(i);
        }
        stack.clear();
        //now try to find next greater element from rhs
        for(int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                r = Math.max(r, stack.pop());//max in case of duplicates --> eg:- visualise 1,3,2,2,2
            }
            stack.push(i);
        }
        if(l != Integer.MAX_VALUE && r != Integer.MIN_VALUE) {
            return r - l + 1;
        }
        return 0;
    }
    
//     public int findUnsortedSubarray(int[] nums) {
//         //O(N) time ad space
//         int l = -1;
//         int r = -1;
        
//         //find last index where num is smaller than currMax, this will be right edge of the subarray
//         //if array is in sorted order, no num will be smaller than currmax, thus r will not change from -1
//         int currMax = Integer.MIN_VALUE;
//         for(int i = 0; i < nums.length; i++) {
//             if(nums[i] < currMax) {
//                 r = i;
//             }
//             currMax = Math.max(currMax, nums[i]);
//         }
        
//         //find first index on left side where num is larger than currmin(from right side), this will be left edge of subarray
//         //if array is sorted, no num will be smaller than currmin, this l will not change from -1;
//         int currMin = Integer.MAX_VALUE;
//         for(int i = nums.length-1; i >= 0; i--) {
//             if(nums[i] > currMin) {
//                 l = i;
//             }
//             currMin = Math.min(currMin, nums[i]);
//         }
//         if(l != -1 && r != -1) {
//             return r - l + 1;
//         }
//         return 0;
//     }
}
