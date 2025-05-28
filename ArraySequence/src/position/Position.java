package position;

public class Position<T> {
    private int index;
    private T element;

    public Position(int index, T element) {
        this.index = index;
        this.element = element;
    }

    public int getIndex() {
        return index;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
