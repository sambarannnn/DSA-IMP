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
    public TreeNode convertBST(TreeNode root) {
        sum(root, 0);
        return root;
    }
    public int sum(TreeNode root, int curr) {
        if(root == null) {
            return curr;
        }
        root.val += sum(root.right, curr);
        int totalSum = sum(root.left, root.val);
        return totalSum;
    }
    // int visited = 0;
    // public TreeNode convertBST(TreeNode root) {
    // just do simple reverse inorder
    //     if(root != null) {
    //         convertBST(root.right);
    //         visited += root.val;
    //         root.val = visited;
    //         convertBST(root.left);
    //     }
    //     return root;
    // }
    
}
