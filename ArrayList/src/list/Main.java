package list;

public class Main {
	
	
	public static void main(String... args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(27);
		list.add(23);
		list.add(34);
		list.add(45);
		list.add(56);
		
		System.out.println(list);
		
		list.add(2,89);
		list.remove(3);
		
		System.out.println(list);
	}
}
