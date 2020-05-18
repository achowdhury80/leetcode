package comp.prep2019;
import java.util.*;
public class Prob15 {
	/*
	 * O(n^2)
	 */
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
        	if (i > 0 && nums[i] == nums[i - 1]) continue;
        	int low = i + 1, high = nums.length - 1;
        	while (low < high) {
        		int sum = nums[i] + nums[low] + nums[high];
        		if (sum == 0) {
        			result.add(Arrays.asList(nums[i], nums[low], nums[high]));
        			while(low < high && nums[low] == nums[low + 1]) low++;
        			while(high > low && nums[high] == nums[high - 1]) high--;
        			low++;
        			high--;
        		}
        		if (sum > 0) {
        			high--;
        		} else if (sum < 0) {
        			low++;
        		}
        	}
        }
        return result;
    }
}
