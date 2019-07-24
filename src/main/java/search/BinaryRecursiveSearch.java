package search;

import sort.QuickSort;

/**
 * Временная сложность алгоритма двоичного поиска равна O(log (N)) из-за деления массива пополам.
 * Рекурсивные вызовы помещаются в стек и занимают одну единицу пространства за вызов.
 * Рекурсивный двоичный поиск хранит вызов метода в стеке. В худшем случае пространственная сложность потребует O(log (N)).
 */
public class BinaryRecursiveSearch implements IntArraySearch {

  @Override
  public int searchForValueIdx(int[] array, int value) {
    new QuickSort().sortArray(array);
    return searchForValue(array, 0, array.length - 1, value);
  }

  private int searchForValue(int[] array, int startIdx, int endIdx, int value) {
    if (endIdx >= startIdx) {
      final int middle = startIdx + (endIdx - startIdx) / 2;
      if (array[middle] == value) {
        return middle;
      } else if (array[middle] > value) {
        return searchForValue(array, startIdx, middle - 1, value);
      } else {
        return searchForValue(array, middle + 1, endIdx, value);
      }
    }
    return -1;
  }
}
