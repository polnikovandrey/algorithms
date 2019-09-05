package structures.graph;

@SuppressWarnings("WeakerAccess")
public class Vertex {

  private final String name;
  private Node adjacent;

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
}
