package stack;
import java.util.EmptyStackException;

import list.DoublyLinkedList;

public class Stack<T extends Comparable<? super T>> {
	
	private DoublyLinkedList<T> list;
	
	public Stack() {
		list = new DoublyLinkedList<>();
		
	}
	
	public T top() throws EmptyStackException{
		return list.first().getElement();
	}
	
	public void push(T element) {
		list.insertFirst(element);
	}
	
	public T pop() {
		return list.remove(list.first());
	}
	
	public String toString(){
		return list.toString();
	}
}
