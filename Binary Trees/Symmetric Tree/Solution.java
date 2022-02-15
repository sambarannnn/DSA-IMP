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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()) {
            TreeNode root1 = queue.remove();
            TreeNode root2 = queue.remove();
            if(root1 == null && root2 == null) {
                continue;
            } else if(root1 == null || root2 == null || root1.val != root2.val) {
                return false;
            }
            queue.add(root1.left);
            queue.add(root2.right);
            queue.add(root1.right);
            queue.add(root2.left);
        }
        return true;
    }
    
    public static boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
}
