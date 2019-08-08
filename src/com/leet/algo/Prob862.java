package com.leet.algo;
import java.util.*;
public class Prob862 {
	public int shortestSubarray(int[] A, int K) {
		int n = A.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) preSum[i + 1] = preSum[i] + A[i];
        int result = Integer.MAX_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();
        //include 0 also
        for (int i = 0; i < preSum.length; i++) {
        	//maintain a increasing preSum
        	while(!dq.isEmpty() && preSum[i] <= preSum[dq.getLast()]) dq.removeLast();
        	while(!dq.isEmpty() && preSum[i] >= preSum[dq.getFirst()] + K) {
        		result = Math.min(result, i - dq.pollFirst());
        	}
        	dq.addLast(i);
        }
        return result < Integer.MAX_VALUE ? result : -1;
    }
}
