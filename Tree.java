import java.util.Iterator;

public class Tree<T> implements BinaryTree<T>{
    private TreeNode<T> root;
    private int size;

    public Tree(){
        root = new TreeNode<>(null,null);
    }

    public Tree(T element){
        this.root = new TreeNode<>(element,null);
    }

    @Override
    public Position<T> root(){
        return this.root;
    }

    private TreeNode<T> validate(Position<T> p){
        if(!(p instanceof TreeNode<T>))
          throw new IllegalArgumentException("Invalid position.")

        return (TreeNode<T>) p;
    }

    @Override
    public Position<T> parent(Position<T> p) throws IllegalArgumentException{
        TreeNode<T> node = validate(p);
        return (Position<T>) node.getParent();
    }

    @Override
    public Position<T> left(Positio<T> p) throws IllegalArgumentException{
        TreeNode<T> node = validate(p);
        return (Position<T>) node.getLeft();
    }

    @Override
    public Position<T> right(Positio<T> p)throws IllegalArgumentException{
        TreeNode<T> node = validate(p);
        return (Position<T>) node.getRight();
    }

    @Override
    public Position<T> left(Positio<T> p){
        TreeNode<T> node = validate(p);
        return (Position<T>) node.getLeft();
    }

    public Position<T> sibling(Position<T> p){
        TreeNode<T> node = validate(p);
        TreeNode<T> parent = node.getParent();

        if(isRight(node))
          return parent.getRight();
        else
          return parent.getLeft();
    }

    private boolean isRight(Position<T> p){
        TreeNode<T> node = validate(p);
        TreeNode<t> parent = node.getParent();
        return node == parent.getRight();
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int size(){
        return this.size;
    }

    public boolean isExternal(Position<T> p){
        TreeNode<T> node = validate(p);
        return node.getLeft() == null && node.getRight() == null;
    }

    public boolean isInternal(Position<T> p){
        TreeNode<T> node = validate(p);
        return node.getLeft() != nulll || node.getRight() != null;
    }

    public boolean isRoot(Position<T> p){
        TreeNode<T> node = validate(p);
        return node == root;
    }

    public Position<T> addRoot(T element){
        root = new TreeNode<>(element,null);
    }

    public Position<T> insertLeft(Position<T> p, T element){
        TreeNode<T> node = validate(p);
        
        if(node.getLeft() != null)
          throw new IllegalArgumentException("The specified node already has a left child.")

        TreeNode<T> child = new TreeNode<>(element,node);
        node.setLeft(child);
        return child;
    }

    public Position<T> insertRight(Position<T> p, T element){
        TreeNode<T> node = validate(p);
        
        if(node.getRight() != null)
          throw new IllegalArgumentException("The specified node already has a left child.")

        TreeNode<T> child = new TreeNode<>(element,node);
        node.setLeft(child);
        return child;
    }

    public T remove(Position<T> p){
        TreeNode<T> removed = validate;

        if(node.getRight() != null and node.getLeft() != null)
          throw new IllegalArgumentException("Cannot remove a node with one or more children.")

        TreeNode<T> parent = removed.getParent();

        if(isRight(p))
          parent.setRight(null);
        else
          parent.setLeft(null);

        T element = removed.getElement();
        removed.setParent(null);
        removed.element = null;

        return element;
    }

    private class TreeIterator<Position<T>> implements Iterator<T>{
        private int cursor
    }
}