package com.leet.algo;

public class Prob1093 {
	public double[] sampleStats(int[] count) {
		if(count.length == 0)
            return new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		double min = 257, max = -1;
		double total = 0;
		int totalCount = 0;
		int n = count.length;
		int mode = -1, maxCount = -1;
		for (int i = 0; i < n; i++) {
			totalCount += count[i];
			total += count[i] * i;
			if (count[i] != 0) {
				min = Math.min(min, i);
				max = Math.max(max, i);
				if (count[i] > maxCount) {
					maxCount = count[i];
					mode = i;
				}
			}
		}
		int medianIdx = (totalCount / 2) + 1;
		boolean even = (totalCount % 2) == 0;
		int cur = 0;
		int last = -1;
		double median = 0;
		for (int i = 0; i < n; i++) {
            if (count[i] == 0) continue;
			cur += count[i];
			if (even && cur >= medianIdx - 1 && last == -1) {
				last = i;
			}
			if (cur >= medianIdx) {
				if (even) median = (last + i) / 2.0;
				else median = i;
                break;
			}
		}
		return new double[] {min, max, total / (0.0 + totalCount), median, mode};
		
    }
}
