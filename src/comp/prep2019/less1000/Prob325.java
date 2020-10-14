package comp.prep2019.less1000;
import java.util.*;
public class Prob325 {
	public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, result = 0;
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	if (map.containsKey(sum - k)) {
        		int count = i - map.get(sum - k);
        		result = Math.max(result, count);
        	}
        	if (!map.containsKey(sum)) {
        		map.put(sum, i);
        	}
        }
        return result;
    }
}
