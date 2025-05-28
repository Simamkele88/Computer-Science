package stack;

public class Stack<T> {
	private T[] stack;
	private int t;
	
	@SuppressWarnings("unchecked")
	public Stack() {
		Object[] obj = new Object[10];
		stack = (T[]) obj;
		t = -1;
	}
	
	@SuppressWarnings("unchecked")
	public Stack(int n) {
		super();
		Object[] obj = new Object[n];
		stack = (T[]) obj;
	}
	
	public T top() {
		return stack[t];
	}
	
	public void push(T element) {
		if(t+1 == stack.length)
			throw new IllegalStateException("The stack is full.");

		t++;
		stack[t] = element;
	}
	
	public T pop() {
		T element = top();
		stack[t] = null;
		t--;
		return element;
	}
	public String toString() {
		String result = "";
		
		for(int i = 0; i <= t; i++) {
			result += stack[i] + " ";
			if(i != t) {
				result += " --> ";
			}
		}
		
		return result;
	}
	
	public int size() {
		return t+1;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	
}
