package sort;

/**
 * Глупая сортировка
 * http://algolab.valemak.com/stupid
 * Класс                    Сортировки обменами
 * Устойчивость             Устойчивая
 * Сравнения                Да
 * Сложность по времени
 *    Худшая                O(n3)
 *    Средняя               O(n3)
 *    Лучшая                O(n3)
 * Сложность по памяти
 *    Общая                 O(n)
 *    Дополнительная        O(1)
 */
class StupidSort extends HasIntArraySort {

  @Override
  public void sortArray(int[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[i - 1]) {
        swapArrayElements(array, i, i - 1);
        i = 0;
      }
    }
  }
}
