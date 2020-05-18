package comp.prep2019;
import java.util.*;
public class Prob740 {
	public int deleteAndEarn(int[] nums) {
		if (nums.length < 1) return 0;
        Map<Integer, int[]> indexMap = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
        	int num = nums[i];
        	if (indexMap.containsKey(num)) indexMap.get(num)[1] = i;
        	else indexMap.put(num, new int[] {i, i});
        }
        int[] dp = new int[nums.length];
        int curVal = nums[0];
        int[] idx = indexMap.get(curVal);
        dp[idx[1]] = curVal * (idx[1] - idx[0] + 1);
        int prevVal = curVal;
        int[] prevIdx = idx;
        for (int i = idx[1] + 1; i < nums.length; i++) {
        	curVal = nums[i];
        	idx = indexMap.get(curVal);
        	int curSum = curVal * (idx[1] - idx[0] + 1);
        	if (prevVal < curVal - 1) {
        		dp[idx[1]] = curSum + dp[prevIdx[1]];
        	} else {
        		dp[idx[1]] = Math.max(dp[prevIdx[1]], curSum + (prevIdx[0] > 0 ? dp[prevIdx[0] - 1]: 0));
        	}
        	i = idx[1];
        	prevVal = curVal;
            prevIdx = idx;
        }
        return dp[nums.length - 1];
    }
}
