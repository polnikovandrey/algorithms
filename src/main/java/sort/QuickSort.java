package sort;

/**
 * Быстрая сортировка
 * http://algolab.valemak.com/quick
 * Класс                  Сортировки обменами
 * Устойчивость           Нет
 * Сравнения              Да
 * Сложность по времени
 *    Худшая              O(n2)
 *    Средняя             O(n log n)
 *    Лучшая              O(n)
 * Сложность по дополнительной памяти
 *    Нативная            O(n)
 *    Седжвик             O(log n)
 */
class QuickSort extends HasIntArraySort {

  @Override
  void sortArray(int[] array) {
    sortSubArray(array, 0, array.length - 1);
  }

  private void sortSubArray(int[] array, int startIdx, int endIdx) {
    if (startIdx < endIdx) {
      final int pivotIdx = partition(array, startIdx, endIdx);   // pivot - основа (здесь - опорный элемент, с которым сравниваются значения при сортировке подмассивов)
      sortSubArray(array, startIdx, pivotIdx - 1);
      sortSubArray(array, pivotIdx + 1, endIdx);
    }
  }

  private int partition(int[] array, int startIdx, int endIdx) {
    final int pivotValue = array[endIdx];
    int i = startIdx - 1;
    for (int j = startIdx; j < endIdx; j++) {
      if (array[j] <= pivotValue) {
        i++;
        swapArrayElements(array, i, j);
      }
    }
    swapArrayElements(array, i + 1, endIdx);
    return ++i;
  }
}
