package com.prep2020.easy;
import java.util.*;
public class Problem1047 {
	/**
	 * O(N) time and space
	 * @param S
	 * @return
	 */
	public String removeDuplicates(String S) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
        	if (!dq.isEmpty() && dq.peekLast() == c) dq.pollLast();
        	else dq.offerLast(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()) sb.append(dq.pollFirst());
        return sb.toString();
    }
}
