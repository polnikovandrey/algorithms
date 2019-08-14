package structures.binarySearchTree;

import java.util.AbstractMap;
import java.util.Map;

/**
 * При добавлении ноды с уже существующим в дереве значением - она добавляется справа от существующей ноды.
 * Это правило позволяет при удалении ноды, имеющей 2-е дочерние ноды, заменить ее на минимальное значение
 * поддерева удаляемой ноды.
 */
@SuppressWarnings("WeakerAccess")
public class BinarySearchTree {

  private Node root;

  public void insert(int value) {
    final Node node = new Node(value);
    if (root == null) {
      root = node;
    } else {
      Node current = root;
      Node parent = null;
      boolean toLeft = false;
      while (current != null) {
        parent = current;
        toLeft = value < current.getValue();
        if (toLeft) {
          current = current.getLeft();
        } else {
          current = current.getRight();
        }
      }
      if (toLeft) {
        parent.setLeft(node);
      } else {
        parent.setRight(node);
      }
    }
  }

  public Node getMin(Node node) {
    if (node == null) {
      node = root;
    }
    Node current = node;
    while (current.getLeft() != null) {
      current = current.getLeft();
    }
    return current;
  }

  public Node getMax(Node node) {
    if (node == null) {
      node = root;
    }
    Node current = node;
    while (current.getRight() != null) {
      current = current.getRight();
    }
    return current;
  }

  public void delete(int value) {
    final Map.Entry<Node, Node> parentNodeEntry = findByValue(value);
    if (parentNodeEntry != null) {
      final Node parent = parentNodeEntry.getKey();
      final Node toDelete = parentNodeEntry.getValue();

      if (toDelete == root) {
        root = null;
      } else {
        final boolean isLeft = parent.getLeft() == toDelete;
        if (toDelete.getLeft() == null && toDelete.getRight() == null) {
          if (isLeft) {
            parent.setLeft(null);
          } else {
            parent.setRight(null);
          }
        } else if (toDelete.getLeft() == null) {
          if (isLeft) {
            parent.setLeft(toDelete.getRight());
          } else {
            parent.setRight(toDelete.getRight());
          }
        } else if (toDelete.getRight() == null) {
          if (isLeft) {
            parent.setLeft(toDelete.getLeft());
          } else {
            parent.setRight(toDelete.getLeft());
          }
        } else {
          Node toReplace = toDelete.getRight();
          Node toReplaceParent = toDelete;
          while (toReplace.getLeft() != null) {
            toReplaceParent = toReplace;
            toReplace = toReplace.getLeft();
          }
          if (isLeft) {
            parent.setLeft(toReplace);
          } else {
            parent.setRight(toReplace);
          }

          if (toReplace != toDelete.getRight()) {
            toReplaceParent.setLeft(toReplace.getRight());
            toReplace.setRight(toDelete.getRight());
          }
        }
      }
    }
  }

  public boolean isEmpty() {
    return root == null;
  }

  public Map.Entry<Node, Node> findByValue(int value) {
    if (root != null) {
      Node current = root;
      Node parent = root;
      while (current != null) {
        if (current.getValue() == value) {
          return new AbstractMap.SimpleEntry<>(parent, current);
        }
        parent = current;
        if (value < current.getValue()) {
          current = current.getLeft();
        } else {
          current = current.getRight();
        }
      }
    }
    return null;
  }

  public boolean isBinarySearchTree() {
    if (root == null) {
      return true;
    }
    return checkNode(root);
  }

  private boolean checkNode(Node node) {
    if (node.getLeft() != null && node.getValue() < node.getLeft().getValue()) {
      return false;
    }
    if (node.getRight() != null && node.getValue() > node.getRight().getValue()) {
      return false;
    }
    boolean result = true;
    if (node.getLeft() != null) {
      result = checkNode(node.getLeft());
    }
    if (result && node.getRight() != null) {
      result = checkNode(node.getRight());
    }
    return result;
  }
}
