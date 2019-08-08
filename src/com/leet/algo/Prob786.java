package com.leet.algo;
import java.util.*;
public class Prob786 {
	/**
	 * Answer always exists
	 * O(NlogK) and o(K)
	 * create a min heap with int array containing indices of numerator and denominator
	 * At the beginning, add smallest k fractions starting from last element. numerator is always first element
	 * from the heap, remove first k - 1 fraction
	 * while removing each fraction, add next numerator keeping denominator same
	 * @param A
	 * @param K
	 * @return
	 */
	public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
        		(x, y) -> 
        		(A[x[0]] + 0.0)/A[x[1]] - (A[y[0]] + 0.0)/A[y[1]] == 0 ? 0
        				: ((A[x[0]] + 0.0)/A[x[1]] - (A[y[0]] + 0.0)/A[y[1]] < 0 ? -1 : 1)
        				
        );
        for (int i = A.length - 1; i > 0 && i >= A.length - K ; i--) {
        	pq.offer(new int[]{0, i});
        }
        for (int i = 0; i < K - 1; i++) {
        	int[] arr = pq.poll();
        	if (arr[0] < arr[1] - 1) pq.offer(new int[] {arr[0] + 1, arr[1]});
        }
        int[] indices = pq.poll();
        return new int[] {A[indices[0]], A[indices[1]]};
    }
	
	public static void main(String[] args) {
		Prob786 prob = new Prob786();
		int[] result = prob.kthSmallestPrimeFraction(new int[] {1, 2, 3, 5}, 3);
		System.out.println(result);
	}
}
