class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //find index of next greater element
        Stack<Integer> stack = new Stack<Integer>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int curr = stack.pop();
                int diff = i - curr;
                res[curr] = diff;
            }
            stack.push(i);
        }
        return res;
    }
}
