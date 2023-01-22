package com.prep2020.medium;

import java.util.Arrays;

public class Problem1580 {
	/**
	 * O(mlogM + nlogN)
	 * @param boxes
	 * @param warehouse
	 * @return
	 */
	public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
		int n = warehouse.length;
        int left = Integer.MAX_VALUE;
        int[] eligible = new int[n];
        for (int i = 0; i < n; i++) {
        	eligible[i] = Math.min(left, warehouse[i]);
        	left = eligible[i];
        }
        int right = Integer.MAX_VALUE;
        for (int i = n - 1; i > -1; i--) {
        	int temp = Math.min(right, warehouse[i]);
        	eligible[i] = Math.max(eligible[i], temp);
        	right = temp;
        }
        Arrays.sort(eligible);
        Arrays.sort(boxes);
        int i = boxes.length - 1, j = eligible.length - 1;
        int result = 0;
        while(i > -1 && j > -1) {
        	if (eligible[j] >= boxes[i]) {
        		j--;
        		i--;
        		result++;
        	} else i--;
        }
        return result;
    }
}
