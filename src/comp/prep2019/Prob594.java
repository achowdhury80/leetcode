package comp.prep2019;
import java.util.*;
public class Prob594 {
	/**
	 * O(n) time space
	 * @param nums
	 * @return
	 */
	public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	if (map.containsKey(entry.getKey() - 1)) result = Math.max(result, entry.getValue() + map.get(entry.getKey() - 1));
        	if (map.containsKey(entry.getKey() + 1)) result = Math.max(result, entry.getValue() + map.get(entry.getKey() + 1));
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob594 prob = new Prob594();
		System.out.println(prob.findLHS(new int[] {1,1,1,1}));
	}
}
