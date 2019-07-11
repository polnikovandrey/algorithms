package sort;

public class InsertionSort extends HasIntArraySort {

  @Override
  void sortArray(int[] array) {
    for (int i = 1; i < array.length; i++) {
      for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
        swapArrayElements(array, j, j - 1);
      }
    }
  }
}
