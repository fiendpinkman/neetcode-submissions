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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        ListNode dummy = new ListNode(0, head);
        current = head;
        int removeIndex = length - n;
        ListNode prev = dummy;
        while (removeIndex != 0) {
            prev = current;
            current = current.next;
            removeIndex--;
        }
        
        if (prev!=null) {
            current = current.next;
            if (current!=null) {
                prev.next = current;
            } else {
                prev.next = null;
            }
        }
        return dummy.next;
    }
}
