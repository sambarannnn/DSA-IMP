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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();
        TreeNode p = root;
        while(p != null) {
            if(p.left == null) {
                preorder.add(p.val);
                p = p.right;
            } else {
                TreeNode q = p.left;
                while(q.right != null && q.right != p) {
                    q = q.right;
                }
                if(q.right == null) {
                    preorder.add(p.val);
                    q.right = p;
                    p = p.left;
                } else {
                    q.right = null;
                    p = p.right;
                }
            }
        }
        return preorder;
    }
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> preorder = new ArrayList<Integer>();
//         Stack<TreeNode> stack = new Stack<TreeNode>();
//         TreeNode p = root;
//         while(p != null || !stack.isEmpty()) {
//             if(p != null) {
//                 preorder.add(p.val);
//                 stack.push(p);
//                 p = p.left;
//             } else {
//                 p = stack.pop();
//                 p = p.right;
//             }
//         }
        
//         return preorder;
//     }
//     public static void preorderTraversal(TreeNode root, List<Integer> preorder) {
//         if(root == null) {
//             return;
//         }
//         preorder.add(root.val);
//         preorderTraversal(root.left, preorder);
//         preorderTraversal(root.right, preorder);
//     }
}
