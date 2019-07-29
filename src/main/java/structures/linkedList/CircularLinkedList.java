package structures.linkedList;

public class CircularLinkedList implements LinkedList {

  private Node first;
  private Node last;


  @Override
  public Node getFirst() {
    return first;
  }

  @Override
  public void insertFirst(Node node) {
    if (first == null) {
      first = node;
      last = node;
    } else {
      node.setNext(first);
      if (first == last) {
        last = node;
      }
      first = node;
    }
  }

  @Override
  public void insertLast(Node node) {
    if (first == null) {
      first = node;
      last = node;
    } else {
      last.setNext(node);
      if (first == last) {
        first = node;
      }
      last = node;
    }
  }

  @Override
  public void insertAfterNode(Node after, Node node) {
    if (after == last) {
      if (first == last) {
        first = node;
      }
      last = node;
    }
    node.setNext(after.getNext());
    after.setNext(node);
  }

  @Override
  public Node removeFirst() {
    final Node first = this.first;
    if (first != null) {
      if (last == first) {
        this.last = first.getNext();
      }
      this.first = first.getNext();
    }
    return first;
  }

  @Override
  public Node removeLast() {
    final Node last = this.last;
    if (this.first == this.last) {
      this.first = null;
      this.last = null;
    } else {
      Node next = first;
      while (next.getNext() != null && !next.getNext().equals(last)) {
        next = next.getNext();
      }
      next.setNext(null);
      this.last = next;
    }
    return last;
  }

  @Override
  public Node removeAfterNode(Node node) {
    final Node result = node.getNext();
    if (last == node.getNext()) {
      if (first == last) {
        first = node;
      }
      last = node;
    }
    return result;
  }

  @Override
  public Node removeBeforeNode(Node node) {
    Node result = null;
    if (first != null && first != node) {
      Node prev = null;
      Node next = first;
      while (next.getNext() != node) {
        prev = next;
        next = next.getNext();
      }
      if (next.getNext() == node) {
        if (prev == null) {
          if (first == last) {
            last = next.getNext();
          }
          first = next.getNext();
        } else {
          prev.setNext(next.getNext());
        }
      }
    }
    return result;
  }
}
