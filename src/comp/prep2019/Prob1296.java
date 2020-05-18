package comp.prep2019;
import java.util.*;
public class Prob1296 {
	public boolean isPossibleDivide(int[] nums, int k) {
		if (k == 1) return true;
		if (nums.length % k != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
        	map.put(i, map.getOrDefault(i, 0) + 1);
        	min = Math.min(min, i);
        	max = Math.max(max, i);
        }
        for (int i = min; i <= max; i++) {
        	int count = 0;
        	if ((count = map.getOrDefault(i, 0)) > 0) {
        		for (int j = i; j < i + k; j++) {
        			if (j > max) return false;
        			if (map.getOrDefault(j, 0) < count) return false;
        			map.put(j, map.get(j) - count);
        		}
        	}
        }
        return true;
    }
}
