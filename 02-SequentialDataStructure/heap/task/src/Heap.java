import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heap<E extends Comparable<E>> {
  private ArrayList<E> arr;
  private int size;
  private int capacity;

  public Heap(int capacity) {
      /* TODO: initialize all fields in the class and allocate arr[] upto the capacity */
      this.capacity = capacity;
      size=0;
      this.arr = new ArrayList<>(this.capacity);
  }

  public void push(E data) {
      /* TODO: implement the sift up algorithm here */
      if (size == capacity) {
          enlarge();
      }
      arr.add(data);
      size++;
      int idx = size-1;
      while (idx > 0 && arr.get(parent(idx)).compareTo(arr.get(idx)) > 0) {
          E temp = arr.get(parent(idx));
          arr.set(parent(idx), arr.get(idx));
          arr.set(idx, temp);
          idx=parent(idx);
      }

  }

  public E peek() {
      /* TODO: return the top element of the heap */
      if (size == 0) {
          throw new NoSuchElementException("The heap is empty.");
      }
      return arr.get(0);
  }

  public void pop() {
      /* TODO: implement popping using sift down algorithm, which should remove the top of the heap and re-arrange nodes */
      if (size == 0) {
          throw new NoSuchElementException("The heap is empty.");
      }
      E temp = arr.get(0);
      arr.set(0, arr.get(size-1));
      arr.remove(size-1);
      size--;
      int idx = 0;
      while (idx < size) {
          int left = left(idx);
          int right = right(idx);
          int smallest = idx;
          if (left < size && arr.get(left).compareTo(arr.get(smallest)) < 0) {
              smallest = left;
          }
          if (right < size && arr.get(right).compareTo(arr.get(smallest)) < 0) {
              smallest = right;
          }
          if (smallest == idx) {
              break;
          }
          E temp2 = arr.get(smallest);
          arr.set(smallest, arr.get(idx));
          arr.set(idx, temp2);
          idx = smallest;
      }
  }

  private int parent(int idx) {
      return (idx - 1) / 2;
  }

  private int left(int idx) {
      return idx * 2 + 1;
  }

  private int right(int idx) {
      return idx * 2 + 2;
  }

  private void enlarge() {
      /* TODO: implement positioning calculation */
      int newCapacity = this.capacity * 2;
      ArrayList<E> newArr = new ArrayList<>(newCapacity);
      for (int i = 0; i < this.capacity; i++) {
          newArr.add(this.arr.get(i));
      }
      this.capacity = newCapacity;
      this.arr = newArr;
  }
}