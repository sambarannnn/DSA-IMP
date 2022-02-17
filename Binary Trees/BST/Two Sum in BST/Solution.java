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
    public boolean findTarget(TreeNode root, int k) {
        // boolean found[] = new boolean[]{false};
        return findTarget(root, root, k);
        // return found[0];
    }
    public static boolean findTarget(TreeNode head, TreeNode curr, int target) {
        if(curr == null) {
            return false;
        }
        if(findTarget(head, curr.left, target))
            return true;
        
        int complement = target - curr.val;
        if(complement > curr.val) {//cuz we have seen all of left side
            if(isPresent(head, complement))
                return true;
            
        }
        return findTarget(head, curr.right, target);
    }
    public static boolean isPresent(TreeNode root, int key) {
        while(root != null) {
            if(root.val < key) {
                root = root.right;
            } else if(root.val > key) {
                root = root.left;
            } else {
                return true;
            }
        }
        return false;
    }
}
