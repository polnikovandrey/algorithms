package sort;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SortTest {

  @Test
  public void bubbleSort() {
    final int[] intArray1 = SortUtils.createIntArray1();
    assertFalse(SortUtils.isSortedArray(intArray1));
    new BubbleSort().sortArray(intArray1);
    assertTrue(SortUtils.isSortedArray(intArray1));
  }

  @Test
  public void selectionSort() {
    final int[] intArray1 = SortUtils.createIntArray1();
    assertFalse(SortUtils.isSortedArray(intArray1));
    new SelectionSort().sortArray(intArray1);
    assertTrue(SortUtils.isSortedArray(intArray1));
  }
}