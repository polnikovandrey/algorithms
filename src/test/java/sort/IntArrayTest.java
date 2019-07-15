package sort;

import java.util.Random;

public interface IntArrayTest {

  default int[] createIntArray(int arrayLengthBottomBound, int arrayLengthTopBound, int valueBound) {
    final Random random = new Random();
    final int[] array = new int[arrayLengthBottomBound + random.nextInt(arrayLengthTopBound)];
    for (int i = 0; i < array.length; i++) {
      array[i] = random.nextInt(valueBound);
    }
    return array;
  }
}
