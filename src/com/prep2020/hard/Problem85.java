package com.prep2020.hard;
import java.util.*;
public class Problem85 {
	public int maximalRectangle(char[][] matrix) {
        int result = 0;
        int m = matrix.length, n = matrix[0].length;
        int[] arr = new int[n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j] == '1') arr[j]++;
        		else arr[j] = 0;
        	}
        	result = Math.max(result, findMaxHist(arr));
        }
        return result;
    }

	private int findMaxHist(int[] arr) {
		Deque<Integer> stack = new ArrayDeque<>();
		int i = 0, result = 0;
		while(i <= arr.length) {
			int h = i == arr.length ? 0 : arr[i];
			if (stack.isEmpty() || h >= arr[stack.peek()]) stack.push(i++);
			else {
				int tp = stack.pop();
				result = Math.max(result, arr[tp] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
			}
		}
		return result;
	}
}
