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
class NodeValue {
    int min;
    int max;
    int sum;
    NodeValue(int min, int max, int sum) {
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}

class Solution {
    public int maxSumBST(TreeNode root) {
        int[] maxSum = new int[]{0};
        maxSumBST(root, maxSum);
        return maxSum[0];
    }
    public NodeValue maxSumBST(TreeNode root, int[] maxSum) {
        if(root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeValue left = maxSumBST(root.left, maxSum);
        NodeValue right = maxSumBST(root.right, maxSum);
        
        
        if(root.val > left.max && root.val < right.min) {
            // System.out.println(root.val + " | " + left.max + " | " + right.min);
            int currMin = left.min;
            int currMax = right.max;
            if(currMin == Integer.MAX_VALUE) currMin = root.val;
            if(currMax == Integer.MIN_VALUE) currMax = root.val;
            int currSum = left.sum + right.sum + root.val;
            maxSum[0] = Math.max(maxSum[0], currSum);
            NodeValue curr = new NodeValue(currMin, currMax, currSum);
            return curr;
        } else {
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.sum, right.sum));
        }
    }
}
