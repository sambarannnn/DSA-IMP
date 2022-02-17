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
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] depths = new int[]{-1, -2};
        TreeNode[] parents = new TreeNode[]{null, null};
        
        getDepthAndParents(root, x, y, 0, null, depths, parents);
        if(depths[0] == depths[1] && parents[0] != parents[1]) {
            return true;
        } else {
            return false;
        }
    }
    public static void getDepthAndParents(TreeNode root, int x, int y, int depth, TreeNode parent, int[] depths, TreeNode[] parents) {
        if(root == null) {
            return;
        }
        if(root.val == x) {
            parents[0] = parent;
            depths[0] = depth;
        } else if(root.val == y) {
            parents[1] = parent;
            depths[1] = depth;
        }
        
        getDepthAndParents(root.left, x, y, depth+1, root, depths, parents);
        getDepthAndParents(root.right, x, y, depth+1, root, depths, parents);
    }
}
