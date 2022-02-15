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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] postorder_index = new int[]{postorder.length-1};
        return buildTree(postorder, inorder, postorder_index, 0, inorder.length-1);
    }
    public static int findInorderIndex(int[] inorder, int inorder_start, int inorder_end, TreeNode root) {
        int inorder_index = -1;
        for(int i = inorder_start; i <= inorder_end; i++) {
            if(inorder[i] == root.val) {
                inorder_index = i;
                break;
            }
        }
        return inorder_index;
    }
    public static TreeNode buildTree(int[] postorder, int[] inorder, int[] postorder_index, int inorder_start, int inorder_end) {
        
        if(inorder_start > inorder_end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder_index[0]]);
        postorder_index[0]--;
        
        int inorder_index = findInorderIndex(inorder, inorder_start, inorder_end, root);
        
        root.right = buildTree(postorder, inorder, postorder_index, inorder_index+1, inorder_end);
        root.left = buildTree(postorder, inorder, postorder_index, inorder_start, inorder_index-1);
        
        return root;
    }
}
