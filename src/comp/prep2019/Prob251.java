package comp.prep2019;
import java.util.*;
public class Prob251 {
	private int[][] v;
	private int i;
	private Queue<Integer> q;
	public Prob251(int[][] v) {
        this.v = v;
        q = new LinkedList<>();
        while(i < v.length && q.isEmpty()) {
        	int[] arr = v[i++];
        	if(arr != null) {
	        	for (int a : arr) {
	        		q.offer(a);
	        	}
        	}
        }
    }
    
    public int next() {
        int result = q.poll();
        while(i < v.length && q.isEmpty()) {
        	int[] arr = v[i++];
        	if(arr != null) {
	        	for (int a : arr) {
	        		q.offer(a);
	        	}
        	}
        }
        return result;
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}
