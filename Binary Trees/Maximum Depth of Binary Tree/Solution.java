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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
//         if(root == null)
//             return 0;
        
//         Queue<TreeNode> queue = new LinkedList<TreeNode>();
//         queue.add(root);
//         int level = 0;
//         while(!queue.isEmpty()) {
//             level++;
//             int size = queue.size();
//             for(int i = 0; i < size; i++) {
//                 TreeNode curr = queue.remove();
//                 if(curr.left != null) {
//                     queue.add(curr.left);
//                 }
//                 if(curr.right != null) {
//                     queue.add(curr.right);
//                 }
//             }
//         }
//         return level;
    }
}
