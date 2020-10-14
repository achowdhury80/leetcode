package comp.prep2019;
import java.util.*;
public class Prob78 {
	/**
	 * O(N * 2^N) time and space
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int n;
		if (nums == null || (n = nums.length) == 0) return result;
		for (int i = 0; i < Math.pow(2, n); i++) {
			List<Integer> list = new ArrayList<>();
			int j = i;
			int k = -1;
			while(j > 0) {
				k++;
				if((j & 1) == 1) list.add(nums[k]);
				j >>= 1;
			}
			result.add(list);
		}
		return result;
    }
}
