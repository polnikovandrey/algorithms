package sort;

/**
 * Пузырьковая сортировка
 * Эффективен он лишь для небольших массивов. Алгоритм считается учебным и практически не применяется вне учебной литературы,
 * вместо него на практике применяются более эффективные алгоритмы сортировки. В то же время метод сортировки обменами лежит в основе некоторых более совершенных алгоритмов,
 * таких как шейкерная сортировка, пирамидальная сортировка и быстрая сортировка.
 * https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%BF%D1%83%D0%B7%D1%8B%D1%80%D1%8C%D0%BA%D0%BE%D0%BC
 * http://algolab.valemak.com/bubble
 * Класс                  Сортировки обменами
 * Устойчивость           Да
 * Сравнения              Да
 * Сложность по времени
 *    Худшая              O(n2)
 *    Средняя             O(n2)
 *    Лучшая              O(n)
 * Сложность по памяти
 *    Общая               O(n)
 *    Дополнительная      O(1)
 */
class BubbleSort extends HasIntArraySort {

  @Override
  public void sortArray(int[] array) {
    boolean needIteration = true;
    while (needIteration) {
      needIteration = false;
      for (int i = 1; i < array.length; i++) {
        if (array[i] < array[i - 1]) {
          swapArrayElements(array, i, i - 1);
          needIteration = true;
        }
      }
    }
  }
}
