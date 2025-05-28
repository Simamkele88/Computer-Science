
import position.Position;
import sequence.Sequence;

public class Main {

	public static void main(String[] args) {
		Sequence<Integer> list = new Sequence<>();
		
		Position<Integer> node1 = list.addFirst(30);
		Position<Integer> node2 = list.addFirst(11);
		Position<Integer> node3 = list.addAfter(node1, 23);
		Position<Integer> node4 = list.addBefore(node3, 54);
		Position<Integer> node5 = list.addLast(34);
		System.out.println(node3.getIndex());
		list.addFirst(89);
		list.addAfter(node1,100);
		list.add(0, 33);
		list.add(1, 10);
		list.add(5, 99);
		
		System.out.println(list);
	    list.set(node5, 44);
		list.remove(node4);
		list.set(list.size()-1, 12);
		list.remove(5);
		System.out.println(list);

	}

}
