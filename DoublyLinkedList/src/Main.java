import list.DoublyLinkedList;
import node.Node;

public class Main {

	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		
		Node<Integer> node1 = list.insertFirst(30);
		Node<Integer> node2 = list.insertFirst(11);
		Node<Integer> node3 = list.insertAfter(node1, 23);
		Node<Integer> node4 = list.insertBefore(node3, 54);
		Node<Integer> node5 = list.insertLast(34);
		list.insertFirst(89);
		list.insertAfter(node1,100);
		
		System.out.println(list);
		list.replace(node5, 44);
		list.selectionSort();
		
		System.out.println(list);
		
		
	}
	
}