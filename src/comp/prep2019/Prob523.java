package comp.prep2019;
import java.util.*;
public class Prob523 {
	public boolean checkSubarraySum(int[] nums, int k) {
        int sum = k == 0 ? nums[0] : nums[0] % k;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum, 0);
        for (int i = 1; i < nums.length; i++) {
        	sum = k == 0 ? sum + nums[i] : (sum + nums[i]) % k;
        	if (sum == 0) return true;
        	if (map.containsKey(sum) && i - map.get(sum) > 1) return true;
        	if (!map.containsKey(sum)) map.put(sum, i);
        }
        return false;
    }
}
