package list;

public class ArrayList<T>{
	private T[] list;
	private int n;
	
	@SuppressWarnings("unchecked")
	public ArrayList() {
		Object[] obj = new Object[10];
		list = (T[]) obj;
		n = 0;
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int n) {
		super();
		Object[] obj = new Object[n];
		list = (T[]) obj;
	}
	
	public T get(int i) {
		return list[i];
	}
	
	public void add(int i, T e) {
		if(i < 0 && i >= list.length)
			throw new IndexOutOfBoundsException("invalid index specified.");
		
		if(n == list.length) {
			strategy(1,n);	
		}
		
		if(i == n) {
			list[i] = e;
			n++;
			return;
		}
		
		int j = n;
		while(j > i) {
			list[j] = list[j-1];
			j--;
		}
		
		list[i] = e;
		n++;
	}
	
	public void add(T e) {
		
		if(n == list.length) {
			strategy(1,n);	
		}
		
		list[n] = e;
		n++;
		
	}
	
	public T set(int i, T e) {
		if(i < 0 && i >= list.length)
			throw new IndexOutOfBoundsException("invalid index specified.");
		
		T elem = list[i];
		list[i] = e;
		return elem;
	}
	
	public T remove(int i) {
		if(i < 0 && i >= list.length && i >= n)
			throw new IndexOutOfBoundsException("invalid index specified.");
		
		T elem = null;
		if(i == n-1) {
			elem = list[i];
			list[i] = null; 
			n--;
			return elem;
		}
		
		elem = list[i];
		for(int k = i; k < n-1; k++) {
			list[k] = list[k+1];
		}
		
		list[n-1] = null;
		n--;
		return elem;
	}
	
	@SuppressWarnings("unchecked")
	private void strategy(int c, int length) {
		if(c == 0) {
			Object[] obj = new Object[length + 10];
			T[] B = (T[]) obj;
			for(int i = 0; i < length; i++) {
				B[i] = list[i];
			}
			list = B;
		}else {
			Object[] obj = new Object[length + length];
			T[] B = (T[]) obj;
			for(int i = 0; i < length; i++) {
				B[i] = list[i];
			}
			list = B;
		}
	}
	
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public String toString() {
		String result = "";
		
		for(int i = 0; i < n; i++) {
			result += list[i].toString() + " ";
			if(i+1 != n) {
				result += "--> ";
			}
		}
		return result;
	}
}
