package sequence;

import java.util.Iterator;

import node.Node;
import position.Position;

public class Sequence<T>{
	
	private class ListIterator implements Iterator<T>{
		private Position<T> cursor = first();
		private Position<T> recent = null;

		@Override
		public boolean hasNext() {
			return cursor != position(trailer);
		}

		@Override
		public T next() {
			if(cursor == position(trailer))
				throw new IllegalStateException("No next element available.");
			
			recent = cursor;
			cursor = after(cursor);
			return recent.getElement();
		}
		
	}
	
	private class PositionIterable implements Iterable<T>{
		@Override
		public Iterator<T> iterator() {
			return new ListIterator();
		}
		
	}
	
	private Node<T> header;
	private Node<T> trailer;
	private int size;
	
	public Sequence() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
		size = 0;
	}
	
	private Position<T> position(Node<T> node){
		if(node == header || node == trailer)
			return null;
		
		return node;
	}
	
	public Position<T> first(){
		return position(header.getNext());
	}
	
	public Position<T> last(){
		return position(trailer.getPrev());
	}
	
	public Position<T> before(Position<T> p){
		Node<T> node = validate(p);
		return position(node.getPrev());
	}
	
	public Position<T> after(Position<T> p){
		Node<T> node = validate(p);
		return position(node.getNext());
	}
	
	public Position<T> get(int i){
		if(validateIndex(i)) {
			int j = 0;
			Node<T> current = header.getNext();
			while(j != i) {
				current = current.getNext();
				j++;
			}
			return position(current);
		}
		return null;
	}
	
	public void add(int i, T e) {
		if(validateIndex(i)) {
			int j = 0;
			Node<T> current = header.getNext();
			while(j != i) {
				current = current.getNext();
				j++;
			}
			addBefore(current,e);
		}
	}
	
	public T set(int i, T e) {
		if(validateIndex(i)) {
			int j = 0;
			Node<T> current = header.getNext();
			while(j != i) {
				current = current.getNext();
				j++;
			}
			T elem = current.getElement();
			current.setElement(e);
			return elem;
		}
		return null;
	}
	
	public T remove(int i) {
		if(validateIndex(i)) {
			int j = 0;
			Node<T> current = header.getNext();
			while(j != i) {
				current = current.getNext();
				j++;
			}
			T elem = current.getElement();
			remove(current);
			return elem;
		}
		return null;
	}
	
	public Position<T> addBetween(Node<T> next, Node<T> prev, T e){
		Node<T> newNode = new Node<>(next, prev, e);
		prev.setNext(newNode);
		next.setPrev(newNode);
		size++;
		return position(newNode);
	}
	
	public Position<T> addFirst(T element){
        return addBetween(header.getNext(),header,element);
	}
	
	public Position<T> addLast(T element){
        return addBetween(trailer, trailer.getPrev(), element);
	}
	
	public Position<T> addBefore(Position<T> node, T e){
		Node<T> existing = validate(node);
		return addBetween(existing, existing.getPrev(), e);
	}
	
	public Position<T> addAfter(Position<T> node, T e){
		Node<T> existing = validate(node);
		return addBetween(existing.getNext(), existing, e);
	}
	
	public T set(Position<T> node, T e) {
		Node<T> changed = validate(node);
		T element = changed.getElement();
		changed.setElement(e);
		return element;
	}
	
    public T remove(Position<T> node) {
		Node<T> removed = validate(node);
		T element = removed.getElement();
		removed.getNext().setPrev(removed.getPrev());
		removed.getPrev().setNext(removed.getNext());
		removed.setNext(null);
		removed.setPrev(null);
		removed.setElement(null);
		size--;
		return element;
	}
	
	private Node<T> validate(Position<T> p){
		if(!(p instanceof Node<T>))
			throw new IllegalStateException("Invalid position.");
		
		Node<T> node = (Node<T>) p;
		if(node.getNext() == null)
			throw new IllegalStateException("Invalid position.");
		
		return node;
	}
	
	private boolean validateIndex(int i) {
		return (i >= 0 && i < size);
	}
	
	public Iterator<T> iterator(){
		return new ListIterator();
	}
	
	public Iterable<T> iterable(){
		return new PositionIterable();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		String result = "";
		Iterator<T> ite = iterator();
		while (ite.hasNext()) {
		    T current = ite.next();
		    result += current.toString();
		    if(ite.hasNext()) {
		        result += " --> ";
		    }
		}
		return result;
	}
}
