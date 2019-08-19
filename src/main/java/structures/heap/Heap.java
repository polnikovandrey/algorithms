package structures.heap;

/**
 * Basic rule - child node's value must be lesser then parent's value.
 */
public class Heap {

  private final Node[] nodes;

  private int currentSize;

  public Heap(int size) {
    this.nodes = new Node[size];
  }

  public int getSize() {
    return currentSize;
  }

  public boolean isEmpty() {
    return currentSize == 0;
  }

  public boolean insert(int value) {
    if (currentSize == nodes.length) {
      return false;
    }
    final Node node = new Node(value);
    nodes[currentSize] = node;
    trickleUp(currentSize);
    currentSize++;
    return true;
  }

  /**
   * trickle - сочиться, капать
   * Node is compared to it's parent. Node is swapped with the parent if parent's value is lesser then node's.
   * Formulae to discover node's parent's index based on node's index: Integer parentIdx = idx == 0 ? null : (idx - 1) / 2
   */
  private void trickleUp(int idx) {
    final Node toInsert = nodes[idx];
    int parentIdx = (idx - 1) / 2;
    while (idx > 0 && nodes[parentIdx].getValue() < nodes[idx].getValue()) {
      nodes[idx] = nodes[parentIdx];
      idx = parentIdx;
      parentIdx = (idx - 1) / 2;
    }
    nodes[idx] = toInsert;
  }

  /**
   * Removes and returns a root node.
   */
  public Node remove() {
    return null;    // TODO implement
  }
}
