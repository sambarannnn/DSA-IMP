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
    //O(N) APPROACH
    //USING POSTORDER MAXDEPTH
    public boolean isBalanced(TreeNode root) {
        boolean[] balanced = new boolean[]{true};
        maxDepth(root, balanced);
        return balanced[0];
    }
    public static int maxDepth(TreeNode root, boolean[] balanced) {
        if(root == null) {
            return 0;
        }
        if(balanced[0] == false)
            return -1;//no need to go further
        int leftHeight = maxDepth(root.left, balanced);
        int rightHeight = maxDepth(root.right, balanced);
        if(Math.abs(leftHeight - rightHeight) > 1)
            balanced[0] = false;
        return Math.max(leftHeight, rightHeight) + 1;
    }
    //O(N^2 APPROACH)
//     public boolean isBalanced(TreeNode root) {
//         if(root == null)
//             return true;
        
//         int leftsubtreeHeight = depth(root.left);
//         int rightsubtreeHeight = depth(root.right);
        
//         int difference = Math.abs(leftsubtreeHeight - rightsubtreeHeight);
        
//         if(difference <= 1 && isBalanced(root.left) && isBalanced(root.right))
//             return true;
//         return false;
        
//     }
    
//     private int depth(TreeNode root) {
//         if(root == null)
//             return 0;
        
//         int leftheight = depth(root.left);
//         int rightheight = depth(root.right);
        
//         return Math.max(leftheight, rightheight) + 1;
//     }
}
