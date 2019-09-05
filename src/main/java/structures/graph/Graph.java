package structures.graph;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Graph {

  private final Vertex[] vertices;
  private final boolean directional;
  private int indexCounter;

  public Graph(int size, boolean directional) {
    this.vertices = new Vertex[size];
    this.directional = directional;
  }

  public void addVertex(String vertexName) {
    vertices[indexCounter] = new Vertex(vertexName, null);
    indexCounter++;
  }

  public void addEdge(String firstVertexName, String secondVertexName) {
    final int firstVertexIdx = indexForName(firstVertexName);
    final int secondVertexIdx = indexForName(secondVertexName);
    doAppendEdge(firstVertexIdx, secondVertexIdx);
    if (!directional) {
      doAppendEdge(secondVertexIdx, firstVertexIdx);
    }
  }

  private void doAppendEdge(int firstVertexIdx, int secondVertexIdx) {
    final Vertex firstVertex = vertices[firstVertexIdx];
    final Node newFirstAdjacent = new Node(secondVertexIdx, null);
    if (firstVertex.getAdjacent() == null) {
      firstVertex.setAdjacent(newFirstAdjacent);
    } else {
      Node prevAdjacent = firstVertex.getAdjacent();
      Node adjacent = firstVertex.getAdjacent();
      boolean edgeSpotted = false;
      while(adjacent != null) {
        if (adjacent.getVertexIdx() == secondVertexIdx) {
          edgeSpotted = true;
          break;
        }
        prevAdjacent = adjacent;
        adjacent = adjacent.getNext();
      }
      if (!edgeSpotted) {
        prevAdjacent.setNext(newFirstAdjacent);
      }
    }
  }

  public String print() {
    return IntStream.range(0, vertices.length)
            .mapToObj(i -> {
              final Vertex vertex = vertices[i];
              final StringBuilder sb = new StringBuilder(Integer.toString(i));
              sb.append("::");
              sb.append(vertex.getName());
              Node node = vertex.getAdjacent();
              while(node != null) {
                final Vertex adjacent = vertices[node.getVertexIdx()];
                sb.append(" -> ");
                sb.append(node.getVertexIdx());
                sb.append("::");
                sb.append(adjacent.getName());
                node = node.getNext();
              }
              sb.append(System.lineSeparator());
              return sb.toString();
            })
            .collect(Collectors.joining());
  }

  public String nameForIndex(int index) {
    return vertices[index].getName();
  }

  private int indexForName(String vertexName) {
    return IntStream.range(0, vertices.length).filter(i -> vertices[i].getName().equals(vertexName)).findFirst().orElse(-1);
  }

  public boolean isDirectional() {
    return directional;
  }
}
