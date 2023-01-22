package com.prep2020.hard;

import java.util.Arrays;

public class Problem164 {
	public int maximumGap1(int[] nums) {
        int min = nums[0], max = nums[0], n = nums.length;
        for (int i : nums) {
        	min = Math.min(min, i);
        	max = Math.max(max, i);
        }
        int interval = (int)Math.ceil((max - min + 0.) / (n - 1));
        int[] minBuckets = new int[n - 1], maxBuckets = new int[n - 1];
        Arrays.fill(minBuckets, Integer.MAX_VALUE);
        Arrays.fill(maxBuckets, Integer.MIN_VALUE);
        for (int i : nums) {
        	if (i == max || i == min) continue;
        	int bucketNumber = (i - min) / interval;
        	minBuckets[bucketNumber] = Math.min(minBuckets[bucketNumber], i);
        	maxBuckets[bucketNumber] = Math.max(maxBuckets[bucketNumber], i);
        }
        int previous = min, maxGap = 0;
        for (int i = 0; i < minBuckets.length; i++) {
        	if (minBuckets[i] == Integer.MAX_VALUE && maxBuckets[i] == Integer.MIN_VALUE) continue;
        	maxGap = Math.max(maxGap, minBuckets[i] - previous);
        	previous = maxBuckets[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}
