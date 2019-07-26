package structures.linkedList;

public class SinglyLinkedList {

  private Node first;

  public void insertFirst(Node node) {
    if (node == null) {
      throw new IllegalArgumentException("Node is null!");
    }
    if (first == null) {
      first = node;
    } else {
      node.setNext(first);
      first = node;
    }
  }

  public void insertLast(Node node) {
    if (first != null) {
      Node lastNode = first;
      while (lastNode.getNext() != null) {
        lastNode = lastNode.getNext();
      }
      lastNode.setNext(node);
    }
  }

  public void insertAfterNode(Node after, Node node) {
    Node current = first;
    while (current != null) {
      if (current.equals(after)) {
        node.setNext(current.getNext());
        current.setNext(node);
        break;
      } else {
        current = current.getNext();
      }
    }
  }

  public Node removeFirst() {
    final Node tmp = first;
    if (first != null) {
      first = first.getNext();
    }
    return tmp;
  }

  public Node removeLast() {
    Node result = null;
    if (first == null) {
      // do nothing, return null
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
    return result;
  }

  public Node removeAfterNode(Node node) {
    Node result = node == null ? null : node.getNext();
    if (result != null) {
      node.setNext(result.getNext());
    }
    return result;
  }

  public Node removeBeforeNode(Node node) {
    Node result = null;
    if (node == null || first == null || first.equals(node)) {
      // do nothing, return null;
    } else if (node.equals(first.getNext())) {
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
    return result;
  }

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

  public boolean isEmpty() {
    return first == null;
  }

  @SuppressWarnings("WeakerAccess")
  public static class Node {

    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }
  }


}