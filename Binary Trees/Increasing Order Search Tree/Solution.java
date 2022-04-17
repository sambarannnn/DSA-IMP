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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode newRoot = new TreeNode(0);
        TreeNode[] curr = new TreeNode[]{newRoot};
        inorder(root, curr);
        return newRoot.right;
    }
    public void inorder(TreeNode root, TreeNode[] curr) {
        if(root == null) {
            return;
        }
        inorder(root.left, curr);
        
        //remove left subtree as we have already visited them and added to curr
        root.left = null;
        
        //keep building curr
        curr[0].right = root;
        curr[0] = curr[0].right;
        
        inorder(root.right, curr);
    }
}
