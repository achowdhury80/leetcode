package comp.prep2019;
import java.util.*;
public class Prob486 {
	public boolean PredictTheWinner(int[] nums) {
        return netGain(nums, 0, nums.length - 1, new HashMap<>()) >= 0;
    }
	
	private int netGain(int[] arr, int start, int end, Map<Integer, Integer> cache) {
		if (start == end) return arr[start];
		int key = start | (end << 5);
		if (cache.containsKey(key)) return cache.get(key);
		int result = Math.max(arr[start] - netGain(arr, start + 1, end, cache),  
				arr[end] - netGain(arr, start, end - 1, cache));
		cache.put(key, result);
		return result;
	}
}
