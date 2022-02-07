import java.util.Stack;

public class Solution {
    
	public static void reverseStack(Stack<Integer> stack) {
		// write your code here
        if(stack.isEmpty()) {
            return;
        }
		int ele = stack.pop();
        reverseStack(stack);
        insert_at_bottom(stack, ele);
	}
    
    public static void insert_at_bottom(Stack<Integer> stack, int ele) {
        if(stack.isEmpty()) {
            stack.push(ele);
            return;
        }
        int top = stack.pop();
        insert_at_bottom(stack, ele);
        stack.push(top);
    }

}
