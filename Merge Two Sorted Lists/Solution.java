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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode i = list1;
        ListNode j = list2;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(i != null && j != null) {
            if(i.val < j.val) {
                curr.next = i;
                i = i.next;
                curr = curr.next;
            } else {
                curr.next = j;
                j = j.next;
                curr = curr.next;
            }
        }
        while(i != null) {
            curr.next = i;
            i = i.next;
            curr = curr.next;
        }
        while(j != null) {
            curr.next = j;
            j = j.next;
            curr = curr.next;
        }
        return head.next;
    }
}
