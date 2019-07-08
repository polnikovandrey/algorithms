package sort;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SortTest {

  private static final int[] intArray1 = {10, 2, 10, 3, 1, 2, 5};

  @Test
  public void bubbleSort() {
    final int[] intArray1 = SortUtils.createIntArray1();
    assertFalse(SortUtils.isSortedArray(intArray1));
    new BubbleSort().sort(intArray1);
    assertTrue(SortUtils.isSortedArray(intArray1));
  }
}