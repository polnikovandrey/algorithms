package sort;

class SelectionSort implements HasIntArraySort {

  @Override
  public void sortArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int minIdx = i;
      for (int j = minIdx; j < array.length; j++) {
        if (array[j] < array[minIdx]) {
          minIdx = j;
        }
      }
      swapArrayElements(array, i, minIdx);
    }
  }
}
