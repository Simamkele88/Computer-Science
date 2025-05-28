package node;

import position.Position;

public class Node<T> implements Position<T>{
	private T element;
	private Node<T> next;
	private Node<T> prev;
	
	public Node(Node<T> next, Node<T> prev, T e) {
		this.setNext(next);
		this.setPrev(prev);
		this.setElement(e);
	}
	
	@Override
	public T getElement() {
		return this.element;
	}
	
	public void setElement(T element) {
		this.element = element;
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
