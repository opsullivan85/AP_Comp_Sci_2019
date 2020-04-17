package Ch_16_Practice;

public class ListNode<E> {
    Object data;
    ListNode<E> next;

    public ListNode(Object data, ListNode<E> next) {
        this.data = data;
        this.next = next;
    }

    public ListNode<E> hardCopy() {
        if (next == null) {
            return new ListNode<E>(this.data, next);
        } else {
            return new ListNode<E>(this.data, next.hardCopy());
        }
    }
}
