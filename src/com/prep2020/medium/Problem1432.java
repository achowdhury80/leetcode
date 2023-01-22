package com.prep2020.medium;

public class Problem1432 {
	/**
	 * O(N)
	 * @param num
	 * @return
	 */
	public int maxDiff(int num) {
        int devider = (int)Math.log10(num);
        int max = 0, min = 0, maxReplacer = -1, minReplacer = -1, minReplaced = 0;
        for (int i = devider; i > -1; i--) {
        	int divBy = (int)Math.pow(10, i);
        	int cur = num / divBy;
        	num %= divBy;
        	max *= 10;
        	min *= 10;
        	if (maxReplacer == -1) if (cur < 9) maxReplacer = cur;
        	if (i == devider && cur > 1) {
        		minReplacer = cur;
        		minReplaced = 1;
        	}else if (i != devider && cur > 1 && minReplacer == -1) minReplacer = cur;
        	if (cur == maxReplacer) max += 9;
        	else max += cur;
        	if (cur == minReplacer) min += minReplaced;
        	else min += cur;
        }
        return max - min;
    }
	
	public static void main(String[] args) {
		Problem1432 problem = new Problem1432();
		//System.out.println(problem.maxDiff(9));
		System.out.println(problem.maxDiff(111));
		System.out.println(problem.maxDiff(1101057));
	}
}
