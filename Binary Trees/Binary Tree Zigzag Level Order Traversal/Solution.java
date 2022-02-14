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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean flag = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> current = new LinkedList<Integer>();
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                if(flag)
                    current.add(curr.val);
                else
                    current.addFirst(curr.val);
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            res.add(current);
            flag = !flag;
        }
        return res;
    }
}
