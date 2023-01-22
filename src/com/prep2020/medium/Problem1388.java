package com.prep2020.medium;
import java.util.*;
public class Problem1388 {
	/**
	 * O(NLogN)
	 * @param arr
	 * @return
	 */
	public int minSetSize(int[] arr) {
        int n = arr.length;
        int[] count = new int[100001];
        for (int i : arr) count[i]++;
        Queue<int[]> maxQ = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        for (int i = 1; i < count.length; i++) {
        	if (count[i] > 0) maxQ.offer(new int[] {i, count[i]});
        }
        int elementCount = 0, result = 0;
        while(elementCount < (n / 2)) {
        	elementCount += maxQ.poll()[1];
        	result++;
        }
        return result;
    }
}
