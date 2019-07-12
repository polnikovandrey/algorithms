package sort;

/**
 * Сортировка вставками
 * http://algolab.valemak.com/insertion-simple
 * Наиболее хорошо данная сортировка себя показывает применительно к почти отсортированным массивами.
 * Класс                  Сортировки вставками
 * Устойчивость           Да
 * Сравнения              Да
 * Сложность по времени
 *    Худшая              O(n2 / 2)
 *    Средняя             O(n2 / 4)
 *    Лучшая              O(n)
 * Сложность по памяти
 *    Общая               O(n)
 *    Дополнительная      O(1)
 */
class InsertionSort extends HasIntArraySort {

  @Override
  void sortArray(int[] array) {
    for (int i = 1; i < array.length; i++) {
      for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
        swapArrayElements(array, j, j - 1);
      }
    }
  }
}
