package com.prep2020.medium;

public class Problem1946 {
	public String maximumNumber(String num, int[] change) {
        int start = -1, n = num.length();
        String changed = "";
        for (int i = 0; i < n; i++) {
        	int digit = num.charAt(i) - '0';
        	if (change[digit] > digit) {
        		if (start == -1) start = i;
        		changed += ("" + change[digit]);
        	} else if (change[digit] < digit) {
        		if (start > -1) {
        			return num.substring(0, start) + changed + num.substring(i);
        		}
        	} else {
        		if (start > -1) changed += ("" + change[digit]);
        	}
        }
        if (start > -1) return num.substring(0, start) + changed;
        return num;
    }
	
	public static void main(String[] args) {
		Problem1946 problem = new Problem1946();
		System.out.println(problem.maximumNumber("132", new int[] {9,8,5,0,3,6,4,2,6,8}));
		System.out.println(problem.maximumNumber("021", new int[] {9,4,3,5,7,2,1,9,0,6}));
	}
}
