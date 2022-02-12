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
    public List<Integer> inorderTraversal(TreeNode root) {
        //morris traversal with O(1) space
        List<Integer> inorder = new ArrayList<Integer>();
        TreeNode p = root;
        while(p != null) {
            if(p.left == null) {
                inorder.add(p.val);
                p = p.right;
            } else {
                TreeNode q = p.left;
                while(q.right != null && q.right != p) {
                    q = q.right;
                }
                if(q.right == null) {
                    q.right = p;
                    p = p.left;
                } else {
                    q.right = null;
                    inorder.add(p.val);
                    p = p.right;
                }
            }
        }
        return inorder;
    }
    
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> inorder = new ArrayList<Integer>();
    //     Stack<TreeNode> stack = new Stack<TreeNode>();
    //     TreeNode p = root;
    //     while(p != null || !stack.isEmpty()) {
    //         if(p != null) {
    //             stack.push(p);
    //             p = p.left;
    //         } else {
    //             p = stack.pop();
    //             inorder.add(p.val);
    //             p = p.right;
    //         }
    //     }
    //     return inorder;
    // }
    // public static void inorder(TreeNode root, List<Integer> res) {
    //     if(root == null) {
    //         return;
    //     }
    //     inorder(root.left, res);
    //     res.add(root.val);
    //     inorder(root.right, res);
    // }
}
