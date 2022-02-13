/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
 class NodeVisit {
     int visit;
     TreeNode node;
     NodeVisit(TreeNode node, int visit) {
         this.visit = visit;
         this.node = node;
     }
 }
public class Solution {
    public int[] solve(TreeNode A, int B) {
        // Stack<NodeVisit> stack = new Stack<NodeVisit>();
        // TreeNode p = A;
        // while(p != null || !stack.isEmpty()) {
        //     if(p != null) {
        //         stack.push(new NodeVisit(p, 1));
        //         // System.out.println(stack.peek().node.val);
        //         if(p.val == B) {
        //             break;
        //         }
        //         p = p.left;
        //     } else {
        //         NodeVisit curr = stack.pop();
        //         p = curr.node;
        //         if(curr.visit == 1) {
        //             stack.push(new NodeVisit(p, 2));
        //             p = p.right;
        //         } else if(curr.visit == 2) {
        //             p = null;
        //         }
        //     }
        // }
        // int index = 0;
        // int[] res = new int[stack.size()];
        // for(NodeVisit i : stack) {
        //     res[index++] = i.node.val;
        // }
        // return res;
        List<Integer> res = new ArrayList<Integer>();
        findPath(A, B, res);
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
    public static boolean findPath(TreeNode root, int B, List<Integer> res) {
        if(root == null) {
            return false;
        }
        res.add(root.val);
        if(root.val == B) {
            return true;
        }
        if(findPath(root.left, B, res) || findPath(root.right, B, res)) {
            return true;
        } else {
            res.remove(res.size()-1);
            return false;
        }
    }
}
