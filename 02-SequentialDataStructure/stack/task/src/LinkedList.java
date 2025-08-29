import java.util.NoSuchElementException;

public class LinkedList<E> extends AbstractList<E> {
    /* fields */
    ListNode<E> head;
    ListNode<E> tail;
    int size;

    /* methods */
    public LinkedList() {}

    public int size() { return this.size; }
    public boolean isEmpty() { return this.size == 0; }

    public void addFirst(E data) {
        ListNode<E> newNode;

        newNode = new ListNode<>();
        newNode.prev = null;
        newNode.data = data;
        newNode.next = this.head;

        this.head = newNode;

        if (this.size == 0)
            this.tail = newNode;

        this.size++;
    }

    public void addLast(E data) {
        ListNode<E> newNode;

        newNode = new ListNode<>();
        newNode.prev = this.tail;
        newNode.data = data;
        newNode.next = null;

        if (this.size == 0)
            this.head = newNode;
        else
            this.tail.next = newNode;

        this.tail = newNode;

        this.size++;
    }

    public E peekFirst() {
        return this.head.data;
    }

    public E peekLast() {
        return this.tail.data;
    }

    public E peek() {
        return peekFirst();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode<E> cur = this.head;

        while (cur != null) {
            sb.append(cur.data).append(" -> ");
            cur = cur.next;
        }

        sb.append("null");

        return sb.toString();
    }

    public boolean delete(int key) {
        ListNode<E> cur  = this.head;

        while (cur != null && !cur.data.equals(key)) {
            cur = cur.next;
        }

        if (cur != null) {             // If the node to be deleted is found,
            if (cur == this.head) {    // Case 1: Deleting the head node
                this.head = cur.next;
                cur.prev = null;
            }
            else                       // Case 2: Deleting the node elsewhere
                cur.prev.next = cur.next;

            if (cur.next == null)     // Update tail pointer if deleting the last node
                this.tail = cur.prev;

            cur.prev = null;
            cur.data = null;
            cur.next = null;
            this.size--;

            return true;  // Successfully delete
        }

        return false;     // The node to be deleted is not found
    }

    public E removeFirst() {
        ListNode<E> cur = this.head;

        if (cur == null)
            throw new NoSuchElementException();

        E data = cur.data;
        this.head = cur.next;
        size--;

        cur = this.head;

        if (cur != null)
            cur.prev = null;
        else
            this.tail = null;

        return data;
    }

    public E removeLast() {
        ListNode<E> cur = this.tail;

        if (cur == null)
            throw new NoSuchElementException();

        E data = cur.data;
        this.tail = cur.next;
        size--;

        cur = this.tail;

        if (cur != null)
            cur.next = null;
        else
            this.head = null;

        return data;
    }
}
