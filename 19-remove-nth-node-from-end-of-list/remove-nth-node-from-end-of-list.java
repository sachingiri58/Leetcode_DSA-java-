class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = 0;
        ListNode temp = head;

        // Step 1: Find the size of the list
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        // Step 2: If the node to delete is the head itself
        if (n == sz) {
            return head.next;
        }

        // Step 3: Find the node before the one to delete
        int i = 1;
        int iToFind = sz - n;
        ListNode prev = head;

        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        // Step 4: Delete the node
        prev.next = prev.next.next;

        // Step 5: Return the modified head
        return head;
    }
}
