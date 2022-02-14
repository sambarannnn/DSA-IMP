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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        int leftsubtreeHeight = depth(root.left);
        int rightsubtreeHeight = depth(root.right);
        
        int difference = Math.abs(leftsubtreeHeight - rightsubtreeHeight);
        
        if(difference <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
        
    }
    
    private int depth(TreeNode root) {
        if(root == null)
            return 0;
        
        int leftheight = depth(root.left);
        int rightheight = depth(root.right);
        
        return Math.max(leftheight, rightheight) + 1;
    }
}
