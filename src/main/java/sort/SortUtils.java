package sort;

class SortUtils {

  static void swapArrayElements(int[] array, int idx1, int idx2) {
    final int tmp = array[idx1];
    array[idx1] = array[idx2];
    array[idx2] = tmp;
  }

  static boolean isSortedArray(int[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[i - 1]) {
        return false;
      }
    }
    return true;
  }

  static int[] createIntArray1() {
    return new int[] {10, 2, 10, 3, 1, 2, 5};
  }
}
