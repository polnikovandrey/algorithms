package sort;

class BubbleSort implements HasIntArraySort {

  public void sortArray(int[] array) {
    boolean needIteration = true;
    while (needIteration) {
      needIteration = false;
      for (int i = 1; i < array.length; i++) {
        if (array[i] < array[i - 1]) {
          SortUtils.swapArrayElements(array, i, i - 1);
          needIteration = true;
        }
      }
    }
  }
}
