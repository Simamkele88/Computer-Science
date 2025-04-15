import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Tree<T> implements Iterable<T>{
    private TreeNode<T> root;
    private int size;

    public Tree(){
        root = new TreeNode<>(null,null);
    }

    public Tree(T rootElement) {
        this.root = new TreeNode<>(rootElement, null);
        size = 1;
    }

    // Validation method
    private TreeNode<T> validate(Position<T> p) throws IllegalArgumentException {
        if (!(p instanceof TreeNode)) {
            throw new IllegalArgumentException("Invalid position type");
        }
        TreeNode<T> node = (TreeNode<T>) p;
        if (node.getParent() == node) { // Convention for defunct node
            throw new IllegalArgumentException("Position is no longer in the tree");
        }
        return node;
    }

    // Core accessors
    @Override
    public Position<T> root() {
        if (isEmpty()) throw new IllegalStateException("Tree is empty");
        return root;
    }

    public Position<T> parent(Position<T> p) throws IllegalArgumentException {
        TreeNode<T> node = validate(p);
        return node.getParent();
    }

    public Position<T> left(Position<T> p) throws IllegalArgumentException {
        TreeNode<T> node = validate(p);
        return node.getLeft();
    }

    public Position<T> right(Position<T> p) throws IllegalArgumentException {
        TreeNode<T> node = validate(p);
        return node.getRight();
    }

    // Query methods
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public boolean isInternal(Position<T> p) throws IllegalArgumentException {
        TreeNode<T> node = validate(p);
        return node.getLeft() != null || node.getRight() != null;
    }

    public boolean isExternal(Position<T> p) throws IllegalArgumentException {
        return !isInternal(p);
    }

    public boolean isRoot(Position<T> p) throws IllegalArgumentException {
        validate(p);
        return p == root();
    }

    // Update methods
    public Position<T> addRoot(T e) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree already has a root");
        root = new TreeNode<>(e, null);
        size = 1;
        return root;
    }

    public Position<T> insertLeft(Position<T> p, T e) throws IllegalArgumentException {
        TreeNode<T> parent = validate(p);
        if (parent.getLeft() != null) {
            throw new IllegalArgumentException("Node already has a left child");
        }
        TreeNode<T> child = new TreeNode<>(e, parent);
        parent.setLeft(child);
        size++;
        return child;
    }

    public Position<T> insertRight(Position<T> p, T e) throws IllegalArgumentException {
        TreeNode<T> parent = validate(p);
        if (parent.getRight() != null) {
            throw new IllegalArgumentException("Node already has a right child");
        }
        TreeNode<T> child = new TreeNode<>(e, parent);
        parent.setRight(child);
        size++;
        return child;
    }

    public T remove(Position<T> p) throws IllegalArgumentException {
        TreeNode<T> node = validate(p);
        if (node.getLeft() != null && node.getRight() != null) {
            throw new IllegalArgumentException("Cannot remove node with two children");
        }
        
        TreeNode<T> child = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        
        if (child != null) {
            child.setParent(node.getParent());
        }
        
        if (node == root) {
            root = child;
        } else {
            TreeNode<T> parent = node.getParent();
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
        
        size--;
        T temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node); 
        return temp;
    }

    // Traversal methods
    public Iterable<Position<T>> positions() {
        return this::inOrderIterator;
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementIterator(inOrderIterator());
    }

    private Iterator<Position<T>> inOrderIterator() {
        return new InOrderPositionIterator();
    }

    // Iterator implementations
    private class ElementIterator implements Iterator<T> {
        private final Iterator<Position<T>> posIterator;
        
        public ElementIterator(Iterator<Position<T>> positionIterator) {
            this.posIterator = positionIterator;
        }
        
        @Override
        public boolean hasNext() { return posIterator.hasNext(); }
        
        @Override
        public T next() { return posIterator.next().getElement(); }
    }

    private class InOrderPositionIterator implements Iterator<Position<T>> {
        private final Stack<TreeNode<T>> stack = new Stack<>();
        
        public InOrderPositionIterator() {
            pushLeft(root);
        }
        
        private void pushLeft(TreeNode<T> node) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
        }
        
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        
        @Override
        public Position<T> next() {
            if (!hasNext()) throw new NoSuchElementException();
            TreeNode<T> node = stack.pop();
            pushLeft(node.getRight());
            return node;
        }
    }

    // Utility methods
    public Position<T> sibling(Position<T> p) throws IllegalArgumentException {
        TreeNode<T> node = validate(p);
        TreeNode<T> parent = node.getParent();
        if (parent == null) return null;
        return (node == parent.getLeft()) ? parent.getRight() : parent.getLeft();
    }

    public int depth(Position<T> p) throws IllegalArgumentException {
        validate(p);
        if (isRoot(p)) return 0;
        return 1 + depth(parent(p));
    }

    public int height(Position<T> p) throws IllegalArgumentException {
        TreeNode<T> node = validate(p);
        if (isExternal(p)) return 0;
        int h = 0;
        if (node.getLeft() != null) {
            h = Math.max(h, height(node.getLeft()));
        }
        if (node.getRight() != null) {
            h = Math.max(h, height(node.getRight()));
        }
        return 1 + h;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this) {
            sb.append(element).append(" ");
        }
        return sb.toString().trim();
    }
}