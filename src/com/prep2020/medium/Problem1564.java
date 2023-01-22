package com.prep2020.medium;

import java.util.Arrays;

public class Problem1564 {
	/**
	 * O(N) time and space
	 * @param boxes
	 * @param warehouse
	 * @return
	 */
	public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int result = 0;
        int j = warehouse.length - 1;
        int[] warehouseMin = new int[warehouse.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < warehouse.length; i++) {
        	min = Math.min(min, warehouse[i]);
        	warehouseMin[i] = min;
        }
        int i = 0;
        while(j > -1 && i < boxes.length) {
        	if (warehouseMin[j] >= boxes[i]) {
        		result++;
        		i++;
        	} 
        	j--;
        }
        return result;
    }
}
