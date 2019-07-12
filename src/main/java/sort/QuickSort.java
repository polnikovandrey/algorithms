package sort;

/**
 * Быстрая сортировка
 * http://algolab.valemak.com/quick
 * Класс                  Сортировки обменами
 * Устойчивость           Нет
 * Сравнения              Да
 * Сложность по времени
 *    Лучшая              O(n)
 *    Средняя             O(n log n)
 *    Худшая              O(n2)
 * Сложность по дополнительной памяти
 *    Нативная            O(n)
 *    Седжвик             O(log n)
 */
class QuickSort extends HasIntArraySort {

  @Override
  void sortArray(int[] array) {
    sortSubArray(array, 0, array.length - 1);
  }

  private void sortSubArray(int[] subArray, int startIdx, int endIdx) {
    if (startIdx < endIdx) {
      final int partitionIdx = partition(subArray, startIdx, endIdx);
      sortSubArray(subArray, startIdx, partitionIdx - 1);
      sortSubArray(subArray, partitionIdx + 1, endIdx);
    }
  }

  private int partition(int[] subArray, int startIdx, int endIdx) {
    final int pivot = subArray[endIdx];
    int i = startIdx - 1;
    for (int j = startIdx; j < endIdx; j++) {
      if (subArray[j] <= pivot) {
        i++;
        swapArrayElements(subArray, i, j);
      }
    }
    swapArrayElements(subArray, i + 1, endIdx);
    return ++i;
  }
}
