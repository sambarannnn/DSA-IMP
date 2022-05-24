class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);//latest invalid
            } else if(c == ')') {
                if(stack.isEmpty() || s.charAt(stack.peek()) != '(') {//latest invalid
                    stack.push(i);
                } else if(s.charAt(stack.peek()) == '(') {//valid pair found!!
                    stack.pop();
                    //now this might be our longest possible pair
                    int last_invalid_yet = stack.isEmpty() ? -1 : stack.peek();
                    max = Math.max(max, i - last_invalid_yet);
                }
            }
        }
        return max;
    }
}
