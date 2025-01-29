package linkedlist;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/*
 * Here always remeber that:-
 * 1. Since your slow is moving lets say slowly one step at a time and your fast
 * is moving fast lets say
 * 2 step at a time, after some time what happens is your fast keeps rotating in
 * the cycle, and then
 * eventually both slow and fast meet each other in the cycle
 */
public class FindingCycleInLinkedList {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
