package search;

import sort.QuickSort;

/**
 * Временная сложность алгоритма двоичного поиска равна O(log (N)) из-за деления массива пополам.
 * Одна единица пространства требуется для хранения искомого элемента. Следовательно, пространственная сложность равна O(1).
 */
public class BinaryIterativeSearch implements IntArraySearch {

  @Override
  public int searchForValueIdx(int[] array, int value) {
    new QuickSort().sortArray(array);
    int startIdx = 0;
    int endIdx = array.length - 1;
    while (startIdx <= endIdx) {
      final int middle = startIdx + (endIdx - startIdx) / 2;
      if (array[middle] == value) {
        return middle;
      } else if (array[middle] > value) {
        endIdx = middle - 1;
      } else if (array[middle] < value) {
        startIdx = middle + 1;
      }
    }
    return -1;
  }
}
