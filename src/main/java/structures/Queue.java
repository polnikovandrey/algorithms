package structures;

@SuppressWarnings( {"WeakerAccess", "UnusedReturnValue"})
public class Queue {

  private final int[] array;

  private int front;
  private int rear;
  private int size;

  public Queue(int arraySize) {
    this.array = new int[arraySize];
    this.front = 0;
    this.rear = -1;
    this.size = 0;
  }

  public void enqueue(int value) {
    if (isFull()) {
      throw new IllegalStateException("Queue is full!");
    }
    rear++;
    if (rear > array.length - 1) {
       rear = 0;
    }
    array[rear] = value;
    size++;
  }

  public int dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue is empty!");
    }
    final int value = array[front];
    front++;
    if (front > array.length - 1) {
      front = 0;
    }
    size--;
    return value;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == array.length;
  }
}
