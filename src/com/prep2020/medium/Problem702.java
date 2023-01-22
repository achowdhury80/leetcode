package com.prep2020.medium;

public class Problem702 {
	/**
	 * O(logN)
	 * @param reader
	 * @param target
	 * @return
	 */
	public int search(ArrayReader reader, int target) {
        int low = 0, high = 9999;
        while(low <= high) {
        	int mid = low + (high - low) / 2;
        	int val = reader.get(mid);
        	if (val == target) return mid;
        	if (val == Integer.MAX_VALUE || val > target) high = mid - 1;
        	else low = mid + 1;
        }
        return -1;
    }
	
	interface ArrayReader {
		     public int get(int index);
		 }
}
