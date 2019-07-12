package sort;

/**
 * Гномья сортировка
 * http://algolab.valemak.com/gnome
 * Класс                  Сортировки обменами
 * Устойчивость           Устойчивая
 * Сравнения              Да
 * Сложность по времени
 *    Лучшая              O(n)
 *    Средняя             O(n2)
 *    Худшая              O(n2)
 * Сложность по памяти
 *    Общая                O(n)
 *    Дополнительная       O(1)
 */
class GnomeSort extends HasIntArraySort {

  @Override
  void sortArray(int[] array) {
    int i = 1;
    while (i < array.length) {
      if (i == 0 || array[i] >= array[i - 1]) {
        i++;
      } else {
        swapArrayElements(array, i, i - 1);
        i--;
      }
    }
  }
}
