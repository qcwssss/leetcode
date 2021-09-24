public class LinkedListCycle {
    
    public boolean hasCycle(ListNode head) {
        //two pointers, fast and slow
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;

    }
}