/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTiterator {
    Stack<TreeNode> stack;
    boolean ascending;
    TreeNode curr;
    BSTiterator(TreeNode root, boolean isAscending) {
        this.ascending = isAscending;
        stack = new Stack<TreeNode>();
        fillStack(root);
    }
    private void fillStack(TreeNode root) {
        while(root != null) {
            stack.push(root);
            if(ascending == true)
                root = root.left;
            else
                root = root.right;
        }
    }
    public int next() {
        int val = stack.peek().val;
        TreeNode root = stack.pop();
        fillStack(root.right);
        return val;
    }
    public int prev() {
        int val = stack.peek().val;
        TreeNode root = stack.pop();
        fillStack(root.left);
        return val;
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTiterator left = new BSTiterator(root, true);
        BSTiterator right = new BSTiterator(root, false);
        
        int l = left.next();
        int r = right.prev();
        //like binary search
        //O(logn) time
        //O(height of tree) space
        while(l < r) {
            if(l + r > k) {
                r = right.prev();
            } else if(l + r < k) {
                l = left.next();
            } else {
                return true;
            }
        }
        return false;
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution2 {
    public boolean findTarget(TreeNode root, int k) {
        // boolean found[] = new boolean[]{false};
        return findTarget(root, root, k);
        // return found[0];
    }
    public static boolean findTarget(TreeNode head, TreeNode curr, int target) {
        if(curr == null) {
            return false;
        }
        if(findTarget(head, curr.left, target))
            return true;
        
        int complement = target - curr.val;
        if(complement > curr.val) {//cuz we have seen all of left side
            if(isPresent(head, complement))
                return true;
            
        }
        return findTarget(head, curr.right, target);
    }
    public static boolean isPresent(TreeNode root, int key) {
        while(root != null) {
            if(root.val < key) {
                root = root.right;
            } else if(root.val > key) {
                root = root.left;
            } else {
                return true;
            }
        }
        return false;
    }
}
