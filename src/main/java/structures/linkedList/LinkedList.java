package structures.linkedList;

@SuppressWarnings( {"unused", "UnusedReturnValue"})
public interface LinkedList {

  boolean isEmpty();

  int getSize();

  int getFirst();

  void insertFirst(int value);

  void insertLast(int value);

  void insertAfterNode(Node after, int value);

  int removeFirst();

  int removeLast();

  int removeAfterNode(Node node);

  int removeBeforeNode(Node node);
}
