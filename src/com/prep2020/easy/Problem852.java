package com.prep2020.easy;

public class Problem852 {
	/**
	 * O(logN)
	 * @param arr
	 * @return
	 */
	public int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length - 1;
        while(low < high) {
        	int mid = low + (high - low) / 2;
        	if (mid == 0 || arr[mid] > arr[mid - 1]) {
        		if (low == mid) break;
        		else low = mid;
        	}
        	else high = mid - 1;
        }
        return arr[low] >= arr[high] ? low : high;
    }
	
	public static void main(String[] args) {
		Problem852 problem = new Problem852();
		System.out.println(problem.peakIndexInMountainArray(new int[] {3,5,3,2,0}));
	}
}
