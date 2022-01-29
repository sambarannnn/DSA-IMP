/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = new Node(0);
        Node p = newHead;
        Node q = head;
        while(q != null) {
            p.next = new Node(q.val);
            p = p.next;
            map.put(q, p);
            q = q.next;
        }
        p = newHead.next;
        q = head;
        //map is q,p
        while(p != null) {
            p.random = map.get(q.random);
            p = p.next;
            q = q.next;
        }
        return newHead.next;
    }
}
