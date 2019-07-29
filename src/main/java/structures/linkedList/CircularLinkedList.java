package structures.linkedList;

public class CircularLinkedList extends AbstractLinkedList {

  private Node last;

  @Override
  public int getSize() {
    int count = 0;
    if (first != null) {
      count++;
      Node node = first;
      while (node.getNext() != first) {
        count++;
        node = node.getNext();
      }
    }
    return count;
  }

  @Override
  public int getFirst() {
    if (first == null) {
      throw new IllegalStateException("List is empty!");
    }
    return first.getValue();
  }

  @Override
  public void insertFirst(int value) {
    final Node node = new Node(value);
    if (first == null) {
      node.setNext(node);
      first = node;
      last = node;
    } else {
      node.setNext(first);
      last.setNext(node);
      first = node;
    }
  }

  @Override
  public void insertLast(int value) {
    final Node node = new Node(value);
    if (first == null) {
      node.setNext(node);
      first = node;
      last = node;
    } else {
      node.setNext(first);
      if (first == last) {
        first = node;
      }
      last.setNext(node);
      last = node;
    }
  }

  @Override
  public void insertAfterNode(Node after, int value) {
    final Node node = new Node(value);
    node.setNext(after.getNext());
    after.setNext(node);
    if (after.equals(last)) {
      if (first == last) {
        first = node;
      }
      last = node;
    }
  }

  @Override
  public int removeFirst() {
    final Node first = this.first;
    if (first == null) {
      throw new IllegalStateException("List is empty!");
    }
    if (last == first) {
      this.last = null;
      this.first = null;
    } else {
      this.first = first.getNext();
      this.last.setNext(this.first);
    }
    return first.getValue();
  }

  @Override
  public int removeLast() {
    final Node last = this.last;
    if (this.first == this.last) {
      this.first = null;
      this.last = null;
    } else {
      Node next = first;
      while (next.getNext() != null && !next.getNext().equals(last)) {
        next = next.getNext();
      }
      next.setNext(first);
      this.last = next;
    }
    return last.getValue();
  }

  @Override
  public int removeAfterNode(Node node) {
    final Node result = node.getNext();
    if (last == node.getNext()) {
      if (first == last) {
        first = node;
      }
      last = node;
      last.setNext(first);
    }
    return result.getValue();
  }

  @Override
  public int removeBeforeNode(Node node) {
    Node result = null;
    if (first != null && first != node) {
      Node prev = null;
      Node next = first;
      while (next.getNext() != node) {
        prev = next;
        next = next.getNext();
      }
      if (next.getNext() == node) {
        result = next;
        if (prev == null) {
          if (first == last) {
            last = next.getNext();
          }
          first = next.getNext();
          last.setNext(first);
        } else {
          prev.setNext(next.getNext());
        }
      }
    }
    if (result == null) {
      // Unexpected state, method should not enter here
      throw new IllegalStateException("Before node not found!");
    }
    return result.getValue();
  }
}
