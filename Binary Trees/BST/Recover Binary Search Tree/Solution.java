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
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode p = null;
        TreeNode q = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        
        while(root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if(prev != null && root.val < prev.val) {
                    if(p == null) {
                        p = prev;//at beginning we should have smaller value, so bigger value is at fault
                    }
                    //update when we find p for first time, in case both adjacent were wrong
                    //also update if we find discrepancy going forward
                    q = root;//at ending we should have bigger value, so smaller value is at fault
                } 
                prev = root;
                root = root.right;
            }
        }
        int temp  = p.val;
        p.val = q.val;
        q.val = temp;
    }
}
