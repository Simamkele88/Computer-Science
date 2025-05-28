package node;

public class Node<T> {
	
	private Node<T> next;
	private T element;
	
	public Node(Node<T> next, T element) {
		this.setNext(next);
		this.setElement(element);
	}
	
	public Node() {
		this.setNext(null);
		this.setElement(null);
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}
	
	
}
