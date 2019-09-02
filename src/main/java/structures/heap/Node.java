package structures.heap;

public class Node {

  private final int value;

  public Node(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return Integer.toString(value);
  }
}
