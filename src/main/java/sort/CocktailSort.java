package sort;

public class CocktailSort extends HasIntArraySort {

  @Override
  public void sortArray(int[] array) {
    int start = 0;
    int end = array.length;
    boolean needIteration = true;
    while (needIteration) {
      needIteration = false;
      for (int i = start; i < end - 1; i++) {
        if (array[i] > array[i + 1]) {
          swapArrayElements(array, i, i + 1);
          needIteration = true;
        }
      }
      if (needIteration) {
        end--;
        needIteration = false;
        for (int i = end - 1; i >= start; i--) {
          if (array[i] > array[i + 1]) {
            swapArrayElements(array, i, i + 1);
            needIteration = true;
          }
        }
      }
      if (needIteration) {
        start++;
      }
    }
  }
}
