package node;

import position.Position;
import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> implements Position<T> {
    private T element;
    private TreeNode<T> parent;
    private List<TreeNode<T>> children;

    public TreeNode(TreeNode<T> parent, T element) {
        this.element = element;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    @Override
    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public void addChild(TreeNode<T> child) {
        children.add(child);
        child.setParent(this);
    }

    public void removeChild(TreeNode<T> child) {
        children.remove(child);
    }
}
