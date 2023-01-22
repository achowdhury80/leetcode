package com.prep2020.easy;
import java.util.*;
public class Problem20 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
        	if (c == ')') {
        		if (dq.isEmpty() || dq.peekLast() != '(') return false;
        		dq.pollLast();
        	} else if (c == '}') {
        		if (dq.isEmpty() || dq.peekLast() != '{') return false;
        		dq.pollLast();
        	} else if (c == ']') {
        		if (dq.isEmpty() || dq.peekLast() != '[') return false;
        		dq.pollLast();
        	} else dq.offerLast(c);
        }
        return dq.isEmpty();
    }
	
	public static void main(String[] args) {
		Problem20 prob20 = new Problem20();
		System.out.println(prob20.isValid("([)]"));
	}
}
