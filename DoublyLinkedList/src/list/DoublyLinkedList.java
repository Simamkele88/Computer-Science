package list;

import java.util.Iterator;

import node.Node;

public class DoublyLinkedList <T extends Comparable<? super T>>{
	
	private Node<T> header;
	private Node<T> trailer;
	private int size;
	
	private class ListIterator implements Iterator<Node<T>>{
		private Node<T> cursor = first();
		private Node<T> recent = null;
		
		@Override
		public boolean hasNext() {
			return (cursor != null);
		}
		@Override
		public Node<T> next() {
			if(cursor == null) 
				throw new IllegalStateException("There is no next.");
			
			recent = cursor;
			cursor = after(cursor);
			return recent;
		}
		
		
	}
	
	public DoublyLinkedList() {
		header = new Node<>(trailer,null,null);
		trailer = new Node<>(null, null, null);
		trailer.setPrev(header);
		size = 0;
	}
	
	public Node<T> first(){
		return header.getNext();
	}
	
	public Node<T> last(){
		return trailer.getPrev();
	}
	
	public Node<T> after(Node<T> node){
		return node.getNext();
	}
	
	public Node<T> prev(Node<T> node){
		return node.getPrev();
	}
	
	public Node<T> insertFirst(T element) {
		Node<T> newNode = new Node<>(null, header, element);
		
		if(isEmpty()) {
			newNode.setNext(trailer);
			trailer.setPrev(newNode);
			header.setNext(newNode);
			size++;
			return newNode;
		}
		
		newNode.setNext(header.getNext());
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
		size++;
		return newNode;
		
	}
	
	public Node<T> insertLast(T element){
        Node<T> newNode = new Node<>(trailer, null, element);
		
		if(isEmpty()) {
			newNode.setPrev(header);
			trailer.setPrev(newNode);
			header.setNext(newNode);
			size++;
			return newNode;
		}
		
		newNode.setPrev(trailer.getPrev());
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
		size++;
		return newNode;
	}
	
	public Node<T> insertBefore(Node<T> node, T e){
		Node<T> newNode = new Node<>(null, null, e);
		
		if(isEmpty()) {
			insertFirst(e);
		}
		
		Node<T> current = header;
		
		while(current.getNext() != trailer && current.getNext() != node) {
			current = current.getNext();
		}
		
		if(current.getNext() == trailer) {
			throw new IllegalStateException("Cannot find the specified node.");
		}
		
		newNode.setPrev(current);
		newNode.setNext(current.getNext());
		current.getNext().setPrev(newNode);
		current.setNext(newNode);
		size++;
		
		return newNode;
	}
	
	public Node<T> insertAfter(Node<T> node, T e){
        Node<T> newNode = new Node<>(null, null, e);
		
		if(isEmpty()) {
			insertFirst(e);
		}
		
		Node<T> current = header;
		
		while(current.getNext() != trailer && current.getNext() != node) {
			current = current.getNext();
		}
		
		if(current.getNext() == trailer) {
			throw new IllegalStateException("Cannot find the specified node.");
		}
		
		newNode.setPrev(current.getNext());
		newNode.setNext(current.getNext().getNext());
		current.getNext().getNext().setPrev(newNode);
		current.getNext().setNext(newNode);
		size++;
		
		return newNode;
	}
	
	public T replace(Node<T> node, T e) {
		T element = null;
		
		if(node == header.getNext()) {
			element = header.getNext().getElement();
			header.getNext().setElement(e);
			return element;
		}
		
		if(node == trailer.getPrev()) {
			element = trailer.getPrev().getElement();
			trailer.getPrev().setElement(e);
			return element;
		}
		
        Node<T> current = header.getNext();
		
		while(current.getNext() != trailer && current.getNext() != node) {
			current = current.getNext();
		}
		
		if(current.getNext() == trailer) {
			throw new IllegalStateException("Cannot find the specified node.");
		}
		
		element = current.getNext().getElement();
		current.getNext().setElement(e);
		
		return element;
	}
	
	public T remove(Node<T> node) {
		
		if(node == header.getNext()) {
			Node<T> currentHead = header.getNext();
			currentHead.getNext().setPrev(header);
			header.setNext(currentHead.getNext());
			currentHead.setNext(null);
			currentHead.setPrev(null);
			size--;
			return currentHead.getElement();
		}
		
		
		Node<T> current = header.getNext();
		
		while(current.getNext() != trailer && current.getNext() != node) {
			current = current.getNext();
		}
		
		if(current.getNext() == trailer) {
			throw new IllegalStateException("Cannot find the specified node.");
		}
		
		Node<T> removed = current.getNext();
		T element = removed.getElement();
		removed.getNext().setPrev(current);
		current.setNext(removed.getNext());
		removed.setNext(null);
		removed.setPrev(null);
		size--;
		return element;
	}
	
	public void selectionSort() {
		DoublyLinkedList<T> list = new DoublyLinkedList<>();
		
		while(!isEmpty()) {
			list.insertLast(remove(first()));
		}
		
		System.out.println(this);
		
		while(!list.isEmpty()) {
			Node<T> current = list.header.getNext();
			Node<T> curr = header.getNext();
			
			if(curr == trailer) {
				insertFirst(current.getElement());
				
			}else {
				while(curr.getNext() != trailer && current.getElement().compareTo(curr.getElement()) > 0) {
					curr = curr.getNext();
				}
				
				if(curr.getNext() == trailer && current.getElement().compareTo(curr.getElement()) > 0) {
					insertAfter(curr,current.getElement());
				}else {
					insertBefore(curr,current.getElement());
				}
				
			}
			
			list.remove(current);
		}
	}
	
	public Iterator<Node<T>> iterator(){
		return new ListIterator();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		String results = "";
		Node<T> current = header.getNext();
		
		while(current != trailer) {
			results += current.getElement().toString() + " ";
			if(current.getNext() != trailer) {
				results += "<--> ";
			}
			current = current.getNext();
		}
		
		return results;
	}

}
