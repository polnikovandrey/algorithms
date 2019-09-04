package structures;

import sort.IntArrayTest;
import structures.binarySearchTree.BinarySearchTree;
import structures.hashtable.HashTable;
import structures.heap.Heap;
import structures.linkedList.CircularLinkedList;
import structures.linkedList.LinkedList;
import structures.linkedList.SinglyLinkedList;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StructuresTest implements IntArrayTest {

  @Test
  public void stackTest() {
    final Random random = new Random();
    final int size = 10;
    final int[] testArray = new int[size];
    final Stack stack = new Stack(size);
    assertTrue(stack.isEmpty());
    assertFalse(stack.isFull());
    while (!stack.isFull()) {
      final int value = random.nextInt();
      stack.push(value);
      testArray[stack.size()] = value;
      assertFalse(stack.isEmpty());
    }
    while (!stack.isEmpty()) {
      final int peek = stack.peek();
      assertEquals(peek, testArray[stack.size()]);
      final int pop = stack.pop();
      assertEquals(pop, testArray[stack.size() + 1]);
    }
  }

  @Test
  public void reverseStringWithStack() {
    final String toReverse = "Hello, world!";
    final char[] chars = toReverse.toCharArray();
    final Stack stack = new Stack(chars.length);
    for (char c : chars) {
      stack.push(c);
    }
    final char[] reversedArray = new char[chars.length];
    int i = 0;
    while (!stack.isEmpty()) {
      reversedArray[i++] = (char) stack.pop();
    }
    final String reversed = new String(reversedArray);
    //noinspection SpellCheckingInspection
    assertEquals(reversed, "!dlrow ,olleH");
  }

  @Test
  public void reverseStringWithStack1() {
    final String toReverse = "Hello, world!";
    final Stack stack = new Stack(toReverse.length());
    for (int i = 0; i < toReverse.length(); i++) {
      stack.push(toReverse.charAt(i));
    }
    StringBuilder reversed = new StringBuilder();
    while (!stack.isEmpty()) {
      reversed.append((char) stack.pop());
    }
    //noinspection SpellCheckingInspection
    assertEquals(reversed.toString(), "!dlrow ,olleH");
  }

  @Test
  public void queueTest() {
    final Random random = new Random();
    final int queueSize = 10;
    final Queue queue = new Queue(queueSize);
    assertTrue(queue.isEmpty());
    assertFalse(queue.isFull());
    IntStream.range(0, 10).forEach(i -> {
      queue.enqueue(random.nextInt());
      assertFalse(queue.isEmpty());
    });
    assertTrue(queue.isFull());
    IntStream.range(0, 10).forEach(i -> queue.dequeue());
    assertFalse(queue.isFull());
    assertTrue(queue.isEmpty());

  }

  @Test
  public void singlyLinkedListTestSize() {
    final int nodesCount = 10;
    final Random random = new Random();
    final LinkedList list = new SinglyLinkedList();
    IntStream.range(0, nodesCount).forEach(i -> list.insertFirst(random.nextInt()));
    assertEquals(list.getSize(), nodesCount);
    while (!list.isEmpty()) {
      list.removeFirst();
    }
    assertTrue(list.isEmpty());
  }

  @Test
  public void circularLinkedListTestSize() {
    final int nodesCount = 10;
    final Random random = new Random();
    final LinkedList list = new CircularLinkedList();
    IntStream.range(0, nodesCount).forEach(i -> list.insertFirst(random.nextInt()));
    assertEquals(list.getSize(), nodesCount);
    while (!list.isEmpty()) {
      list.removeFirst();
    }
    assertTrue(list.isEmpty());
  }

  @Test
  public void doubleLinkedListTest() {
    // TODO test DoubleLinkedList
  }

  @Test
  public void binarySearchTreeTest() {
    final int repeats = 100;
    final int size = 100;
    IntStream.range(0, repeats).forEach(i -> {
      final Integer[] temp = new Integer[size];
      final BinarySearchTree tree = new BinarySearchTree();
      final Random random = new Random();
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int j : IntStream.range(0, size).toArray()) {
        final int value = random.nextInt(100);
        temp[j] = value;
        tree.insert(value);
        if (value > max) {
          max = value;
        }
        if (value < min) {
          min = value;
        }
      }
      final int foundMin = tree.getMin(null).getValue();
      final int foundMax = tree.getMax(null).getValue();
      assertEquals(min, foundMin);
      assertEquals(max, foundMax);
      final List<Integer> values = Arrays.asList(temp);
      Collections.shuffle(values);
      for (int value : values) {
        tree.delete(value);
        assertTrue(tree.isBinarySearchTree());
      }
      assertTrue(tree.isEmpty());
    });
  }

  @Test
  public void heapTest() {
    final int repeats = 100;
    final int size = 100;
    final Random random = new Random();
    IntStream.range(0, repeats).forEach(i -> {
      final Heap heap = new Heap(size);
      final int currentSize = random.nextInt(100);
      IntStream.range(0, currentSize).forEach(j -> {
        heap.insert(random.nextInt(100));
        assertTrue(heap.isValidHeap());
        assertFalse(heap.isEmpty());
      });
      while (!heap.isEmpty()) {
        heap.remove();
        assertTrue(heap.isValidHeap());
      }
      assertTrue(heap.isEmpty());
    });
  }

  @Test
  public void hashTableTest() {
    final int repeats = 100;
    final int size = 100;
    final Random random = new Random();
    IntStream.range(0, repeats).forEach(i -> {
      final HashTable hashTable = new HashTable(size);
      final int currentSize = random.nextInt(100);
      IntStream.range(0, currentSize).forEach(j -> {
        final byte[] array = new byte[10]; // length is bounded by 7
        random.nextBytes(array);
        final String randomString = new String(array, StandardCharsets.UTF_8);
        hashTable.insert(randomString);
        assertEquals(randomString, hashTable.find(randomString));
      });
    });
  }
}
