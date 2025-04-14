public interface BinaryTree<T> extends Iterable<T> {
    Position<T> root();
    Position<T> parent(Position<T> p) throws IllegalArgumentException;
    Position<T> left(Position<T> p) throws IllegalArgumentException;
    Position<T> right(Position<T> p) throws IllegalArgumentException;
    int size();
    boolean isEmpty();
    Iterator<T> iterator();
    Iterable<Position<T>> positions();
}