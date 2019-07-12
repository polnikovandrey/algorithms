package sort;

/**
 * Сортировка выбором
 * http://algolab.valemak.com/selection-simple
 * Класс                    Сортировки выбором
 * Устойчивость             Нет
 * Сравнения                Да
 * Сложность по времени
 *    Худшая                O(n2 / 2)
 *    Средняя               O(n2 / 2)
 *    Лучшая                O(n2 / 2)
 * Сложность по памяти
 *    Общая                 O(n)
 *    Дополнительная        O(1)
 */
class SelectionSort extends HasIntArraySort {

  @Override
  public void sortArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int minIdx = i;
      for (int j = minIdx; j < array.length; j++) {
        if (array[j] < array[minIdx]) {
          minIdx = j;
        }
      }
      swapArrayElements(array, i, minIdx);
    }
  }
}
