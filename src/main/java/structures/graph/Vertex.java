package structures.graph;

import java.util.StringJoiner;

@SuppressWarnings("WeakerAccess")
public class Vertex {

  private final BreadthFirstSearchData breadthFirstSearchData;

  private final String name;
  private Node adjacent;

  public Vertex(String name, Node adjacent) {
    this.breadthFirstSearchData = new BreadthFirstSearchData();
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

  public BreadthFirstSearchData getBreadthFirstSearchData() {
    return breadthFirstSearchData;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Vertex.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .toString();
  }
}
