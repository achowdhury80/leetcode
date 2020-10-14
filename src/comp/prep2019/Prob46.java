package comp.prep2019;
import java.util.*;
public class Prob46 {
	/**
	 * O(N!) time and space
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length < 1) return result;
        boolean[] used = new boolean[nums.length];
        helper(nums, used, new ArrayList<>(), result);
        return result;
    }
	
	private void helper(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				list.add(nums[i]);
				used[i] = true;
				helper(nums, used, list, result);
				used[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}
}
