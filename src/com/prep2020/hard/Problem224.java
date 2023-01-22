package com.prep2020.hard;
import java.util.*;
public class Problem224 {
	/**
	 * O(N) time and space
	 * @param s
	 * @return
	 */
	public int calculate(String s) {
        int result = 0, sign = 1, val = 0;
        Deque<Integer> dq = new ArrayDeque<>(); 
        for (char c : s.toCharArray()) {
        	if (c >= '0' && c <= '9') val = val * 10 + (c - '0');
        	else if (c == '+' || c == '-') {
        		result += sign * val;
        		val = 0;
        		sign = c == '+' ? 1 : -1;
        	} else if (c == '(') {
        		dq.addLast(result);
        		dq.addLast(sign);
        		result = 0;
        		val = 0;
        		sign = 1;
        	} else if (c == ')') {
        		result += sign * val;
        		result *= dq.removeLast();
        		result += dq.removeLast();
        		val = 0;
        		sign = 1;
        	}
        }
        result += sign * val;
        return result;
    }
}
