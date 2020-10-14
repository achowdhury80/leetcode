package comp.prep2019;
import java.util.*;
public class Prob347 {
	/**
	 * NlogK
	 * @param nums
	 * @param k
	 * @return
	 */
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(
        		(x, y) -> x.getValue() - y.getValue());
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	q.offer(entry);
        	if (q.size() > k) q.poll();
        }
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty())result.add(0, q.poll().getKey());
        return result;
    }
}
