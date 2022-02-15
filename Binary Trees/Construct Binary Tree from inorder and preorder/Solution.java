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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preorder_index = new int[]{0};
        return buildTree(preorder, inorder, preorder_index, 0, inorder.length-1);
    }
    public int findInorderIndex(int[] inorder, int inorder_start, int inorder_end, TreeNode root) {
        int inorder_index = -1;
        for(int i = inorder_start; i <= inorder_end; i++) {
            if(root.val == inorder[i]) {
                inorder_index = i;
                break;
            }
        }
        return inorder_index;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int[] preorder_index, int inorder_start, int inorder_end) {
        
        if(inorder_start > inorder_end)
            return null;
        
        TreeNode root = new TreeNode(preorder[preorder_index[0]]);
        preorder_index[0]++;
        //find this node in inorder
        int inorder_index = findInorderIndex(inorder, inorder_start, inorder_end, root);
        //now build left and right subtree
        root.left = buildTree(preorder, inorder, preorder_index, inorder_start, inorder_index-1);
        root.right = buildTree(preorder, inorder, preorder_index, inorder_index+1, inorder_end);
        
        return root;
    }
}
