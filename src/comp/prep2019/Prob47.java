package comp.prep2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length < 1) return result;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, used, new ArrayList<>(), result);
        return result;
    }
	
	private void helper(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
			list.add(nums[i]);
			used[i] = true;
			helper(nums, used, list, result);
			used[i] = false;
			list.remove(list.size() - 1);
		}
	}
}
