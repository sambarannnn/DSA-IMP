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
    public TreeNode bstFromPreorder(int[] preorder) {
        // int[] inorder = new int[preorder.length];
        // for(int i = 0; i < preorder.length; i++) {
        //     inorder[i] = preorder[i];
        // }
        // Arrays.sort(inorder);//inorder is sorted nodes in case of bst
        int[] preorder_index = new int[]{0};
        // return generateTree(preorder, inorder, preorder_index, 0, inorder.length-1);//using preorder and selfmade inorder
        // return generateTree(preorder, preorder_index, 0, preorder.length-1);//using preorder and finding nodes smaller than this root and using it to divide into left subtree
        return generateTree(preorder, preorder_index, Integer.MAX_VALUE);//using preorder and a max bound
    }
    public TreeNode generateTree(int[] preorder, int[] preorder_index, int bound) {
        if(preorder_index[0] >= preorder.length || preorder[preorder_index[0]] > bound) {
            return null;
        }
            
        TreeNode root = new TreeNode(preorder[preorder_index[0]++]);
        root.left = generateTree(preorder, preorder_index, root.val);
        root.right = generateTree(preorder, preorder_index, bound);
        return root;
    }
    
    
    public TreeNode generateTree(int[] preorder, int[] preorder_index, int start, int end) {
        if(start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorder_index[0]++]);

        int i;
        for(i = start; i <= end; i++) {
            if(preorder[i] > root.val)
                break;
        }
        root.left = generateTree(preorder, preorder_index, preorder_index[0], i-1);
        root.right = generateTree(preorder, preorder_index, i, end);
        return root;
    }
    public int findInorderIndex(int[] inorder, int start, int end, TreeNode root) {
        for(int i = start; i <= end; i++) {
            if(inorder[i] == root.val) {
                return i;
            }
        }
        return -1;
    }
    public TreeNode generateTree(int[] preorder, int[] inorder, int[] preorder_index, int start, int end) {
        if(start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorder_index[0]++]);
        int inorder_index = findInorderIndex(inorder, start, end, root);
        root.left = generateTree(preorder, inorder, preorder_index, start, inorder_index-1);
        root.right = generateTree(preorder, inorder, preorder_index, inorder_index+1, end);
        return root;
    }
}
