package comp.prep2019;
import java.util.*;
public class Prob548 {
	public boolean splitArray(int[] nums) {
        int n = nums.length;
        if (n < 7) return false;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) sum[i] = nums[i] + sum[i - 1];
        for (int j = 3; j < n - 3; j++) {
        	if (helper(sum, j)) return true;
        }
        return false;
    }
	
	private boolean helper(int[] sum, int j) {
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i < j - 1; i++) {
			if (sum[i - 1] == sum[j - 1] - sum[i]) set.add(sum[i - 1]);
		}
		for (int k = j + 2; k < sum.length - 1; k++) {
			if (set.contains(sum[k - 1] - sum[j]) 
					&& sum[k - 1] - sum[j] == sum[sum.length - 1] - sum[k]) 
				return true;
		}
		return false;
	}
}
