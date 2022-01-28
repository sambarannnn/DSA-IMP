/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //if fast == null, then even even no of nodes
        //if fast.next == null, then odd no of nodes// in this case, slow pointer will be 1 ahead of middle of linkedlist making 2nd list the shorter one
        ListNode half = reverseList(slow);
        while(half != null) {
            if(half.val != head.val)
                return false;
            
            half = half.next;
            head = head.next;
        }
        return true;
    }
    private ListNode reverseList(ListNode head) {
        ListNode p, q, r;
        p = head;
        q = null;
        r = null;
        while(p != null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        head = q;
        return head;
    }
}
