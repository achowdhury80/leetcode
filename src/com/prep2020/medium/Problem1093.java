package com.prep2020.medium;

public class Problem1093 {
	/**
	 * O(N)
	 * @param count
	 * @return
	 */
	public double[] sampleStats(int[] count) {
        int totalFreq = 0;
        double sum = 0;
        int maxFreq = 0;
        double[] result = new double[5];
        result[0] = Double.MAX_VALUE;
        result[1] = Double.MIN_VALUE;
        for (int i = 0; i < count.length; i++) {
        	if (count[i] == 0) continue;
        	result[0] = Math.min(result[0], i);
        	result[1] = Math.max(result[1], i);
        	sum += (1.0 * i * count[i]);
        	totalFreq += count[i];
        	if (count[i] > maxFreq) {
        		result[4] = i;
        		maxFreq = count[i];
        	}
        }
        result[2] = sum / totalFreq;
        int freqSum = 0;
        for (int i = 0; i < count.length; i++) {
        	if (count[i] == 0) continue;
        	freqSum += count[i];
        	if (freqSum >= (totalFreq + 1) / 2) {
        		if (totalFreq % 2 == 1 || freqSum > (totalFreq + 1) / 2) {
        			result[3] = i;
        			break;
        		}
        		int cur = i;
        		while(count[++i] == 0);
        		result[3] = (cur + i + 0.) / 2;
        		break;
        	}
        }
        return result;
    }
}
