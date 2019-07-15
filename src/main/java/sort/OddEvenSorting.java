package sort;

/**
 * Четно-нечетная сортировка
 * Этот относительно простой алгоритм сортировки, разработанный для использования на параллельных процессорах, является модификацией пузырьковой сортировки.
 * Суть модификации в том, чтобы сравнивать элементы массива под чётными и нечётными индексами с последующими элементами независимо.
 * https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D1%87%D1%91%D1%82-%D0%BD%D0%B5%D1%87%D0%B5%D1%82
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
class OddEvenSorting extends IntArraySort {

  @Override
  public void sortArray(int[] array) {
    boolean needIteration = true;
    while (needIteration) {
      needIteration = false;
      for (int i = 0; i < array.length - 1; i += 2) {
        if (compareAndSwapElements(array, i)) {
          needIteration = true;
        }
      }
      for (int i = 1; i < array.length - 1; i += 2) {
        if (compareAndSwapElements(array, i)) {
          needIteration = true;
        }
      }
    }
  }

  private boolean compareAndSwapElements(int[] array, int i) {
    if (array[i] > array[i + 1]) {
      swapArrayElements(array, i, i + 1);
      return true;
    }
    return false;
  }
}
