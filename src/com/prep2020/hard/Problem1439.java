package com.prep2020.hard;
import java.util.*;
public class Problem1439 {
	/*
	 * solve it for two and then iterate
	 * o(k) space
	 * o(m * k * k * log(K))
	 */
	public int kthSmallest(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[] arr = new int[Math.min(n, k)];
        for (int i = 0; i < arr.length; i++) arr[i] = mat[0][i];
        for (int i = 1; i < m; i++) {
        	Queue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
        	for (int j = 0; j < arr.length; j++) {
        		for (int x = 0; x < Math.min(mat[i].length, k); x++) {
        			q.offer(arr[j] + mat[i][x]);
        			if (q.size() > k) q.poll();
        		}
        	}
        	arr = new int[q.size()];
        	for (int l = arr.length - 1; l > -1; l--) arr[l] = q.poll();
        }
        return arr[k - 1];
	}
}
