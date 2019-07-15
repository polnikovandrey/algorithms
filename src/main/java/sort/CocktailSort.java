package sort;

/**
 * Коктейльная сортировка
 * https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%BF%D0%B5%D1%80%D0%B5%D0%BC%D0%B5%D1%88%D0%B8%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5%D0%BC
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
class CocktailSort extends IntArraySort {

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
