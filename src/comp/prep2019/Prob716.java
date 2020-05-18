package comp.prep2019;
import java.util.*;
/**
 * maintain an stack for regular stack work and a priority queue for max 
 * while pushing, push same data into both stack and pq
 * the data should be an array with id and value
 * while poping or polling the id should set to negative
 * @author aychowdh
 *
 */
public class Prob716 {
	private Stack<int[]> stack;
	private PriorityQueue<int[]> pq;
	private int id;
	public Prob716() {
		stack = new Stack<>();
        pq = new PriorityQueue<>((x, y) -> (y[1] - x[1] == 0 ? y[0] - x[0] : y[1] - x[1]));
        id = 0;
    }
    
    public void push(int x) {
    	id++;
    	int[] data = new int[]{id, x};
        stack.push(data);
        pq.offer(data);
    }
    
    public int pop() {
        int[] x;
        while((x = stack.pop())[0] < 0);
        x[0] = -x[0];
        return x[1];
    }
    
    public int top() {
    	int[] x;
        while((x = stack.pop())[0] < 0) ;
        stack.push(x);
        return x[1];
    }
    
    public int peekMax() {
        int[] x;
        while((x = pq.poll())[0] < 0);
        pq.offer(x);
        return x[1];
    }
    
    public int popMax() {
    	int[] x;
        while((x = pq.poll())[0] < 0) ;
        x[0] = -x[0];
        return x[1];
    }
}
