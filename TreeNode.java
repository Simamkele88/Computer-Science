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

    public TreeNode<T> getParent(){
        return this.parent;
    }

    public void setParent(TreeNode<T> parent){
        this.parent = parent;
    }

    public TreeNode<T> getLeft(){
        return this.left;
    }

    public void setLeft(TreeNode<T> node){
        this.left = node;
    }

    public TreeNode<T> getRight(){
        return this.right;
    }

    public void setRight(TreeNode<T> node){
        this.right = node;
    }
}