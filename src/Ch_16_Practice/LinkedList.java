package Ch_16_Practice;

//I know I could have used iterators here but I didn't want to write a list node iterator class...

public class LinkedList<E> {
    ListNode<E> front;

    LinkedList(ListNode<E> front) {
        this.front = front;
    }

    public ListNode<E> getIndex(int i) {
        ListNode<E> current = front;
        if (i < 0) {
            while (current.next != null) {
                current = current.next;
            }
        } else {
            int j = 0;
            while (j < i && current.next != null) {
                current = current.next;
                j++;
            }
            if (i != j) {
                throw new IndexOutOfBoundsException();
            }
        }

        return current;
    }

    public void addAll(int index, LinkedList<E> list) {
        ListNode<E> beforeSplice = getIndex(index);
        ListNode<E> afterSplice = beforeSplice.next;
        beforeSplice.next = list.front;
        getIndex(-1).next = afterSplice;
    }

    public boolean containsAll(LinkedList<E> list) {
        ListNode<E> key = list.front;
        boolean have;

        do {
            have = this.contains(key);
            key = key.next;
        } while (!have && key != null);

        return have;
    }

    public boolean contains(Object o) {
        ListNode<E> current = front;
        boolean have;

        do {
            have = current.data == o;
            current = current.next;
        } while (!have && current != null);

        return have;
    }


    public boolean equals(LinkedList<E> list) {
        ListNode<E> current = front;
        ListNode<E> other = list.front;
        boolean equal;

        do {
            equal = current.data == other.data;
            current = current.next;
            other = other.next;
        } while (equal && current.next != null);

        return equal;
    }

    public int lastIndexOf(Object o) {
        ListNode<E> current = front;
        int index = 0;
        int indexof = -1;


        do {
            if (current.data == o) {
                indexof = index;
            }
            current = current.next;
            index++;
        } while (current != null);

        return index;
    }


    public boolean remove(Object o) {
        ListNode<E> current = front;

        //edge case for an empty list
        if (current == null) {
            return false;
        }

        //edge case for removing the first element in the list
        //this also happens to work on a one element list
        if (current.data == o) {
            front = current.next;
            return true;
        }

        while (current.next != null) {
            if (current.next.data == o) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void removeAllOf(Object o) {
        ListNode<E> current = front;

        //edge case for an empty list
        if (current == null) {
            return;
        }

        //edge case for removing the first element in the list
        //this also happens to work on a one element list
        if (current.data == o) {
            front = current.next;
            return;
        }

        while (current.next != null) {
            if (current.next.data == o) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    public void removeAll(LinkedList<E> list) {
        ListNode<E> thingToRemove = list.front;

        do {
            this.removeAllOf(thingToRemove);
            thingToRemove = thingToRemove.next;
        } while (thingToRemove != null);
    }

    //I am kind of proud of this method because the hard copy propagates through all elements of the list
    public LinkedList<E> hardCopy() {
        return new LinkedList<E>(front.hardCopy());
    }

    //This one was the most challenging for me, but I think think I found a very elegant solution in the end!
    //This uses a sort of double negative approach to the problem. Without thinking about it too hard my gut instinct
    // is telling me this is as efficient as retaining all directly.
    public void retainAll(LinkedList<E> list) {
        LinkedList<E> toRemove = this.hardCopy();
        toRemove.removeAll(list);
        this.removeAll(toRemove);
    }

    public int size() {
        ListNode<E> current = front;
        int size = 0;

        while (current != null) {
            size++;
            current = current.next;
        }

        return size;
    }

    public Object[] toArray() {
        ListNode<E> current = front;

        Object[] array = new Object[this.size()];

        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = current.data;
            current = current.next;
        }

        return array;
    }
}
