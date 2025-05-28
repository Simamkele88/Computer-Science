package tree;

import node.TreeNode;
import position.Position;

import java.util.*;

public class Tree<T> {
    private TreeNode<T> root;
    private int size;

    public Tree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Position<T> root() {
        return root;
    }

    public Position<T> addRoot(T element) {
        if (root != null) throw new IllegalStateException("Tree already has a root.");
        root = new TreeNode<>(null, element);
        size = 1;
        return root;
    }

    public Position<T> addChild(Position<T> parentPos, T element) {
        TreeNode<T> parent = validate(parentPos);
        TreeNode<T> child = new TreeNode<>(parent, element);
        parent.addChild(child);
        size++;
        return child;
    }

    public Position<T> parent(Position<T> p) {
        TreeNode<T> node = validate(p);
        return node.getParent();
    }

    public Iterable<Position<T>> children(Position<T> p) {
        TreeNode<T> node = validate(p);
        return new ArrayList<>(node.getChildren());
    }

    public boolean isInternal(Position<T> p) {
        TreeNode<T> node = validate(p);
        return !node.getChildren().isEmpty();
    }

    public boolean isExternal(Position<T> p) {
        return !isInternal(p);
    }

    public boolean isRoot(Position<T> p) {
        return p == root;
    }

    public Position<T> replace(Position<T> p, T element) {
        TreeNode<T> node = validate(p);
        T old = node.getElement();
        node.setElement(element);
        return node;
    }

    public void remove(Position<T> p) {
        TreeNode<T> node = validate(p);
        if (node.getChildren().size() > 1) {
            throw new IllegalStateException("Cannot remove node with more than one child.");
        }
        TreeNode<T> parent = node.getParent();
        if (parent != null) parent.removeChild(node);
        else root = null;
        size--;
    }

    public int depth(Position<T> p) {
        TreeNode<T> node = validate(p);
        if (node == root) return 0;
        return 1 + depth(node.getParent());
    }

    public int height(Position<T> p) {
        TreeNode<T> node = validate(p);
        int h = 0;
        for (TreeNode<T> child : node.getChildren()) {
            h = Math.max(h, height(child));
        }
        return h + 1;
    }

    public Iterable<Position<T>> preorder() {
        List<Position<T>> result = new ArrayList<>();
        if (!isEmpty()) preorderSubtree(root, result);
        return result;
    }

    private void preorderSubtree(TreeNode<T> node, List<Position<T>> result) {
        result.add(node);
        for (TreeNode<T> child : node.getChildren()) {
            preorderSubtree(child, result);
        }
    }

    public Iterable<Position<T>> postorder() {
        List<Position<T>> result = new ArrayList<>();
        if (!isEmpty()) postorderSubtree(root, result);
        return result;
    }

    private void postorderSubtree(TreeNode<T> node, List<Position<T>> result) {
        for (TreeNode<T> child : node.getChildren()) {
            postorderSubtree(child, result);
        }
        result.add(node);
    }

    public Iterable<Position<T>> breadthFirst() {
        List<Position<T>> result = new ArrayList<>();
        if (!isEmpty()) {
            Queue<TreeNode<T>> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode<T> node = queue.poll();
                result.add(node);
                queue.addAll(node.getChildren());
            }
        }
        return result;
    }

    private TreeNode<T> validate(Position<T> p) {
        if (!(p instanceof TreeNode)) throw new IllegalArgumentException("Invalid position.");
        return (TreeNode<T>) p;
    }
}
