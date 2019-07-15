package search;

import java.util.Arrays;

public class LinearSearch implements IntArraySearch {


  @Override
  public int searchForValueIdx(int[] array, int value) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException("Not valid array: " + Arrays.toString(array));
    }
    for (int i = 0; i < array.length; i++) {
      if (array[i] == value) {
        return i;
      }
    }
    return -1;
  }
}
