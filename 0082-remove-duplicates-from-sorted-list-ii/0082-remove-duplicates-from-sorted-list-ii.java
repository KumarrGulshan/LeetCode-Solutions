class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {

            // Duplicate detected
            if (current.next != null &&
                current.val == current.next.val) {

                while (current.next != null &&
                       current.val == current.next.val) {

                    current = current.next;
                }

                // Remove all duplicates
                prev.next = current.next;

            } else {

                prev = prev.next;
            }

            current = current.next;
        }

        return dummy.next;
    }
}