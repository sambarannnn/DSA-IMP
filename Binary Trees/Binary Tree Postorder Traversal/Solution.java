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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> postorder = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null || !stack.isEmpty()) {
            if(p != null) {
                postorder.addFirst(p.val);//reverse of preorder
                stack.push(p);
                p = p.right;//reverse of preorder
            } else {
                p = stack.pop();
                p = p.left;//reverse of preorder
            }
        }
        return postorder;
    }
    // public void postorderTraversal(TreeNode root, List<Integer> postorder) {
    //     if(root == null)
    //         return;
    //     postorderTraversal(root.left, postorder);
    //     postorderTraversal(root.right, postorder);
    //     postorder.add(root.val);
    // }
}
