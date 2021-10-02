package Stack;

import org.junit.Test;

public class DesignCircularDeque {

  class MyCircularDeque {
    int[] dq;
    int front = 0, end = -1, size = 0;
    int len;

    public MyCircularDeque(int k) {
      len = k;
      dq = new int[k];
    }
    // front move left
    public boolean insertFront(int value) {
      if (!isFull()) {
        if (--front < 0) front += len; // move ptr then assgin value
        dq[front] = value;
        size++;

        // edge case
        if (size == 1) end = front;

        return true;
      } else {
        return false;
      }

    }

    // end move right
    public boolean insertLast(int value) {
      if (!isFull()) {
        end = (end + 1) % len;
        dq[end] = value;
        size++;

        return true;
      } else {
        return false;
      }

    }

    public boolean deleteFront() {
      if (!isEmpty()) {
        front = (front + 1) % len;
        size--;

        return true;
      } else {
        return false;
      }

    }

    public boolean deleteLast() {
      if (!isEmpty()) {
        if (--end < 0) end += len;
        size--;

        return true;
      } else {
        return false;
      }

    }

    public int getFront() {
      if (!isEmpty()) return dq[front];
      else return -1;

    }

    public int getRear() {
      if (!isEmpty()) return dq[end];
      else return -1;

    }

    public boolean isEmpty() {
      return size == 0;

    }

    public boolean isFull() {
      return size == len;
    }
  }
  @Test
  public void testCircularDeque() {
    // ["MyCircularDeque","insertFront","getRear","insertFront","getRear","insertLast","getFront","getRear","getFront","insertLast","deleteLast","getFront"]
    // [[3],[9],[],[9],[],[5],[],[],[],[8],[],[]]
    MyCircularDeque myCircularDeque = new MyCircularDeque(3);
    myCircularDeque.insertFront(9);  // return True
    myCircularDeque.getRear();
    myCircularDeque.insertFront(9); // return True
    myCircularDeque.getRear();
    myCircularDeque.insertLast(5); // return True
    myCircularDeque.getFront();
    myCircularDeque.getRear();
    myCircularDeque.getFront();
    myCircularDeque.insertLast(8);  // return True
    myCircularDeque.deleteLast();   // return True
    myCircularDeque.getFront();
  }
}
