package search;

import java.util.Arrays;

/**
 * Для получения позиции искомого элемента перебирается набор из N элементов. В худшем сценарии для этого алгоритма искомый элемент оказывается последним в массиве.
 * В этом случае потребуется N итераций для нахождения элемента. Следовательно, временная сложность линейного поиска равна O(N).
 * Этот поиск требует всего одну единицу памяти для хранения искомого элемента. Это не относится к размеру входного массива.
 * Следовательно, пространственная сложность линейного поиска равна O(1).
 */
public class LinearSearch implements IntArraySearch {

  @Override
  public int searchForValueIdx(int[] array, int value) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException("Not valid array: " + Arrays.toString(array));
    }
    for (int i = 0; i < array.length; i++) {
      if (array[i] == value) {
        return i;
      }
    }
    return -1;
  }
}
