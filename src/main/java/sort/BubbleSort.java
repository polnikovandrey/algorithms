package sort;

/**
 * Пузырьковая сортировка
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
