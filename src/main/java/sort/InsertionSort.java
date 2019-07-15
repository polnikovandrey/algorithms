package sort;

/**
 * Сортировка вставками
 * Наиболее хорошо данная сортировка себя показывает применительно к почти отсортированным массивами.
 * https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%B2%D1%81%D1%82%D0%B0%D0%B2%D0%BA%D0%B0%D0%BC%D0%B8
 * http://algolab.valemak.com/insertion-simple
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
