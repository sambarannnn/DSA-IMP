/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serial = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                if(curr != null) {
                    serial.append(curr.val + " ");
                } else {
                    serial.append("#" + " ");
                    continue;
                }
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        // System.out.println(serial.toString().trim());
        return serial.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("#")) 
            return null;
        String[] s = data.split("\\s+");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        queue.add(root);
        
        for(int index = 1; index < s.length; index++) {
            TreeNode curr = queue.remove();
            if(!s[index].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(s[index]));
                queue.add(curr.left);
            }
            index++;
            if(!s[index].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(s[index]));
                queue.add(curr.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
