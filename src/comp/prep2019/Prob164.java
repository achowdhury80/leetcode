package comp.prep2019;

import java.util.Arrays;

public class Prob164 {
	public int maximumGap(int[] nums) {
		int n = nums.length;
		if(n < 2) return 0;
        int max = nums[0], min = nums[0];
        for (int num : nums) {
        	max = Math.max(max, num);
        	min = Math.min(min, num);
        }
        int gap = (int)Math.ceil((max - min - 0.0) / (n - 1));
        int[] maxBucket = new int[n - 1], minBucket = new int[n - 1];
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        for (int num : nums) {
        	if (num == min || num == max) continue;
        	int idx = (num - min) / gap;
        	minBucket[idx] = Math.min(minBucket[idx], num);
        	maxBucket[idx] = Math.max(maxBucket[idx], num);
        }
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < n - 1; i++) {
        	if (minBucket[i] == Integer.MAX_VALUE) continue;
        	maxGap = Math.max(maxGap, minBucket[i] - previous);
        	previous = maxBucket[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}
