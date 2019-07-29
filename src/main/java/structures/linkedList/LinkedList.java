package structures.linkedList;

@SuppressWarnings("unused")
public interface LinkedList {

  Node getFirst();

  void insertFirst(Node node);

  void insertLast(Node node);

  void insertAfterNode(Node after, Node node);

  Node removeFirst();

  Node removeLast();

  Node removeAfterNode(Node node);

  Node removeBeforeNode(Node node);

  default int getSize() {
    int count = 0;
    final Node first = getFirst();
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

  default boolean isEmpty() {
    return getFirst() == null;
  }
}
