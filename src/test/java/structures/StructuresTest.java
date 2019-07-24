package structures;

import sort.IntArrayTest;

import org.junit.Test;

import java.util.Random;

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
    while(!stack.isFull()) {
      final int value = random.nextInt();
      stack.push(value);
      testArray[stack.size()] = value;
      assertFalse(stack.isEmpty());
    }
    while(!stack.isEmpty()) {
      final int peek = stack.peek();
      assertEquals(peek, testArray[stack.size()]);
      final int pop = stack.pop();
      assertEquals(pop, testArray[stack.size() + 1]);
    }
  }
}
