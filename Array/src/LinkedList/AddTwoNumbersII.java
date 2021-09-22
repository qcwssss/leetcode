package LinkedList;

import org.junit.Test;

import java.util.Stack;

public class AddTwoNumbersII {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // use the property of Stack
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // store every digits in a stack
    while (l1 != null) {
      s1.add(l1.val);
      l1 = l1.next;
    }

    while (l2 != null) {
      s2.add(l2.val);
      l2 = l2.next;
    }

    // build a new LinkedList whose nodes stores the digits of the sum
    ListNode newHead = null;
    int carry = 0;
    while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
      int sum = (s1.isEmpty() ? 0 : s1.pop()) + (s2.isEmpty() ? 0 : s2.pop());
      int val = (sum  + carry)% 10;
      ListNode cur = new ListNode(val);
      cur.next = newHead;
      newHead = cur;

      carry = sum/10;
    }
    return newHead;
  }

  @Test
  public void testAdd1() {
    ListNode l1 = new ListNode(1);


    ListNode l2 = new ListNode(9);
    l2.next = new ListNode(9);
    //l2.next.next = new ListNode(5);

    ListNode addition = addTwoNumbers(l1, l2);
    System.out.println(addition);
  }
}
