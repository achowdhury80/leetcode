package comp.prep2019;
import java.util.*;
public class Prob220 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0) return false;
		Map<Long, Long> map = new HashMap<>();
		long devider = t + 1l;
		for (int i = 0; i < nums.length; i++) {
			long mappedNum = nums[i] + 0l - Integer.MIN_VALUE;
			long bucket = mappedNum / devider;
			if (map.containsKey(bucket) || map.containsKey(bucket - 1) && mappedNum - map.get(bucket - 1) <= t 
					|| map.containsKey(bucket + 1) && map.get(bucket + 1) - mappedNum <= t) return  true;
			if (map.size() >= k) {
				map.remove((nums[i - k] + 0l - Integer.MIN_VALUE) / devider);
			}
			map.put(bucket, mappedNum);
		}
		return false; 
    } 
}
