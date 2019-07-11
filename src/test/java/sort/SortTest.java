package sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

public class SortTest {

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

  @Test
  public void quickSort() {
    // TODO
  }

  private void repeatSortExecution(HasIntArraySort sort) {
    IntStream.rangeClosed(0, 2).forEach(value -> {
      int[] intArray = createIntArray();
      while (isSortedIntArray(intArray)) {
        intArray = createIntArray();
      }
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

  private int[] createIntArray() {
    final Random random = new Random();
    final int[] array = new int[random.nextInt(100)];
    for (int i = 0; i < array.length; i++) {
      array[i] = random.nextInt(100);
    }
    return array;
  }
}