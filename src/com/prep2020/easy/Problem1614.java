package com.prep2020.easy;
public class Problem1614 {
	public int maxDepth(String s) {
        int count = 0, result = 0;
        for (char c : s.toCharArray()) {
        	if (c == '(') {
        		count++;
        		result = Math.max(result, count);
        	} else if (c == ')') count--;
        }
        return result;
    }
}
