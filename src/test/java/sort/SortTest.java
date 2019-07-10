package sort;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SortTest {

  @Test
  public void stupidSort() {
    final int[] intArray = createIntArray();
    assertFalse(isSortedIntArray(intArray));
    new StupidSort().sortArray(intArray);
    assertTrue(isSortedIntArray(intArray));
  }

  @Test
  public void bubbleSort() {
    final int[] intArray = createIntArray();
    assertFalse(isSortedIntArray(intArray));
    new BubbleSort().sortArray(intArray);
    assertTrue(isSortedIntArray(intArray));
  }

  @Test
  public void selectionSort() {
    final int[] intArray = createIntArray();
    assertFalse(isSortedIntArray(intArray));
    new SelectionSort().sortArray(intArray);
    assertTrue(isSortedIntArray(intArray));
  }

  private boolean isSortedIntArray(int[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[i - 1]) {
        return false;
      }
    }
    return true;
  }

  private static int[] createIntArray() {
    return new int[] {10, 2, 10, 3, 1, 2, 5};
  }
}