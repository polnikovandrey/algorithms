package structures.linkedList;

@SuppressWarnings("unused")
public class SinglyLinkedList extends AbstractLinkedList {

  @Override
  public int getSize() {
    int count = 0;
    if (first != null) {
      count++;
      Node node = first;
      while (node.getNext() != null) {
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
      first = node;
    } else {
      node.setNext(first);
      first = node;
    }
  }

  @Override
  public void insertLast(int value) {
    final Node node = new Node(value);
    if (first == null) {
      first = node;
    } else {
      Node lastNode = first;
      while (lastNode.getNext() != null) {
        lastNode = lastNode.getNext();
      }
      lastNode.setNext(node);
    }
  }

  @Override
  public void insertAfterNode(Node after, int value) {
    final Node node = new Node(value);
    node.setNext(after.getNext());
    after.setNext(node);
  }

  @Override
  public int removeFirst() {
    final Node tmp = first;
    if (first != null) {
      first = first.getNext();
    }
    return tmp.getValue();
  }

  @Override
  public int removeLast() {
    Node result = null;
    if (first == null) {
      throw new IllegalStateException("List is empty!");
    } else if (first.getNext() == null) {
      result = first;
      first = null;
    } else {
      Node current = first;
      while (current.getNext() != null) {
        if (current.getNext().getNext() == null) {
          result = current.getNext();
          current.setNext(null);
        } else {
          current = current.getNext();
        }
      }
    }
    if (result == null) {
      // Unexpected state, method should not enter here
      throw new IllegalStateException("Last not found!");
    }
    return result.getValue();
  }

  @Override
  public int removeAfterNode(Node node) {
    if (node == null) {
      throw new IllegalArgumentException("Node is null!");
    }
    if (node.getNext() == null) {
      throw new IllegalArgumentException("Node is last!");
    }
    final Node result = node.getNext();
    node.setNext(result.getNext());
    return result.getValue();
  }

  @Override
  public int removeBeforeNode(Node node) {
    Node result = null;
    if (node == null) {
      throw new IllegalArgumentException("Node is null!");
    }
    if (first == null) {
      throw new IllegalStateException("List is empty!");
    }
    if (first.equals(node)) {
      throw new IllegalArgumentException("Node is first!");
    }
    if (node.equals(first.getNext())) {
      result = first;
      first = first.getNext();
    } else {
      Node prev = null;
      Node current = first;
      while (current.getNext() != null) {
        if (current.getNext().equals(node)) {
          result = current;
          if (prev != null) {
            prev.setNext(current.getNext());
          }
        } else {
          prev = current;
          current = current.getNext();
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
