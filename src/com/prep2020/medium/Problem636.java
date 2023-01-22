package com.prep2020.medium;
import java.util.*;
public class Problem636 {
	/**
	 * O(N)
	 * @param n
	 * @param logs
	 * @return
	 */
	public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int last = -1;
        for (int i = 0; i < logs.size(); i++) {
        	String[] arr = logs.get(i).split(":");
        	int id = Integer.valueOf(arr[0]), time = Integer.valueOf(arr[2]);
        	if (arr[1].equals("start")) {
        		if (!stack.isEmpty()) {
	        		int lastId = stack.peek();
	        		result[lastId] += time - last;
        		}
        		last = time;
        		stack.push(id);
        	} else {
        		result[id] += time - last + 1;
        		stack.pop();
        		last = time + 1;
        	}
        }
        return result;
    }
}
