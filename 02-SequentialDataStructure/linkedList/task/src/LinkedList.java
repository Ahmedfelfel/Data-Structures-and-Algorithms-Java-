public class LinkedList<E> extends AbstractList<E> {
    /* fields */
    /* TODO: declare head and tail ListNode pointers, and an integer size  */
    ListNode<E> head;
    ListNode<E> tail;
    int size;
    /* methods */
    /* TODO: create an empty constructor */
    public LinkedList() {

    }

    public int size() { return this.size; }

    public void addFirst(E data) {
        /* TODO: implement the addFirst() which add a new node with data to the head of the list */
        ListNode<E> n = new ListNode<>();
        n.data= data;
        if(head == null)
        {
            head = n;
            tail = n;
        }
        else
        {
            n.next = head;
            head = n;
        }
        size++;

    }
    public String toString() {
        /* TODO: convert a list into a String */
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
        /* TODO: find the first occurrence and unlink it from the list */
        ListNode<E> cur = this.head;
        ListNode<E> prev = null;
        while (cur != null) {
            if (cur.data.equals(key)) {
                if (cur == head) {
                    head = cur.next;
                }
                else {
                    if (cur == tail) {
                        tail = prev;
                        prev.next = null;
                    }
                    else {
                        prev.next = cur.next;
                    }

                }
                size--;
                return true;
            }
            prev = cur;
            cur = cur.next;

        }
        return false;
    }

    /* inner classes */
    private static class ListNode<E> {
        /* Implement a ListNode here */
        E data;
        ListNode<E> next;
    }
}
