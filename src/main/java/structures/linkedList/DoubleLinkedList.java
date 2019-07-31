package structures.linkedList;

public class DoubleLinkedList {

  public static class Node {
    private int value;
    private Node next;
    private Node previous;

    Node(int value) {
      this.value = value;
    }
  }

  private Node first;
  private Node last;


  public int getSize() {
    Node node = first;
    int size = node == null ? 0 : 1;
    if (node != null) {
      while (node.next != null) {
        size++;
        node = node.next;
      }
    }
    return size;
  }


  public int getFirst() {
    if (first == null) {
      throw new IllegalStateException("List is empty!");
    }
    return first.value;
  }


  public void insertFirst(int value) {
    final Node node = new Node(value);
    if (first != null) {
      first.previous = node;
    }
    node.next = first;
    if (last == null) {
      last = node;
    }
    first = node;
  }


  public void insertLast(int value) {
    final Node node = new Node(value);
    if (last != null) {
      last.next = node;
    }
    node.previous = last;
    if (first == null) {
      first = node;
    }
    last = node;
  }


  public void insertAfterNode(Node after, int value) {
    final Node node = new Node(value);
    if (after.next == null) {
      last = node;
    } else {
      after.next.previous = node;
      node.next = after.next;
    }
    node.previous = after;
    after.next = node;
  }


  public int removeFirst() {
    if (first == null) {
      throw new IllegalStateException("List is empty!");
    }
    final int result = first.value;
    if (first == last) {
      last = first.next;
    }
    first = first.next;
    return result;
  }


  public int removeLast() {
    if (first == null || last == null) {
      throw new IllegalStateException("List is empty!");
    }
    final int result = last.value;
    if (first == last) {
      first = last.previous;
    }
    last = last.previous;
    return result;
  }


  public int removeAfterNode(Node node) {
    if (node.next == null) {
      throw new IllegalArgumentException("Node is last!");
    }
    final int result = node.next.value;
    if (last == node.next) {
      last = node;
    }
    if (node.next.next != null) {
      node.next.next.previous = node;
    }
    node.next = node.next.next;
    return result;
  }


  public int removeBeforeNode(Node node) {
    if (node.previous == null) {
      throw new IllegalArgumentException("Node is first!");
    }
    final int result = node.previous.value;
    if (first == node.previous) {
      first = node;
    }
    if (node.previous.previous != null) {
      node.previous.previous.next = node;
    }
    node.previous = node.previous.previous;
    return result;
  }
}
