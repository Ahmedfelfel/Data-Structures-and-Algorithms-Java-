public abstract class AbstractList<E> {
    protected AbstractList() {}

    public abstract int size();
    public abstract boolean isEmpty();

    public abstract void addFirst(E data);
    public abstract void addLast(E data);
    public abstract boolean delete(int key);

    /* inner classes */
    protected static class ListNode<E> {
        ListNode<E> prev;
        E data;
        ListNode<E> next;

        ListNode() {}
    }
}