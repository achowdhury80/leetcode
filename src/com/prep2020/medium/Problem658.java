package com.prep2020.medium;
import java.util.*;
public class Problem658 {
	/**
	 * O(N)
	 * @param arr
	 * @param k
	 * @param x
	 * @return
	 */
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length - 1;
        int pos = -1;
        if (arr[0] > x) {
        	high = 0;
        	low = -1;
        }
        else if (arr[high] < x) {
        	high = arr.length;
        	low = arr.length - 1;
        }
        else {
	        while(low < high - 1) {
	        	pos = low + (high - low) / 2;
	        	if (arr[pos] == x) {
	        		low = pos -1;
	        		high = pos;
	        		break;
	        	}
	        	if (arr[pos] < x) low = pos;
	        	else high = pos;
	        }
        }
        List<Integer> result = new ArrayList<>();
        while(k > 0) {
        	k--;
        	if (high == arr.length) result.add(0, arr[low--]);
        	else if (low == -1) result.add(arr[high++]);
        	else {
        		if (x - arr[low] > arr[high] - x) result.add(arr[high++]);
        		else result.add(0, arr[low--]);
        	}
        }
        return result;
    }
}
