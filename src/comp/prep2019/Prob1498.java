package comp.prep2019;

import java.util.Arrays;

public class Prob1498 {
	public int numSubseq(int[] nums, int target) {
        int MOD = (int)(1e9 + 7);
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        int result = 0;
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < pow.length; i++) pow[i] = (2 * pow[i - 1]) % MOD;
        while (low <= high) {
        	if (nums[low] + nums[high] > target) high--;
        	else {
        		result = (result + pow[high - low]) % MOD;
        		low++;
        	}
        }
        return result;
    }
}
