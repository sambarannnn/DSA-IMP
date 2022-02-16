class Solution {
    public Node connect(Node root) {
        //O(1) SPACE APPROACH WORKS UNIVERSALLY ON ALL TREES
        // DOESNT HAVE TO BE A PERFECT BINARY TREE
        Node head = root;
        
        while(head != null) {//left downwards
            Node dummy = new Node(0);
            Node curr = dummy;//build it rightwards
            
            while(head != null) {//rightwards horizontally
                
                if(head.left != null) {
                    curr.next = head.left;
                    curr = curr.next;
                }
                if(head.right != null) {
                    curr.next = head.right;
                    curr = curr.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }
        return root;
    }
}
