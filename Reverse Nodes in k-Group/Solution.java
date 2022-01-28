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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
 
        while(p != null) {
            ListNode q = p;
            for(int i = 0; i < k; i++) {//checking if k nodes available to reverse
                q = q.next;
                if(q == null)
                    break;
            }
            if(q == null) //lesser than k nodes
                break;
            // q = q.next;
            //we have k nodes, lets reverse
            ListNode tailk = p.next;//this will become tail after k group is reversed
            ListNode next = p.next;//first of the group to be reversed
            ListNode curr = null;
            ListNode prev = null;
            int n = k;
            while(n-->0) {
                prev = curr;
                curr = next;
                next = next.next;
                curr.next = prev;
            }
            tailk.next = next;
            p.next = curr;//
            
            p = tailk;//moving p to one node behind next group, i.e., tail of current reversed group
        }
        return dummy.next;
    }
}
