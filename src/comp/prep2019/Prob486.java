package comp.prep2019;
import java.util.*;
public class Prob486 {
	public boolean PredictTheWinner(int[] nums) {
        return netGain(nums, 0, nums.length - 1, new HashMap<>()) >= 0;
    }
	
	private int netGain(int[] nums, int start, int end, Map<String, Integer> map) {
		String key = start + "-" + end;
		if (map.containsKey(key)) return map.get(key);
		if (start == end) {
			map.put(key, nums[start]);
			return nums[start];
		}
		int max = Math.max(nums[start] - netGain(nums,  start + 1, end, map),
				nums[end] - netGain(nums, start, end - 1, map));
		map.put(key, max);
		return max;
	}
}
