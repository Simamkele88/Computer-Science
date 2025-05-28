package list;

import node.Node;

public class SinglyLinkedList<T extends Comparable<? super T>>{
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public  SinglyLinkedList() {
		head = new Node<>(null,null);
		tail = new Node<>(null,null);
		size = 0;
	}
	
	public Node<T> first(){
		return head;
	}
	
	public Node<T> last(){
		return tail;
	}
	
	public Node<T> insertFirst(T element){
		Node<T> newNode = new Node<>(null,element);
		
		if(isEmpty()){
			head = newNode;
			tail = newNode;
			size++;
			return newNode;
		}
		
		newNode.setNext(head);
		head = newNode;
		size++;
		return newNode;
		
	}
	
	public Node<T> insertLast(T element){
		Node<T> newNode = new Node<>(null, element);
		
		if(isEmpty()){
			head = newNode;
			tail = newNode;
			size++;
			return newNode;
		}
		
		tail.setNext(newNode);
		tail = newNode;
		size++;
		return newNode;
	}
	
	public Node<T> insertBefore(Node<T> node, T element){
		Node<T> newNode = new Node<>(null,element);
		
		if(isEmpty()){
			head = newNode;
			tail = newNode;
			size++;
			return newNode;
		}
		
		if(head == node) {
			return insertFirst(element);
		}
		
		Node<T> current = head;
		
		while(current.getNext() != null && current.getNext() != node) {
			current = current.getNext();
		}
		
		if(current.getNext() == null) {
			throw new IllegalStateException("Cannot find the specified node.");
		}
		
		newNode.setNext(current.getNext());
		current.setNext(newNode);
		size++;
		return newNode;
	}
	
	public Node<T> insertAfter(Node<T> node, T element){
		Node<T> newNode = new Node<>(null,element);
		
		if(isEmpty()){
			head = newNode;
			tail = newNode;
			size++;
			return newNode;
		}
		
		if(head == node) {
			newNode.setNext(head.getNext());
			head.setNext(newNode);
			size++;
			return newNode;
		}
		
		if(node == tail) {
			return insertLast(element);
		}
		
		Node<T> current = head;
		
		while(current.getNext() != null && current.getNext() != node) {
			current = current.getNext();
		}
		
		if(current.getNext() == null) {
			throw new IllegalStateException("Cannot find the specified node.");
		}
	
		newNode.setNext(current.getNext().getNext());
		current.getNext().setNext(newNode);
		size++;
		return newNode;
	}
	
	public T replace(Node<T> node, T e) {
		T element = null;
		
		if(node == head) {
			element = head.getElement();
			head.setElement(e);
			return element;
		}
		
		if(node == tail) {
			element = tail.getElement();
			tail.setElement(e);
			return element;
		}
		
        Node<T> current = head;
		
		while(current.getNext() != null && current.getNext() != node) {
			current = current.getNext();
		}
		
		if(current.getNext() == null) {
			throw new IllegalStateException("Cannot find the specified node.");
		}
		
		element = current.getNext().getElement();
		current.getNext().setElement(e);
		
		return element;
	}
	
	public T remove(Node<T> node) {
		if(node == head) {
			Node<T> currentHead = head;
			head = head.getNext();
			currentHead.setNext(null);
			size--;
			return currentHead.getElement();
		}
		
		if(node == tail) {
			Node<T> current = head;
			while(current.getNext() != tail) {
				current = current.getNext();
			}
			
			T element = tail.getElement();
			tail = current;
			current.setNext(null);
			size--;
			return element;
		}
		
		Node<T> current = head;
		
		while(current.getNext() != null && current.getNext() != node) {
			current = current.getNext();
		}
		
		if(current.getNext() == null) {
			throw new IllegalStateException("Cannot find the specified node.");
		}
		
		Node<T> removed = current.getNext();
		T element = removed.getElement();
		current.setNext(removed.getNext());
		removed.setNext(null);
		size--;
		return element;
	}
	
	
	public void selectionSort() {
		SinglyLinkedList<T> list = new SinglyLinkedList<>();
		
		while(!isEmpty()) {
			list.insertLast(remove(first()));
		}
		
		System.out.println(this);
		
		while(!list.isEmpty()) {
			Node<T> current = list.head;
			Node<T> curr = head;
			
			if(curr == null) {
				insertFirst(current.getElement());
				
			}else {
				while(curr.getNext() != null && current.getElement().compareTo(curr.getElement()) > 0) {
					curr = curr.getNext();
				}
				
				if(curr.getNext() == null && current.getElement().compareTo(curr.getElement()) > 0) {
					insertAfter(curr,current.getElement());
				}else {
					insertBefore(curr,current.getElement());
				}
				
			}
			
			list.remove(current);
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		String results = "";
		Node<T> current = head;
		
		while(current != null) {
			results += current.getElement().toString() + " ";
			if(current.getNext() != null) {
				results += "--> ";
			}
			current = current.getNext();
		}
		
		return results;
	}
	
}
