package com.prep2020.medium;

public class Problem1849 {
	public boolean splitString(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
        	long firstVal = findVal(s, 0, i);
        	if (firstVal == 0) continue;
        	if (helper(s, i + 1, firstVal)) return true;
        }
        return false;
    }
	
	
	private boolean helper(String s, int startIdx, long firstVal) {
		for (int i = startIdx; i < s.length(); i++) {
			long val = findVal(s, startIdx, i);
			if (val < firstVal - 1) continue;
			if (val >= firstVal) return false;
			if (i == s.length() - 1 || helper(s, i + 1, val)) return true;
		}
		return false;
	}


	private long findVal(String s, int startIdx, int endIdx) {
		long val = 0;
		for (int i = startIdx; i <= endIdx; i++) {
			val = val * 10 + (s.charAt(i) - '0');
		}
		return val;
	}
	
	public static void main(String[] args) {
		Problem1849 problem = new Problem1849();
		System.out.println(problem.splitString("200100"));
	}
}
