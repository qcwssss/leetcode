package LinkedList;

import java.util.ArrayList;

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

  /**  Approach #1: Convert into an array. */
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
   * Approach #2:  reversing the 2nd half and compare the two halves.
   */
  public boolean isPalindrome2(ListNode head) {
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

}
