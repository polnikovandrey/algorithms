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
    insertionSort(array, 0, 1);
  }

  void insertionSort(int[] array, int startIdx, int increment) {
    for (int i = startIdx; i < array.length - 1; i = i + increment) {
      for (int j = Math.min(i + increment, array.length - 1); j - increment >= 0; j = j - increment) {
        if (array[j - increment] > array[j]) {
          swapArrayElements(array, j, j - increment);
        } else {
          break;
        }
      }
    }
  }
}
