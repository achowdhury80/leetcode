package com.prep2020.medium;
import java.util.*;

public class Problem1198 {
	/**
	 * O(MNlogM)
	 * @param mat
	 * @return
	 */
	public int smallestCommonElement(int[][] mat) {
		// 1st element row and 2nd element column index
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> mat[x[0]][x[1]] - mat[y[0]][y[1]]);
        int max = -1;
        for (int i = 0; i < mat.length; i++) {
        	max = Math.max(max, mat[i][0]);
        	pq.offer(new int[] {i, 0});
        }
        
        while(max != mat[pq.peek()[0]][pq.peek()[1]]) {
        	int[] arr = pq.poll();
        	if (mat[arr[0]].length - 1 == arr[1]) return -1;
        	arr[1]++;
        	pq.offer(arr);
        	max = Math.max(max, mat[arr[0]][arr[1]]);
        }
        return max;
    }
}
