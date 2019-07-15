package sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

public class SortTest implements IntArrayTest {

  @Test
  public void stupidSort() {
    repeatSortExecution(new StupidSort());
  }

  @Test
  public void bubbleSort() {
    repeatSortExecution(new BubbleSort());
  }

  @Test
  public void cocktailSort() {
    repeatSortExecution(new CocktailSort());
  }

  @Test
  public void oddEvenSort() {
    repeatSortExecution(new OddEvenSorting());
  }

  @Test
  public void gnomeSort() {
    repeatSortExecution(new GnomeSort());
  }

  @Test
  public void quickSort() {
    repeatSortExecution(new QuickSort());
  }

  @Test
  public void insertionSort() {
    repeatSortExecution(new InsertionSort());
  }

  @Test
  public void shellSort() {
    repeatSortExecution(new ShellSort());
  }

  @Test
  public void selectionSort() {
    repeatSortExecution(new SelectionSort());
  }

  @Test
  public void mergeSort() {
    repeatSortExecution(new MergeSort());
  }

  private void repeatSortExecution(IntArraySort sort) {
    IntStream.rangeClosed(0, 2).forEach(value -> {
      final int[] intArray = createIntArray(5, 5, 10);
      sort.sortArray(intArray);
      assertTrue(sort.getClass().getSimpleName() + ": error: " + Arrays.toString(intArray), isSortedIntArray(intArray));
    });
  }

  private boolean isSortedIntArray(int[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[i - 1]) {
        return false;
      }
    }
    return true;
  }
}