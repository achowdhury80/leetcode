package comp.prep2019.less2000;
import java.util.*;
public class Prob1509 {
	public int minDifference(int[] nums) {
        if (nums.length < 5) return 0;
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int k = 0; k <= 3; k++) {
        	result = Math.min(result, nums[nums.length - 4 + k] - nums[k]);
        }
        return result;
    }
}
