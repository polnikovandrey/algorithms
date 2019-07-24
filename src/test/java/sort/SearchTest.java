package sort;

import search.BinaryIterativeSearch;
import search.BinaryRecursiveSearch;
import search.IntArraySearch;
import search.LinearSearch;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchTest implements IntArrayTest {

  private static final int VALUE_BOUND = 1000;

  @Test
  public void linearSearch() {
    repeatSearchExecution(new LinearSearch());
  }

  @Test
  public void binarySearch() {
    repeatSearchExecution(new BinaryIterativeSearch());
    repeatSearchExecution(new BinaryRecursiveSearch());
  }

  private void repeatSearchExecution(IntArraySearch search) {
    IntStream.rangeClosed(0, 1000).forEach(iter -> {
      final int[] intArray = createIntArray(5, 1000, VALUE_BOUND);
      final int valueToSearch = new Random().nextInt(VALUE_BOUND);
      final int idx = search.searchForValueIdx(intArray, valueToSearch);
      if (idx < 0) {
        assertTrue(search.getClass().getSimpleName() + ": error: " + Arrays.toString(intArray) + " for value=" + valueToSearch + ". Has value, but not found.",
                Arrays.stream(intArray).noneMatch(value -> value == valueToSearch));
      } else {
        assertEquals(search.getClass().getSimpleName() + ": error: " + Arrays.toString(intArray) + " for value = " + valueToSearch + ". Wrong value for idx = " + idx + ".",
                intArray[idx], valueToSearch);
      }
    });
  }
}
