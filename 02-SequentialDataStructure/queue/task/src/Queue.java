public class Queue<E> extends LinkedList<E> {
    public Queue() {
        super();
    }

    public void enqueue(E data) {
        /* TODO: should add the data to the rear of the queue */
        super.addLast(data);
    }

    public E dequeue() {
        /* TODO: should remove the front of the queue */
        return super.removeFirst();
    }

    public E peek() {
        /* TODO: should get the front of the queue */
        return super.peekFirst();
    }
}