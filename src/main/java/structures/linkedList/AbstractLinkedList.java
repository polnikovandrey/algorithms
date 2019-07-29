package structures.linkedList;

public abstract class AbstractLinkedList implements LinkedList {

  Node first;

  @Override
  public boolean isEmpty() {
    return first == null;
  }
}
