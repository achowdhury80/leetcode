package com.leet.algo;

public class Prob702 {
	public int search(ArrayReader reader, int target) {
        int start = 0, end = 19999;
        while(start <= end) {
        	int mid = start + (end - start) / 2;
    		int val = reader.get(mid);
    		if (val == 2147483647) end = mid - 1;
    		else if (val == target) return mid;
    		else if (val > target) end = mid - 1;
    		else if (val < target) start = mid + 1;
        }
        return -1;
    }
	
	class ArrayReader {
		public int get(int i) {
			return -1;
		}
	}
	
	
}
