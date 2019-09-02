package structures.heap;

/**
 * Basic rule - child node's value must be lesser then parent's value.
 */
@SuppressWarnings( {"UnusedReturnValue", "unused"})
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
    while (idx > 0 && nodes[parentIdx].getValue() < toInsert.getValue()) {
      nodes[idx] = nodes[parentIdx];
      idx = parentIdx;
      parentIdx = (idx - 1) / 2;
    }
    nodes[idx] = toInsert;
  }

  /**
   * Removes and returns a root node. Formulae to get left child index by parent index is reverse to previous: Integer idx = 2 * parentIdx + 1
   */
  public Node remove() {
    if (isEmpty()) {
      return null;
    } else if (currentSize == 1) {
      currentSize--;
      final Node root = nodes[0];
      nodes[0] = null;
      return root;
    }

    final Node root = nodes[0];
    final Node toInsert = nodes[currentSize - 1];
    nodes[0] = toInsert;
    nodes[currentSize - 1] = null;
    currentSize--;

    int idx = 0;
    while (idx < currentSize) {
      final int leftIdx = 2 * idx + 1;
      final int rightIdx = leftIdx + 1;
      if (leftIdx >= currentSize) {
        break;
      } else if (rightIdx >= currentSize && nodes[leftIdx].getValue() > nodes[idx].getValue()) {
        nodes[idx] = nodes[leftIdx];
        nodes[leftIdx] = toInsert;
        break;
      } else if (rightIdx < currentSize && nodes[leftIdx].getValue() > nodes[rightIdx].getValue() && nodes[leftIdx].getValue() > nodes[idx].getValue()) {
        nodes[idx] = nodes[leftIdx];
        nodes[leftIdx] = toInsert;
      } else if (rightIdx < currentSize && nodes[leftIdx].getValue() <= nodes[rightIdx].getValue() && nodes[rightIdx].getValue() > nodes[idx].getValue()) {
        nodes[idx] = nodes[rightIdx];
        nodes[rightIdx] = toInsert;
      }
      idx++;
    }
    return root;
  }

  public boolean isValidHeap() {
    if (currentSize < 2) {
      return true;
    }
    int idx = 0;
    while(idx < currentSize) {
      final int leftIdx = 2 * idx + 1;
      final int rightIdx = leftIdx + 1;
      if (leftIdx < currentSize && nodes[leftIdx].getValue() > nodes[idx].getValue()) {
        return false;
      } else if (rightIdx < currentSize && nodes[rightIdx].getValue() > nodes[idx].getValue()) {
        return false;
      }
      idx++;
    }
    return true;
  }

}
