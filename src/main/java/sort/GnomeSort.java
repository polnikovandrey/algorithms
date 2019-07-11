package sort;

class GnomeSort extends HasIntArraySort {

  @Override
  void sortArray(int[] array) {
    int i = 1;
    while (i < array.length) {
      if (i == 0 || array[i] >= array[i - 1]) {
        i++;
      } else {
        swapArrayElements(array, i, i - 1);
        i--;
      }
    }
  }
}
