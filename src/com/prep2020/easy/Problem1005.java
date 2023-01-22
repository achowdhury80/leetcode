package com.prep2020.easy;
import java.util.*;
public class Problem1005 {
	/**
	 * O(NlogK) time and O(K) space
	 * @param A
	 * @param K
	 * @return
	 */
	public int largestSumAfterKNegations(int[] A, int K) {
        int sum = A[0];
        Queue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
        q.offer(A[0]);
        for (int i = 1; i < A.length; i++) {
        	sum += A[i];
        	q.offer(A[i]);
        	if (q.size() > K) q.poll();
        }
        Queue<Integer> minQ = new PriorityQueue<>();
        while(!q.isEmpty()) minQ.offer(q.poll());
        while(minQ.size() > 0 && minQ.peek() < 0 && K > 0) {
        	int num = minQ.poll();
        	sum -= 2 * num;
        	minQ.offer(-num);
            K--;
        }
        if (K % 2 == 1) sum -= 2 * minQ.poll();
        return sum;
    }
}
