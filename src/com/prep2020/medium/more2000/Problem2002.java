package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2002 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int maxProduct(String s) {
        int n = s.length();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < (1 << n); i++) {
        	String sub = "";
        	for (int j = 0; j < n; j++) {
        		if((i & (1 << j)) != 0) sub += s.charAt(j);
        	}
        	if (isPlainndrome(sub)) map.put(i, sub.length());
        }
        int result = Integer.MIN_VALUE;
        
        for (int i : map.keySet()) {
        	for (int j : map.keySet()) {
        		if (i != j && (i & j) == 0) 
        			result = Math.max(result, map.get(i) * map.get(j));
        	}
        }
        return result;
    }
	
	private boolean isPlainndrome(String sub) {
		int i = 0, j = sub.length() - 1;
		while(i < j) {
			if (sub.charAt(i) != sub.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		Problem2002 problem = new Problem2002();
		System.out.println(problem.maxProduct("leetcodecom"));
	}
}
