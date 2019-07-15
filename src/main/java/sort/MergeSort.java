package sort;

/**
 * Сортировка слиянием (англ. merge sort) — алгоритм сортировки, который упорядочивает списки (или другие структуры данных,
 * доступ к элементам которых можно получать только последовательно, например — потоки) в определённом порядке.
 * https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D1%81%D0%BB%D0%B8%D1%8F%D0%BD%D0%B8%D0%B5%D0%BC
 * http://algolab.valemak.com/merge-simple
 * Класс                  Сортировки слиянием
 * Устойчивость           Да
 * Сравнения              Да
 * Сложность по времени
 *    Худшая              O(n log2n)
 *    Средняя             O(n log2n)
 *    Лучшая              O(n log2n)
 * Сложность по памяти
 *    Общая               O(n)
 *    Дополнительная      O(n)
 */
class MergeSort extends IntArraySort {

  @Override
  void sortArray(int[] array) {
    sortSubArray(array, 0, array.length - 1);
  }

  private void sortSubArray(int[] subArray, int startIdx, int endIdx) {
    if (startIdx < endIdx) {
      final int middleIdx = (startIdx + endIdx) / 2;
      sortSubArray(subArray, startIdx, middleIdx);
      sortSubArray(subArray, middleIdx + 1, endIdx);
      mergeSubArrays(subArray, startIdx, middleIdx, endIdx);
    }
  }

  private void mergeSubArrays(int[] subArray, int startIdx, int middleIdx, int endIdx) {
    final int leftSubArraySize = middleIdx - startIdx + 1;
    final int rightSubArraySize = endIdx - middleIdx;
    final int[] leftSubArray = new int[leftSubArraySize];
    final int[] rightSubArray = new int[rightSubArraySize];
    System.arraycopy(subArray, startIdx, leftSubArray, 0, leftSubArraySize);
    System.arraycopy(subArray, middleIdx + 1, rightSubArray, 0, rightSubArraySize);

    int leftSubArrayIdx = 0;
    int rightSubArrayIdx = 0;
    int mergedSubArrayIdx = startIdx;
    while (leftSubArrayIdx < leftSubArraySize && rightSubArrayIdx < rightSubArraySize) {
      if (leftSubArray[leftSubArrayIdx] <= rightSubArray[rightSubArrayIdx]) {
        subArray[mergedSubArrayIdx] = leftSubArray[leftSubArrayIdx];
        leftSubArrayIdx++;
      } else {
        subArray[mergedSubArrayIdx] = rightSubArray[rightSubArrayIdx];
        rightSubArrayIdx++;
      }
      mergedSubArrayIdx++;
    }
    while (leftSubArrayIdx < leftSubArraySize) {
      subArray[mergedSubArrayIdx] = leftSubArray[leftSubArrayIdx];
      leftSubArrayIdx++;
      mergedSubArrayIdx++;
    }
    while (rightSubArrayIdx < rightSubArraySize) {
      subArray[mergedSubArrayIdx] = rightSubArray[rightSubArrayIdx];
      rightSubArrayIdx++;
      mergedSubArrayIdx++;
    }
  }
}
