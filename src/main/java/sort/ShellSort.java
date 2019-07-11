package sort;

class ShellSort extends HasIntArraySort {

  @Override
  void sortArray(int[] array) {
    for (int step = array.length / 2; step > 0; step /= 2) {
      for (int i = step; i < array.length; i++) {
        for (int j = 0; j < i; j++) {
          if (array[j] > array[i]) {
            swapArrayElements(array, j, i);
          }
        }
      }
    }
  }
}
