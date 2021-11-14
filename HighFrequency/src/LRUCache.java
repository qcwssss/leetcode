import java.util.*;

public class LRUCache {

  Map<Integer, DNode> cache;
  DNode head;
  DNode tail;
  int capacity;
  int size = 0;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    // dummy
    DNode head = new DNode();
    head.prev = null;

    DNode tail  = new DNode();
    tail.next = null;

    head.next = tail;
    tail.prev = head;

  }

  public int get(int key) {
    if (!cache.containsKey(key)) return -1;

    DNode node = cache.get(key);
    moveToHead(node);

    return node.value;
  }

  public void put(int key, int value) {
    DNode node = cache.get(key);


    // add a new key
    if (node == null) {
      DNode newNode = new DNode();
      newNode.key = key;
      newNode.value = value;

      add(newNode);
      cache.put(key, newNode);
      size++;

      if (size > capacity) {
        popTail(tail.prev);
        cache.remove(tail.prev.key);
        size--;
      }
    } else {
      // key already exist
      node.value = value;
      moveToHead(node);
    }


  }

  void remove(DNode node) {
    DNode pre = node.prev;
    DNode next = node.next;
    pre.next = next;
    next.prev = pre;
  }

  void add(DNode node) {
    DNode headNext = head.next;

    node.next = headNext;
    node.prev = head;

    headNext.prev = node;
    head.next = node;
  }

  void moveToHead(DNode node) {
    this.remove(node);
    this.add(node);
  }

  void popTail(DNode node) {
    DNode tailPrev = tail.prev;
//
//    tailPrev.prev.next = tail;
//    tail.prev = tailPrev.prev;
    remove(tailPrev);
  }



  private class DNode {
    int value;
    int key;
    DNode prev, next;

//    DNode(int _key, int _value) {
//      key = _key;
//      value = _value;
//    }


  }

}
