import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  private class DNode {
    int value;
    int key;
    DNode prev, next;
  }


  void add(DNode node) {
    DNode headNext = head.next;

    node.next = headNext;
    node.prev = head;

    headNext.prev = node;
    head.next = node;
  }

  void remove(DNode node) {
    DNode pre = node.prev;
    DNode next = node.next;
    pre.next = next;
    next.prev = pre;
  }

  void moveToHead(DNode node) {
    this.remove(node);
    this.add(node);
  }

  void popTail(DNode node) {
    DNode tailPrev = tail.prev;
    remove(tailPrev);
  }

  Map<Integer, DNode> cache = new HashMap<>();
  DNode head, tail;
  int capacity;
  int size = 0;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    // dummy
    head = new DNode();
    head.prev = null;

    tail = new DNode();
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
        cache.remove(tail.prev.key);
        popTail(tail.prev);
        size--;
      }
    } else {
      // key already exist
      node.value = value;
      moveToHead(node);
    }
  }







  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    lRUCache.get(1);    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    lRUCache.get(2);    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.get(1);    // return -1 (not found)
    lRUCache.get(3);    // return 3
    lRUCache.get(4);    // return 4

    System.out.println(lRUCache);

  }

}
