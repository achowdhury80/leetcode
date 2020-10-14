package comp.prep2019.less1000;
import java.util.*;
public class Prob628 {
	/**
	 * o(N) time and O(1) space
	 * maintain a min heap with max three numbers
	 * and a max heap with min two numbers
	 * find the prod of two min numbers(for the case with negative numbers) - prod2
	 * find the prod of 2nd and 3rd largest number - prod1
	 * return max of largest * prod1 and largest * prod2
	 * @param nums
	 * @return
	 */
	public int maximumProduct(int[] nums) {
        Queue<Integer> max = new PriorityQueue<>();
        Queue<Integer> min = new PriorityQueue<>((x, y) -> y - x);
        for (int i : nums) {
        	max.offer(i);
        	if (max.size() > 3) max.poll();
        	min.offer(i);
        	if (min.size() > 2) min.poll();
        }
        int prod1 = max.poll() * max.poll(), prod2 = min.poll() * min.poll();
        int largest = max.poll();
        return Math.max(largest * prod1, largest * prod2);
    }
}
