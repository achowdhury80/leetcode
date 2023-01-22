package com.prep2020.easy;
import java.util.*;
public class Problem1576 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public String modifyString(String s) {
        char last = 'A';
        Queue<Character> q = new LinkedList<>();
        q.offer('a');
        q.offer('b');
        q.offer('c');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	char next = i < s.length() - 1 ? s.charAt(i + 1) : 'B';
        	if (c == '?') {
        		while (q.peek() == last || q.peek() == next) q.offer(q.poll());
        		sb.append(last = q.peek());
        	} else {
        		sb.append(c);
        		last = c;
        	}
        }
        return sb.toString();
    }
}
