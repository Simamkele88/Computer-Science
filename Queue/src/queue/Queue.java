package queue;

import list.DoublyLinkedList;

public class Queue<T extends Comparable<? super T>>{
	private DoublyLinkedList<T> list;
	
	public Queue() {
		list = new DoublyLinkedList<>();
	}
	
	public T front() {
		return list.first().getElement();
	}
	
	public void enqueue(T element) {
		list.insertLast(element);
	}
	
	public T dequeue() {
		T element = front();
		
		list.remove(list.first());
		
		return element;
	}
	
	public int size() {
		return list.size();
	}
	
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public String toString() {
		return list.toString();
	}
}
