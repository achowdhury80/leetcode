package comp.prep2019.less1000;
import java.util.*;
public class Prob442 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums.length < 2) return result;
		for (int num : nums) {
			int idx = Math.abs(num) - 1;
			if (nums[idx] < 0) result.add( Math.abs(num));
			else nums[idx] *= -1;
		}
		return result;
    }
}
