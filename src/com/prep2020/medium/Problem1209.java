package com.prep2020.medium;
import java.util.*;
public class Problem1209 {
	/**
	 * O(N)
	 * @param s
	 * @param k
	 * @return
	 */
	public String removeDuplicates(String s, int k) {
		Deque<int[]> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
        	if (!stack.isEmpty()) {
        		int[] top = stack.peek();
        		if (top[0] == c) {
        			top[1]++;
        			if (top[1] == k) stack.pop();
        		}
        		else stack.push(new int[] {c, 1});
        	} else stack.push(new int[] {c, 1});
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
        	int[] top = stack.pop();
        	for (int i = 0; i < top[1]; i++) sb.insert(0, (char)top[0]);
        }
        return sb.toString();
    }
}
