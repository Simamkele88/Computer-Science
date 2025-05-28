import queue.Queue;

public class Main {

	public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
		
		queue.enqueue(12);
		queue.enqueue(23);
		queue.enqueue(34);
		queue.enqueue(21);
		queue.enqueue(54);
		queue.enqueue(20);
		
		System.out.println(queue);
		
		queue.dequeue();
		
		System.out.println(queue);

	}

}
