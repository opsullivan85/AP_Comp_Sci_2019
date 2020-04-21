package Ch_15_Practice;

public class ArrayList<E> {
    private Object[] list;

    private void change_size(int delta) {
        //Do something
    }

    private int size() {
        return this.list.length;
    }

    public Object get(int i) {
        return list[i];
    }

    public void addAll(int index, ArrayList<E> list) {
        this.change_size(list.size());

        for (int i = index; i < this.size(); i++) {
            this.list[i + list.size()] = this.list[i];
            this.list[i] = list.get(index - i);
        }
    }

    public boolean containsAll(ArrayList<E> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (!this.contains(list.get(i)))
                return false;
        }
        return true;
    }

    public boolean contains(Object o) {
        for (Object p : this.list) {
            if (o.equals(p))
                return true;
        }
        return false;
    }

    public boolean equals(ArrayList<E> list) {
        for (int i = this.size(); i >= 0; i--) {
            if (!list.get(i).equals(this.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int lastIndexOf(Object o) {
        for (int i = this.size(); i >= 0; i--) {
            if (this.list[i].equals(o))
                return i;
        }
        return -1;
    }

    public boolean remove(Object o) {
        int index = -1;

        if (this.contains(o)) {
            index = this.lastIndexOf(o);
        } else {
            return false;
        }

        if (this.size() - index + 1 >= 0)
            System.arraycopy(this.list, index + 1, this.list, index + 1 - 1, this.size() - index + 1);

        this.change_size(-1);

        return true;
    }

    public void removeAll(ArrayList<E> list) {
        for (int i = list.size(); i >= 0; i--) {
            this.remove(list.get(i));
        }
    }

    public void retainAll(ArrayList<E> list) {
        for (int i = list.size(); i >= 0; i--) {
            if (!this.contains(list.get(i))) {
                this.remove(list.get(i));
            }
        }
    }

    public Object[] toArray() {
        return this.list;
    }
}
