package Ch_16_Practice;

public class ListNode<E> {
    E data;
    ListNode<E> next;

    public ListNode(E data, ListNode<E> next) {
        this.data = data;
        this.next = next;
    }

    public ListNode<E> hardCopy() {
        if (next == null) {
            return new ListNode<E>(this.data, null);
        } else {
            return new ListNode<E>(this.data, next.hardCopy());
        }
    }
}
