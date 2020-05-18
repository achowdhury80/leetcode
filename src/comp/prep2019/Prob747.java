package comp.prep2019;
import java.util.*;
public class Prob747 {
	public int dominantIndex(int[] nums) {
		if (nums.length < 2) return 0;
        Queue<Integer> q = new PriorityQueue<>((i, j) -> nums[i] - nums[j]);
        for (int i = 0; i < nums.length; i++) {
        	q.offer(i);
        	if (q.size() > 2) q.poll();
        }
        int i = q.poll(), j = q.poll();
        if (nums[i] * 2 <= nums[j]) return j;
        return -1;
    }
	
	public static void main(String[] args) {
		Prob747 prob = new Prob747();
		System.out.println(prob.dominantIndex(new int[] {0, 0, 0, 1}));
	}
}
