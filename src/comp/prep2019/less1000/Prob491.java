package comp.prep2019.less1000;
import java.util.*;
public class Prob491 {
	public List<List<Integer>> findSubsequences(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		Set<List<Integer>>[] dp = new Set[nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i] = new HashSet<>();
			dp[i].add(Arrays.asList(nums[i]));
			for (int j = i - 1; j > -1; j--) {
				if (nums[j] <= nums[i]) {
					for (List<Integer> l : dp[j]) {
						List<Integer> newList = new ArrayList<>(l);
						newList.add(nums[i]);
						dp[i].add(newList);
						result.add(newList);
					}
				}
			}
		}
	    return new ArrayList<>(result);
	  }
}
