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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> rightView = new ArrayList<Integer>();
        // if(root == null)
        //     return rightView;
        // Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // queue.add(root);
        // while(!queue.isEmpty()) {
        //     int size = queue.size();
        //     for(int i = 0; i < size; i++) {
        //         TreeNode curr = queue.remove();
        //         if(i == size-1) {
        //             rightView.add(curr.val) ;
        //         }
        //         if(curr.left != null) {
        //             queue.add(curr.left);
        //         } 
        //         if(curr.right != null){
        //             queue.add(curr.right);
        //         }
        //     }
        // }
        postorderTraversal(root, 0, rightView);
        return rightView;
    }
    public static void postorderTraversal(TreeNode root, int level, List<Integer> rightView) {
        if(root == null) {
            return;
        }
        
        if(level == rightView.size()) {
            rightView.add(root.val);
        }
        postorderTraversal(root.right, level+1, rightView);
        postorderTraversal(root.left, level+1, rightView);
    }
}
