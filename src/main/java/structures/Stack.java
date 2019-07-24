package structures;

@SuppressWarnings("WeakerAccess")
public class Stack {

  private final int[] array;
  private int top;

  public Stack(int size) {
    this.array = new int[size];
    this.top = -1;
  }

  public final void push(int value) {
    if (isFull()) {
      throw new IllegalStateException("Stack is full!");
    } else {
      array[++top] = value;
    }
  }

  public final int pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty!");
    } else {
      return array[top--];
    }
  }

  public final int peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty!");
    } else {
      return array[top];
    }
  }

  public final boolean isEmpty() {
    return top == -1;
  }

  public final boolean isFull() {
    return top == array.length - 1;
  }

  public final int size() {
    return top;
  }
}
