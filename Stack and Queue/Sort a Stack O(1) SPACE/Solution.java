import java.util.Stack;
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
        if(stack.isEmpty()) {
            return;
        }
        int ele = stack.pop();
        sortStack(stack);
        insert_at_sorted_pos(stack, ele);
	}

    public static void insert_at_sorted_pos(Stack<Integer> stack, int ele) {
        
        if(stack.isEmpty() || stack.peek() < ele) {
            stack.push(ele);
            return;
        }
        int top = stack.pop();
        insert_at_sorted_pos(stack, ele);
        stack.push(top);
    }
}
