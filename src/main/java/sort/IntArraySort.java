package sort;

abstract class IntArraySort {

  abstract void sortArray(int[] array);

  /**
   * Swap two array elements.
   */
  final void swapArrayElements(int[] array, int idx1, int idx2) {
    final int tmp = array[idx1];
    array[idx1] = array[idx2];
    array[idx2] = tmp;
  }
}
