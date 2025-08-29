public class Stack<E> extends LinkedList<E> {
    public Stack() {
        super();
    }

    public void push(E data) {
        addFirst(data);
    }

    public E pop() {
        return removeFirst();
    }

    public E peek() {
        return super.peek();
    }
}