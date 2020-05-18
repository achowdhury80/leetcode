package comp.prep2019;
import java.util.*;
public class Prob703 {
	/**
	 * O(nlogK)
	 * maintain a min heap
	 * keep adding elements
	 * remove the peek element when size greater than k
	 */
	private Queue<Integer> q; 
	private int k;
	public Prob703(int k, int[] nums) {
		this.k = k;
        q = new PriorityQueue<>((x, y) -> x - y);
        for (int i : nums) {
        	q.offer(i);
        	if (q.size() > k) q.poll();
        }
    }
    
    public int add(int val) {
        q.offer(val);
        if (q.size() > k) q.poll();
        return q.peek();
    }
}
