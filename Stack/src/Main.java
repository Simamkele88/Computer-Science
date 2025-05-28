import stack.Stack;

public class Main {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(23);
		stack.push(34);
		stack.push(45);
		
		System.out.println(stack);
		
		stack.pop();
		
		System.out.println(stack);
		System.out.println(stack.top());
	}

}
