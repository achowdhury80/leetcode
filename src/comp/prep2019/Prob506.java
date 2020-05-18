package comp.prep2019;
import java.util.*;
public class Prob506 {
	public String[] findRelativeRanks(int[] nums) {
		String[] result = new String[nums.length];
		Queue<int[]> q = new PriorityQueue<>((x, y) -> y[0] - x[0]);
		for (int i = 0; i < nums.length; i++) q.offer(new int[] {nums[i], i});
		String[] arr = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
		for (int i = 0; i < arr.length && !q.isEmpty(); i++) {
			int[] cur = q.poll();
			result[cur[1]] = arr[i];
		}
		int rank = 4;
		while(!q.isEmpty()) result[q.poll()[1]] = "" + rank++;
		return result;
    }
}
