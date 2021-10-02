package Stack;

public class DesignCircularQueue {
  class MyCircularQueue {
    int[] q;
    int front, end, size;

    public MyCircularQueue(int k) {
      q = new int[k];
      front = 0;
      end = -1;
      size = 0;
    }

    public boolean enQueue(int value) {
      // enque from end, front ptr is fixed.
      if (!isFull()) {
        end = (end + 1) % q.length; // circular
        q[end] = value;
        size++;
        return true;
      } else {
        return false;
      }

    }

    public boolean deQueue() {
      // remove front
      if (!isEmpty()) {
        //q[front] = null;
        front = (front + 1) % q.length;
        size--;
        return true;
      } else {
        return false;
      }

    }

    public int Front() {
      if (isEmpty()) return -1;
      return q[front];

    }

    public int Rear() {
      if (isEmpty()) return -1;
      return q[end];

    }

    public boolean isEmpty() {
      return size == 0;

    }

    public boolean isFull() {
      return size == q.length;

    }
  }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
