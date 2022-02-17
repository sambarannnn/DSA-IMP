public class Solution {

    public  static int findCeil(TreeNode<Integer> node, int x) {

        // Write your code here

        //find inorder successor including itself
        TreeNode successor = null;
        while(node != null) {
            if(node.data < x) {
                node = node.right;
            } else if(node.data >= x) {
                successor = node;
                node = node.left;
            }
        }
        return successor == null ? -1 : (int) successor.data;
    }
}
