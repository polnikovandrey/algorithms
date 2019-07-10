package sort;

public class StupidSort extends HasIntArraySort {

  @Override
  public void sortArray(int[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[i - 1]) {
        swapArrayElements(array, i, i - 1);
        i = 0;
      }
    }
  }
}
