package com.prep2020.medium;
import java.util.*;
public class Problem739 {
	public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = T.length - 1; i > -1; i--) {
        	while(!dq.isEmpty() && T[dq.peekLast()] <= T[i]) dq.pollLast();
        	if (!dq.isEmpty()) result[i] = dq.peekLast() - i;
        	dq.offerLast(i);
        }
        return result;
    }
}
