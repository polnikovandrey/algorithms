package structures.graph;

import java.util.StringJoiner;

@SuppressWarnings("WeakerAccess")
public class Vertex {

  /**
   * Смежная нода
   */
  private Node adjacent;

  private final String name;

  public Vertex(String name, Node adjacent) {
    this.name = name;
    this.adjacent = adjacent;
  }

  public String getName() {
    return name;
  }

  public Node getAdjacent() {
    return adjacent;
  }

  public void setAdjacent(Node adjacent) {
    this.adjacent = adjacent;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Vertex.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .toString();
  }
}
