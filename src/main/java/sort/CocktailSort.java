package sort;

/**
 * Коктейльная сортировка
 * http://algolab.valemak.com/cocktail
 * Класс                    Сортировки обменами
 * Устойчивость             Устойчивая
 * Сравнения                Да
 * Сложность по времени
 *    Худшая               O(n2)
 *    Средняя              O(n2)
 *    Лучшая               O(n)
 * Сложность по памяти
 *    Общая                O(n)
 *    Дополнительная       O(1)
 */
class CocktailSort extends HasIntArraySort {

  @Override
  public void sortArray(int[] array) {
    int start = 0;
    int end = array.length;
    boolean needIteration = true;
    while (needIteration) {
      needIteration = false;
      for (int i = start; i < end - 1; i++) {
        if (array[i] > array[i + 1]) {
          swapArrayElements(array, i, i + 1);
          needIteration = true;
        }
      }
      if (needIteration) {
        end--;
        needIteration = false;
        for (int i = end - 1; i >= start; i--) {
          if (array[i] > array[i + 1]) {
            swapArrayElements(array, i, i + 1);
            needIteration = true;
          }
        }
      }
      if (needIteration) {
        start++;
      }
    }
  }
}
