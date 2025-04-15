public class TreeNode<T> implements Position<T>{
    private T element;
    private TreeNode<T> parent;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T element,TreeNode<T> parent){
        this.element = element;
        this.parent = parent;
    }

    public TreeNode(T element, TreeNode<T> parent, TreeNode<T> right, TreeNode<T> left){
        this.element = element;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    @Override
    public T getElement(){
        return this.element
    }

    // Accessors
    public TreeNode<T> getParent() { return parent; }
    public TreeNode<T> getLeft() { return left; }
    public TreeNode<T> getRight() { return right; }

    // Mutators
    public void setElement(T element) { this.element = element; }
    public void setParent(TreeNode<T> parent) { this.parent = parent; }
    public void setLeft(TreeNode<T> left) { this.left = left; }
    public void setRight(TreeNode<T> right) { this.right = right; }
}