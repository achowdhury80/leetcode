package com.prep2020.easy;

public class Problem2042 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public boolean areNumbersAscending(String s) {
		StringBuilder sb = new StringBuilder();
		int last = 0;
		boolean isNumber = false;
        for (char c : s.toCharArray()) {
        	if (c == ' ') {
        		if (isNumber) {
        			int num = Integer.parseInt(sb.toString());
        			if (num <= last) return false;
        			last = num;
        		} 
        		isNumber = false;
    			sb = new StringBuilder();
        	} else {
    			if (Character.isDigit(c)) isNumber = true;
    			sb.append(c);
    		}
        }
        if (isNumber) {
			int num = Integer.parseInt(sb.toString());
			if (num <= last) return false;
		}
        return true;
    }
	
	public static void main(String[] args) {
		Problem2042 problem = new Problem2042();
		System.out.println(problem.areNumbersAscending("hello world 5 x 5"));
	}
}
