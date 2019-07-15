package sort;

/**
 * Сортировка выбором
 *
 * https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%B2%D1%8B%D0%B1%D0%BE%D1%80%D0%BE%D0%BC
 * http://algolab.valemak.com/selection-simple
 * Класс                    Сортировки выбором
 * Устойчивость             Нет
 * Сравнения                Да
 * Сложность по времени
 *    Худшая                O(n2)
 *    Средняя               O(n2)
 *    Лучшая                O(n2)
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
