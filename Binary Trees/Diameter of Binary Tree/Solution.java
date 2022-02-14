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
    // O(N^2 APPROACH)
    /*
    at every node, calculate left subtree height, right subtree height
    left + right = diameter considering this current node as curve
    now go to left
    go to right
    now we have diameter using this current node as cure, one from left subtree and one from right subtree
    max of these three is the result
    */
//     public int diameterOfBinaryTree(TreeNode root) {
//         return maxDiameter(root);
//     }
    
//     public static int maxDiameter(TreeNode root) {
//         if(root == null) {
//             return 0;
//         }
//         int leftHeight = maxDepth(root.left);
//         int rightHeight = maxDepth(root.right);
//         int currDia = leftHeight+rightHeight;
        
//         int ld = maxDiameter(root.left);
//         int rd = maxDiameter(root.right);
        
//         return Math.max(currDia, (Math.max(ld, rd)));
//     }
    
//     public static int maxDepth(TreeNode root) {
//         if(root == null)
//             return 0;
//         int leftHeight = maxDepth(root.left);
//         int rightHeight = maxDepth(root.right);
        
//         return Math.max(leftHeight, rightHeight) + 1;
//     }
    
    /*
    O(N) METHOD
    WE FIND MAXDEPTH OF TREE
    WHILE DOING THAT, WE USE POSTORDER TRAVERSAL
    SO AT EVERY NODE WHEN WE HAVE HEIGHT OF LEFT AND RIGHT SUBTREE
    WE CAN CALCULATE DIAMETER USING THESE VALUES AND UPDATE A MAXDIAMETER VARIABLE
        */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDia = new int[]{Integer.MIN_VALUE};
        maxDepth(root, maxDia);
        return maxDia[0];
    }
    public static int maxDepth(TreeNode root, int[] maxDia) {
        //while doing postorder to find maxdepth
        if(root == null)
            return 0;
        int leftHeight = maxDepth(root.left, maxDia);
        int rightHeight = maxDepth(root.right, maxDia);
        
        //at every postorder visit of node, we have left and right subtree's height
        //so use that to calculate maxdiameter with this node as curve
        maxDia[0] = Math.max(maxDia[0], leftHeight+rightHeight);
        
        return Math.max(leftHeight, rightHeight)+1;
    }
}
