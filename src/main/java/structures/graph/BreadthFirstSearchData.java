package structures.graph;

@SuppressWarnings("WeakerAccess")
public class BreadthFirstSearchData {

  private boolean enqueued;

  @SuppressWarnings("BooleanMethodIsAlwaysInverted")
  public boolean isEnqueued() {
    return enqueued;
  }

  public void setEnqueued(boolean enqueued) {
    this.enqueued = enqueued;
  }
}
