package com.prep2020.easy;

public class Problem1064 {
	/**
	 * O(logN)
	 * @param arr
	 * @return
	 */
	public int fixedPoint(int[] arr) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        while(low <= high) {
        	int mid = low + (high -low) / 2;
        	if (arr[mid] == mid) {
        		result = mid;
        		high = mid - 1;
        	} else if (arr[mid] > mid) {
        		high = mid - 1;
        	} else low = mid + 1;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1064 problem = new Problem1064();
		System.out.println(problem.fixedPoint(new int[] {-10,-5,-2,0,4,5,6,7,8,9,1}));
	}
}
