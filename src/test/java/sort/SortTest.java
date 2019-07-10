package sort;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertFalse;
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
  public void selectionSort() {
    repeatSortExecution(new SelectionSort());
  }

  private void repeatSortExecution(HasIntArraySort sort) {
    IntStream.rangeClosed(0, 2).forEach(value -> {
      final int[] intArray = createIntArray();
      assertFalse(isSortedIntArray(intArray));
      sort.sortArray(intArray);
      assertTrue(isSortedIntArray(intArray));
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
    final int[] array = new int[random.nextInt(50)];
    for (int i = 0; i < array.length; i++) {
      array[i] = random.nextInt();
    }
    return array;
  }
}