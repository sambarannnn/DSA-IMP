class BSTIterator {

    TreeNode curr;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.curr = root;
        this.stack = new Stack<TreeNode>();
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }
    
    public int next() {
        if(stack.isEmpty())
            return -1;
        curr = stack.pop();
        int res = curr.val;
        curr = curr.right;
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        return res;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
