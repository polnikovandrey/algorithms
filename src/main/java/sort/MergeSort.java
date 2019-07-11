package sort;

class MergeSort extends HasIntArraySort {

  @Override
  void sortArray(int[] array) {
    sortSubArray(array, 0, array.length - 1);
  }

  private void sortSubArray(int[] subArray, int startIdx, int endIdx) {
    if (startIdx < endIdx) {
      final int middleIdx = (startIdx + endIdx) / 2;
      sortSubArray(subArray, startIdx, middleIdx);
      sortSubArray(subArray, middleIdx + 1, endIdx);
      mergeSubArrays(subArray, startIdx, middleIdx, endIdx);
    }
  }

  private void mergeSubArrays(int[] subArray, int startIdx, int middleIdx, int endIdx) {
    final int leftSubArraySize = middleIdx - startIdx + 1;
    final int rightSubArraySize = endIdx - middleIdx;
    final int[] leftSubArray = new int[leftSubArraySize];
    final int[] rightSubArray = new int[rightSubArraySize];
    System.arraycopy(subArray, startIdx, leftSubArray, 0, leftSubArraySize);
    System.arraycopy(subArray, middleIdx + 1, rightSubArray, 0, rightSubArraySize);

    int leftSubArrayIdx = 0;
    int rightSubArrayIdx = 0;
    int mergedSubArrayIdx = startIdx;
    while (leftSubArrayIdx < leftSubArraySize && rightSubArrayIdx < rightSubArraySize) {
      if (leftSubArray[leftSubArrayIdx] <= rightSubArray[rightSubArrayIdx]) {
        subArray[mergedSubArrayIdx] = leftSubArray[leftSubArrayIdx];
        leftSubArrayIdx++;
      } else {
        subArray[mergedSubArrayIdx] = rightSubArray[rightSubArrayIdx];
        rightSubArrayIdx++;
      }
      mergedSubArrayIdx++;
    }
    while (leftSubArrayIdx < leftSubArraySize) {
      subArray[mergedSubArrayIdx] = leftSubArray[leftSubArrayIdx];
      leftSubArrayIdx++;
      mergedSubArrayIdx++;
    }
    while (rightSubArrayIdx < rightSubArraySize) {
      subArray[mergedSubArrayIdx] = rightSubArray[rightSubArrayIdx];
      rightSubArrayIdx++;
      mergedSubArrayIdx++;
    }
  }
}
