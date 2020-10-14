package comp.prep2019.less1000;
import java.util.*;
public class Prob219 {
	/**
	 * O(N)
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (k < 1) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
        	if (i > k) set.remove(nums[i - k - 1]);
        	if (set.contains(nums[i])) return true;
        	set.add(nums[i]);
        }
        return false; 
    }
}
