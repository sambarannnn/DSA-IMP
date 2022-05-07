class Solution {
    public boolean find132pattern(int[] nums) {
        //https://leetcode.com/problems/132-pattern/discuss/906789/Short-Java-O(N)-Solution-with-Detailed-Explanation-and-Sample-Test-Case-or-Stack-or-100
        Stack<Integer> stack = new Stack<Integer>();
        //1 3 2
        int two = Integer.MIN_VALUE;
        for(int i = nums.length-1; i >= 0; i--) {
            //now, candidate for one = nums[i] ; two = (previously calculates) ; three = stack.peek()
            //we just need to see if one's candidate is < two since two is already < three
            if(nums[i] < two) {
                return true;
            }
            while(!stack.isEmpty() && nums[i] > stack.peek()) {
                two = stack.pop();
            }
            stack.push(nums[i]);//descending from bottom
        }
        return false;
    }
}
