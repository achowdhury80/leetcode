package com.prep2020.medium;

public class Problem1881 {
	/**
	 * O(n)
	 * @param n
	 * @param x
	 * @return
	 */
	public String maxValue(String n, int x) {
		StringBuilder sb = new StringBuilder();
        if (n.charAt(0) == '-') {
        	sb.append('-');
        	for (int i = 1; i < n.length(); i++) {
        		if ((n.charAt(i) - '0') > x) {
        			sb.append(x);
        			sb.append(n.substring(i));
        			return sb.toString();
        		} else sb.append(n.charAt(i));
        	}
        	sb.append(x);
    		return sb.toString();
        } else {
        	for (int i = 0; i < n.length(); i++) {
        		if ((n.charAt(i) - '0') < x) {
        			sb.append(x);
        			sb.append(n.substring(i));
        			return sb.toString();
        		} else sb.append(n.charAt(i));
        	}
        	sb.append(x);
    		return sb.toString();
        }
    }
}
