package sort;

/**
 * Четно-нечетная сортировка
 * http://algolab.valemak.com/odd-even
 * Класс                    Сортировки обменами
 * Устойчивость             Устойчивая
 * Сравнения                Да
 * Сложность по времени
 *    Худшая                O(n2)
 *    Средняя               O(n2)
 *    Лучшая                O(n)
 * Сложность по памяти
 *    Общая                 O(n)
 *    Дополнительная        O(1)
 */
class OddEvenSorting extends HasIntArraySort {

  @Override
  public void sortArray(int[] array) {
    boolean needIteration = true;
    while (needIteration) {
      needIteration = false;
      for (int i = 0; i < array.length - 1; i += 2) {
        if (array[i] > array[i + 1]) {
          swapArrayElements(array, i, i + 1);
          needIteration = true;
        }
      }
      for (int i = 1; i < array.length - 1; i += 2) {
        if (array[i] > array[i + 1]) {
          swapArrayElements(array, i, i + 1);
          needIteration = true;
        }
      }
    }
  }
}
