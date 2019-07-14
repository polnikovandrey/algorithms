package sort;

/**
 * Сортировка Шелла
 * http://algolab.valemak.com/shell
 * Как известно, вставочный метод очень эффективно обрабатывает почти отсортированные массивы.
 * Сортировка Шелла при первоначальных проходах достаточно быстро и доводит массив к состоянию неполной упорядоченности.
 * На заключительном этапе шаг равен единице, т.е. "Шелл" естественным образом трансформируется в сортировку простыми вставками.
 * Известно, что при удачном раскладе этот способ сортирует за O(n).
 * Но, в целом, сортировка работает существенно медленнее чем, к примеру быстрая сортировка или сортировка слиянием.
 * Средняя временная сложность зависит от того, какую последовательность брать для циклических итераций.
 * Класс                    Сортировки вставками
 * Устойчивость             Нет
 * Сравнения                Да
 * Сложность по времени
 *    Худшая                Зависит от шага
 *    Средняя               Зависит от шага
 *    Лучшая                O(n)
 * Сложность по памяти
 *    Общая                 O(n)
 *    Дополнительная        O(1)
 */
class ShellSort extends HasIntArraySort {

  private final InsertionSort insertionSort = new InsertionSort();

  @Override
  void sortArray(int[] array) {
    int increment = array.length / 2;
    while (increment >= 1) {
      for (int startIndex = 0; startIndex < increment; startIndex++) {
        insertionSort.insertionSort(array, startIndex, increment);
      }
      increment = increment / 2;
    }
  }
}
