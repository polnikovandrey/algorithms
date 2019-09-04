package structures.hashtable;

import java.util.stream.IntStream;

/**
 * Double hashing implementation.
 * @link why prime number should be used as the array size and inside hashing function http://aliev.me/runestone/SortSearch/Hashing.html
 */
public class HashTable {

  /**
   * Slots
   */
  private final String[] array;

  /**
   * Count of existing elements
   */
  private int elementsCount;

  /**
   * @param size number of slots. Must be prime to ensure all indexes are traversed by probing (stepping).
   */
  public HashTable(int size) {
    final int correctSize = isPrimeNumber(size) ? size : calculateNextPrimeNumber(size);
    this.array = new String[correctSize];
  }

  public void insert(String value) {
    final int stepSize = secondaryHash(value);
    int index = primaryHash(value);
    if (array[index] != null) {
      index = (index + stepSize) % array.length;
    }
    array[index] = value;
    elementsCount++;
  }

  public String find(String value) {
    final int stepSize = secondaryHash(value);
    int index = primaryHash(value);
    while(array[index] != null) {
      if (value.equals(array[index])) {
        return array[index];
      }
      index = (index + stepSize) % array.length;
    }
    return null;
  }

  private boolean isPrimeNumber(int number) {
    final int bound = Double.valueOf(Math.sqrt(number)).intValue();
    return IntStream.range(2, bound).noneMatch(i -> number % i == 0);
  }

  private int calculateNextPrimeNumber(int number) {
    Integer result = null;
    while (result == null) {
      if (isPrimeNumber(++number)) {
        result = number;
      }
    }
    return result;
  }

  /**
   * @return desired slot index
   */
  private int primaryHash(String value) {
    final int nativeHashCode = value.hashCode();
    final int valueHash = nativeHashCode % array.length;
    return valueHash < 0 ? valueHash + array.length : valueHash;
  }

  /**
   * @return step size in case of a collision (desired slot contains value already)
   */
  private int secondaryHash(String value) {
    final int primaryHash = primaryHash(value);
    return primaryHash == 0 ? 3 : (3 - 3 % primaryHash);   // 3 - must be a prime number lesser then array.length
  }
}
