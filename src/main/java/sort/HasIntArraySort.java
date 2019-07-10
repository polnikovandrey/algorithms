package sort;

public interface HasIntArraySort {

  void sortArray(int[] array);

  /**
   * Swap two array elements.
   */
  default void swapArrayElements(int[] array, int idx1, int idx2) {
    final int tmp = array[idx1];
    array[idx1] = array[idx2];
    array[idx2] = tmp;
  }
}
