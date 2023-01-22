package com.prep2020.medium;
import java.util.*;
public class Problem946 {
	/**
	 * O(N)
	 * @param pushed
	 * @param popped
	 * @return
	 */
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Map<Integer, Integer> pushIndexMap = new HashMap<>();
		for (int i = 0; i < pushed.length; i++) pushIndexMap.put(pushed[i], i);
        Deque<Integer> stack = new ArrayDeque<>();
        int curIndex = -1;
        for (int i : popped) {
        	int index = pushIndexMap.get(i);
        	if (index > curIndex) {
        		for (int j = curIndex + 1; j < index; j++) stack.push(pushed[j]);
        		curIndex = index;
        	} else {
        		if (stack.peek() != i) return false;
        		stack.pop();
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		Problem946 problem = new Problem946();
		System.out.println(problem.validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,5,3,2,1}));
	}
}
