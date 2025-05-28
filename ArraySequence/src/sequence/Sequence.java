package sequence;

import position.Position;

@SuppressWarnings("unchecked")
public class Sequence<T> {
    private Position<T>[] list;
    private int n;

    public Sequence() {
        list = (Position<T>[]) new Position<?>[10];
        n = 0;
    }

    public Position<T> first() {
        return isEmpty() ? null : list[0];
    }

    public Position<T> last() {
        return isEmpty() ? null : list[n - 1];
    }

    public Position<T> before(Position<T> p) {
        int i = p.getIndex();
        if (i <= 0 || i >= n) throw new IllegalStateException("No element before.");
        return list[i - 1];
    }

    public Position<T> after(Position<T> p) {
        int i = p.getIndex();
        if (i < 0 || i >= n - 1) throw new IllegalStateException("No element after.");
        return list[i + 1];
    }

    public Position<T> get(int i) {
        if (!validate(i)) throw new IllegalStateException("Invalid index.");
        return list[i];
    }

    public void add(int i, T e) {
        if (i < 0 || i > n) throw new IllegalStateException("Invalid index.");
        if (n == list.length) resize();
        for (int j = n - 1; j >= i; j--) {
            list[j + 1] = list[j];
            list[j + 1].setIndex(j + 1);
        }
        list[i] = new Position<>(i, e);
        n++;
    }

    public T set(int i, T e) {
        if (!validate(i)) throw new IllegalStateException("Invalid index.");
        T old = list[i].getElement();
        list[i].setElement(e);
        return old;
    }

    public T remove(int i) {
        if (!validate(i)) throw new IllegalStateException("Invalid index.");
        T removed = list[i].getElement();
        for (int j = i; j < n - 1; j++) {
            list[j] = list[j + 1];
            list[j].setIndex(j); // update index
        }
        list[n - 1] = null;
        n--;
        return removed;
    }

    public Position<T> addFirst(T e) {
        add(0, e);
        return list[0];
    }

    public Position<T> addLast(T e) {
        add(n, e);
        return list[n - 1];
    }

    public Position<T> addBefore(Position<T> p, T e) {
        return addAt(p.getIndex(), e);
    }

    public Position<T> addAfter(Position<T> p, T e) {
        return addAt(p.getIndex() + 1, e);
    }

    private Position<T> addAt(int index, T e) {
        add(index, e);
        return list[index];
    }

    public T set(Position<T> p, T e) {
        return set(p.getIndex(), e);
    }

    public T remove(Position<T> p) {
        return remove(p.getIndex());
    }

    private boolean validate(int i) {
        return i >= 0 && i < n;
    }

    private void resize() {
        Position<T>[] newArray = (Position<T>[]) new Position<?>[list.length * 2];
        for (int i = 0; i < n; i++) {
            newArray[i] = list[i];
        }
        list = newArray;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(list[i].getElement());
            if (i < n - 1) result.append(" --> ");
        }
        return result.toString();
    }
}
