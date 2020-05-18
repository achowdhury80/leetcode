package comp.prep2019;
import java.util.*;
public class Prob1403 {
	public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i : nums) sum +=i;
        List<Integer> result = new ArrayList<>();
        int curSum = 0;
        for (int i = nums.length - 1; i > -1; i++) {
        	curSum += nums[i];
        	result.add(nums[i]);
        	if (2 * curSum > sum) break;
        }
        return result;
    }
}
