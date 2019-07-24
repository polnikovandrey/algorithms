package sort;

/**
 * Быстрая сортировка
 * Один из самых быстрых известных универсальных алгоритмов сортировки массивов; из-за наличия ряда недостатков на практике обычно используется с некоторыми доработками.
 * QuickSort является существенно улучшенным вариантом алгоритма сортировки с помощью прямого обмена (его варианты известны как «Пузырьковая сортировка» и «Шейкерная сортировка»),
 * известного, в том числе, своей низкой эффективностью. Принципиальное отличие состоит в том, что в первую очередь производятся перестановки на наибольшем возможном расстоянии
 * и после каждого прохода элементы делятся на две независимые группы.
 * Любопытный факт: улучшение самого неэффективного прямого метода сортировки дало в результате один из наиболее эффективных улучшенных методов.
 *
 * Достоинства:
 * Один из самых быстродействующих (на практике) из алгоритмов внутренней сортировки общего назначения.
 * Прост в реализации.
 * Требует лишь O(log n) дополнительной памяти для своей работы. (Не улучшенный рекурсивный алгоритм в худшем случае O(n) памяти)
 * Хорошо сочетается с механизмами кэширования и виртуальной памяти.
 * Допускает естественное распараллеливание (сортировка выделенных подмассивов в параллельно выполняющихся подпроцессах).
 * Допускает эффективную модификацию для сортировки по нескольким ключам (в частности — алгоритм Седжвика для сортировки строк):
 *   благодаря тому, что в процессе разделения автоматически выделяется отрезок элементов, равных опорному, этот отрезок можно сразу же сортировать по следующему ключу.
 * Работает на связных списках и других структурах с последовательным доступом, допускающих эффективный проход как от начала к концу, так и от конца к началу.
 *
 * Недостатки:
 * Сильно деградирует по скорости O(n^{2}) в худшем или близком к нему случае, что может случиться при неудачных входных данных.
 * Прямая реализация в виде функции с двумя рекурсивными вызовами может привести к ошибке переполнения стека,
 *    так как в худшем случае ей может потребоваться сделать O(n) вложенных рекурсивных вызовов.
 * Неустойчив.
 *
 * https://ru.wikipedia.org/wiki/%D0%91%D1%8B%D1%81%D1%82%D1%80%D0%B0%D1%8F_%D1%81%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0
 * http://algolab.valemak.com/quick
 * Класс                  Сортировки обменами
 * Устойчивость           Нет
 * Сравнения              Да
 * Сложность по времени
 *    Худшая              O(n2)
 *    Средняя             O(n log n)
 *    Лучшая              O(n)
 * Сложность по дополнительной памяти
 *    Нативная            O(n)
 *    Седжвик             O(log n)
 */
public class QuickSort extends IntArraySort {

  @Override
  public void sortArray(int[] array) {
    sortSubArray(array, 0, array.length - 1);
  }

  private void sortSubArray(int[] array, int startIdx, int endIdx) {
    if (startIdx < endIdx) {
      final int pivotIdx = partition(array, startIdx, endIdx);   // pivot - основа (здесь - опорный элемент, с которым сравниваются значения при сортировке подмассивов)
      sortSubArray(array, startIdx, pivotIdx - 1);
      sortSubArray(array, pivotIdx + 1, endIdx);
    }
  }

  private int partition(int[] array, int startIdx, int endIdx) {
    final int pivotValue = array[endIdx];
    int i = startIdx - 1;
    for (int j = startIdx; j < endIdx; j++) {
      if (array[j] <= pivotValue) {
        i++;
        swapArrayElements(array, i, j);
      }
    }
    swapArrayElements(array, i + 1, endIdx);
    return ++i;
  }
}
