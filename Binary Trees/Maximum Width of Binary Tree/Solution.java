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
class Node {
    //may have to use long for integer overflow since we are multiplying by 2
    int index;
    TreeNode node;
    Node(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(root, 0));
        int maxWidth = Integer.MIN_VALUE;
        //for 0 based array indexing preorder for FULL BINARY TREE,
        //left child = 2*root_index + 1
        //right child = 2*root_index+2
        while(!queue.isEmpty()) {
            int size = queue.size();
            int left = -1;
            int right = -1;
            for(int i = 0; i < size; i++) {
                Node curr = queue.remove();
                int curr_index = curr.index;
                TreeNode currTreeNode = curr.node;
                if(i == 0) {
                    left = curr_index;
                }
                if(i == size-1) {
                    right = curr_index;
                }
                
                if(currTreeNode.left != null) {
                    queue.add(new Node(currTreeNode.left, (curr_index*2)+1));
                }
                if(currTreeNode.right != null) {
                    queue.add(new Node(currTreeNode.right, (curr_index*2)+2));
                }
            }
            int width = right-left+1;
            maxWidth = Math.max(width, maxWidth);
        }
        return maxWidth;
    }
}
