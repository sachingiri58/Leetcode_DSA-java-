/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Dummy node simplifies removing the head element(s)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                // remove curr
                prev.next = curr.next;
                // do not advance prev
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
