import list.PositionList;
import position.Position;

public class Main {

	public static void main(String[] args) {
		PositionList<Integer> list = new PositionList<>();
		
		Position<Integer> node1 = list.addFirst(30);
		Position<Integer> node2 = list.addFirst(11);
		Position<Integer> node3 = list.addAfter(node1, 23);
		Position<Integer> node4 = list.addBefore(node3, 54);
		Position<Integer> node5 = list.addLast(34);
		
		list.addFirst(89);
		list.addAfter(node1,100);
		
		System.out.println(list);
		list.set(node5, 44);
		list.remove(node4);
		
	
		System.out.println(list);

	}

}
