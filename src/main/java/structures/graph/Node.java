package structures.graph;

@SuppressWarnings("WeakerAccess")
public class Node {

  private final int vertexIdx;
  private Node next;

  public Node(int vertexIdx, Node next) {
    this.vertexIdx = vertexIdx;
    this.next = next;
  }

  public int getVertexIdx() {
    return vertexIdx;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}
