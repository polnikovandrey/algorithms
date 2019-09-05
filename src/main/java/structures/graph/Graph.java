package structures.graph;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Graph {

  private final Vertex[] vertices;
  private int indexCounter;

  public Graph(int size) {
    this.vertices = new Vertex[size];
  }

  public void addVertex(String vertexName) {
    vertices[indexCounter] = new Vertex(vertexName, null);
    indexCounter++;
  }

  public void addEdge(String firstVertexName, String secondVertexName) {
    final int firstVertexIdx = indexForName(firstVertexName);
    final int secondVertexIdx = indexForName(secondVertexName);
    doAppendEdge(firstVertexIdx, secondVertexIdx);
    // doAppendEdge(secondVertexIdx, firstVertexIdx);
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
    return Arrays.stream(vertices).map(vertex -> {
      String result = vertex.getName();
      Node node = vertex.getAdjacent();
      while(node != null) {
        final Vertex adjacent = vertices[node.getVertexIdx()];
        result += " -> ";
        result += node.getVertexIdx();
        result += "::";
        result += adjacent.getName();
        node = adjacent.getAdjacent();
      }
      result += System.lineSeparator();
      return result;
    }).collect(Collectors.joining());
  }

  public String nameForIndex(int index) {
    return vertices[index].getName();
  }

  private int indexForName(String vertexName) {
    return IntStream.range(0, vertices.length).filter(i -> vertices[i].getName().equals(vertexName)).findFirst().orElse(-1);
  }
}
