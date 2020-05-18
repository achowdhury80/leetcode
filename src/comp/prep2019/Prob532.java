package comp.prep2019;
import java.util.*;
public class Prob532 {
	/**
	 * O(N) time and space
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findPairs(int[] nums, int k) {
		if (k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i : nums) {
        	if (k != 0 && map.containsKey(i)) continue;
        	map.put(i, map.getOrDefault(i, 0) + 1);
        	if (k == 0) {
        		if (map.get(i) == 2) result++;
        	} else {
	        	if (map.containsKey(i + k)) result++;
	        	if (map.containsKey(i - k)) result++;
        	}
        }
        return result;
    }
}
