package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2100 {
	/**
	 * O(N)
	 * @param security
	 * @param time
	 * @return
	 */
	public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> result = new ArrayList<>();
        if (time == 0) {
        	for (int i = 0; i < n; i++) result.add(i);
        	return result;
        }
        boolean[] nonIncreasing = new boolean[n];
        int start = 0;
        for (int i = 0; i < n; i++) {
        	if (i > 0 && security[i] > security[i - 1]) {
        		start = i;
        	}
        	if (i - start  + 1 >= time) nonIncreasing[i] = true;
        }
        
        boolean[] nonDecreasing = new boolean[n];
        start = n - 1;
        for (int i = n - 1; i > -1; i--) {
        	if (i < n - 1 && security[i] > security[i + 1]) {
        		start = i;
        	}
        	if (start - i  + 1 >= time) nonDecreasing[i] = true;
        }
        for (int i = 1; i < n - 1; i++) {
        	if (security[i] <= security[i - 1] && security[i] <= security[i + 1] 
        			&& nonIncreasing[i - 1] && nonDecreasing[i + 1]) result.add(i);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem2100 problem = new Problem2100();
		System.out.println(problem.goodDaysToRobBank(new int[] {5,3,3,3,5,6,2}, 2));
		System.out.println(problem.goodDaysToRobBank(new int[] {2,0,5,3,4}, 1));
	}
}
