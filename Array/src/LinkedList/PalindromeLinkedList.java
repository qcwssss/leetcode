package LinkedList;

import java.util.ArrayList;

/** #234. Palindrome Linked List */
public class PalindromeLinkedList {

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  /** Approach #1: Convert into an array. */
  public boolean isPalindrome(ListNode head) {
    ListNode ptr = head;
    ArrayList<Integer> aList = new ArrayList<>();
    while (ptr != null) {
      aList.add(ptr.val);
      ptr = ptr.next;
    }
    int i = 0, j = aList.size() - 1;
    while (i <= j) {
      if (aList.get(i) != aList.get(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  /**
   * Approach #2: reversing the 2nd half and compare the two halves.
   *
   * @source
   *     https://leetcode.com/problems/palindrome-linked-list/discuss/64501/Java-easy-to-understand
   */
  public boolean isPalindrome2(ListNode head) {
    // find middle
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // reverse second half
    ListNode head1 = head;
    ListNode head2 = reverse(slow);
    // check palindrome
    while (head1 != null && head2 != null) {
      if (head1.val != head2.val) {
        return false;
      }
      head1 = head1.next;
      head2 = head2.next;
    }

    return true;
  }

  private ListNode reverse(ListNode n) {
    ListNode newHead = null;
    while (n != null) {
      ListNode next = n.next;
      n.next = newHead;
      newHead = n;
      n = next;
    }
    return newHead;
  }
}
