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
class NodePos {
    int pos;
    int level;
    TreeNode node;
    NodePos(TreeNode node, int pos, int level) {
        this.node = node;
        this.pos = pos;
        this.level = level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
         
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> posToNodes = new TreeMap<>();//treemap stores acc to sorted keys
        
        Queue<NodePos> queue = new LinkedList<>();
        queue.add(new NodePos(root, 0, 0));
        
        while(!queue.isEmpty()) {
            NodePos curr = queue.remove();
            int currLevel = curr.level;
            int currPos = curr.pos;
            TreeMap<Integer, PriorityQueue<Integer>> currPosMap = posToNodes.getOrDefault(currPos, new TreeMap<Integer, PriorityQueue<Integer>>());
            
            PriorityQueue<Integer> pq = currPosMap.getOrDefault(currLevel, new PriorityQueue<Integer>());
            pq.add(curr.node.val);
            
            currPosMap.put(currLevel, pq);
            posToNodes.put(currPos, currPosMap);
            
            if(curr.node.left != null) {
                queue.add(new NodePos(curr.node.left, currPos-1, currLevel+1));
            }
            if(curr.node.right != null) {
                queue.add(new NodePos(curr.node.right, currPos+1, currLevel+1));
            }
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (TreeMap<Integer, PriorityQueue<Integer>> pos : posToNodes.values()) {
            res.add(new ArrayList<Integer>());
            for(PriorityQueue<Integer> pq : pos.values()) {
                while (!pq.isEmpty()) {
                    res.get(res.size()-1).add(pq.poll());
                }
            }
        }
        return res;
        
    }
}
