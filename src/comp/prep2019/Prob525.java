package comp.prep2019;
import java.util.*;
public class Prob525 {
	public int findMaxLength(int[] nums) {
		int result = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 0) cur--;
        	else cur++;
        	if (map.containsKey(cur)) result = Math.max(result, i - map.get(cur));
        	else map.put(cur, i);
        }
        return result == Integer.MIN_VALUE ? 0 : result;
    }
}
