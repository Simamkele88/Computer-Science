package queue;

public class Queue<T> {
	
   private T[] queue;
   private int f;
   private int r;
   private int N;

   
   @SuppressWarnings("unchecked")
public Queue() {
	   Object[] obj = new Object[10];
	   N = obj.length;
	   queue = (T[]) obj;
	   f = 0;
	   r = 0;
   }
   
   public T front() {
	   return queue[f];
   }
   
   public void enqueue(T element) {
	   if(r == N)
		   throw new IllegalStateException("The queue is full.");
	   
	   queue[r] = element;
	   r = (r+1) % N;
   }
   
   public T dequeue() {
	   T element = queue[f];
	   
	   queue[f] = null;
	   f = (f + 1) % N;
	   return element;
   }
   
   public int size() {
	   return (N - f + r) % N;
   }
   
   public boolean isEmpty() {
	   return (f == r);
   }
   
   public String toString() {
	   String result = "";
	   
	   for(int i = f; i < r; i++) {
		   result += queue[i].toString() + " ";
		   if(i+1 != r) {
			   result += "--> ";
		   }
	   }
	   
	   return result;
   }
}
