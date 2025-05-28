import list.SinglyLinkedList;
import node.Node;
public class Main {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		Node<Integer> node1 = list.insertFirst(30);
		Node<Integer> node2 = list.insertFirst(11);
		Node<Integer> node3 = list.insertAfter(node1, 23);
		Node<Integer> node4 = list.insertBefore(node3, 54);
		Node<Integer> node5 = list.insertLast(34);
		list.insertFirst(89);
		list.insertAfter(node1,100);
		
		System.out.println(list);
		
		list.selectionSort();
		
		System.out.println(list);
	}

}
