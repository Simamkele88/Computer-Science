package node;

public class Node<T> {
	
	private Node<T> next;
	private Node<T> prev;
	private T element;
	
	public Node(Node<T> next,Node<T> prev, T element) {
		this.setNext(next);
		this.setPrev(prev);
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

	public Node<T> getPrev() {
		return prev;
	}

	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	
}
