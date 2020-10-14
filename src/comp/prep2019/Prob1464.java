package comp.prep2019;
import java.util.*;
public class Prob1464 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int maxProduct(int[] nums) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
        	q.offer(num - 1);
        	if (q.size() > 2) q.poll();
        }
        return q.poll() * q.poll();
    }
}
