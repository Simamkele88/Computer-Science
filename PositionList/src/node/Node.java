package node;

import position.Position;

public class Node<T> implements Position<T>{
	private T element;
	private Node<T> next;
	private Node<T> prev;
	
	public Node(Node<T> next, Node<T> prev, T elem) {
		this.setNext(next);
		this.setPrev(prev);
		this.setElement(elem);
	}
	
	@Override
	public T getElement() {
	   return element;
	}
	
	public void setElement(T elem) {
		this.element = elem;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getPrev() {
		return prev;
	}

	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}

}
