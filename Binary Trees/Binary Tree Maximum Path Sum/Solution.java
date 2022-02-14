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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        calculate(root, max);
        return max[0];
    }
    public static int calculate(TreeNode root, int[] max) {
        if(root == null)
            return 0;
        
        int leftMaxSum = Math.max(0, calculate(root.left, max));
        int rightMaxSum = Math.max(0, calculate(root.right, max));
        
        //considering this node as a curve point
        int currSum = leftMaxSum + rightMaxSum + root.val;
        max[0] = Math.max(currSum, max[0]);
        
        //returning maximum path sum using this node, either left or right path
        return Math.max(leftMaxSum, rightMaxSum) + root.val;
    }
}
