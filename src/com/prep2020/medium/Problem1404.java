package com.prep2020.medium;

public class Problem1404 {
	public int numSteps(String s) {
        if ("1".equals(s)) return 0;
        if (s.charAt(s.length() - 1) == '0') 
        	return 1 + numSteps(s.substring(0, s.length() - 1));
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i > -1; i--) {
        	if (arr[i] == '0') {
        		arr[i] = '1';
        		return 1 + numSteps(new String(arr));
        	} else arr[i] = '0';
        }
        return 1 + numSteps("1" + new String(arr));
    }
	
	public static void main(String[] args) {
		Problem1404 problem = new Problem1404();
		System.out.println(problem.numSteps("1101"));
	}
}
