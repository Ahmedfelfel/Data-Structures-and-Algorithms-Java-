public abstract class AbstractList<E> {
    protected AbstractList() {}

    public abstract int size();

    public boolean isEmpty() {
        return size() == 0;
    }
}