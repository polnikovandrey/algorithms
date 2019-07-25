package structures;

import sort.IntArrayTest;

import org.junit.Test;

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
}
