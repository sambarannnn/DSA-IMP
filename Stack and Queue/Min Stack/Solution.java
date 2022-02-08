class Node {
    int value;
    int minTillNow;
    
    Node(int value) {
        this.value = value;
    }
    Node(int value, int min) {
        this.value = value;
        this.minTillNow = min;
    }
}
class MinStack {
    
    Stack<Node> stack;
    
    public MinStack() {
        stack = new Stack<Node>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(new Node(val, val));
        } else {
            stack.push(new Node(val, Math.min(stack.peek().minTillNow, val)));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()) {
            return -1;
        } else {
            return stack.peek().value;
        }
    }
    
    public int getMin() {
        if(stack.isEmpty()) {
            return -1;
        } else {
            return stack.peek().minTillNow;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
