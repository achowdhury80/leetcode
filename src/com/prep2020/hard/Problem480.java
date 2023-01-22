package com.prep2020.hard;
import java.util.*;
public class Problem480 {
	/**
	 * O(nlogK) time and O(k) space
	 * @param nums
	 * @param k
	 * @return
	 */
	public double[] medianSlidingWindow(int[] nums, int k) {
		int n = nums.length;
        List<Integer> list = new ArrayList<>();
        double[] result = new double[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
        	int j = Collections.binarySearch(list, nums[i]);
        	if (j < 0) {
        		j = -(j + 1);
        	}
        	list.add(j, nums[i]);
        	if (list.size() > k) {
        		j = Collections.binarySearch(list, nums[i - k]);
        		list.remove(j);
        	}
        	if (list.size() == k) {
        		if (k % 2 == 0) result[idx++] 
        				= (0. + list.get((k - 1) / 2) + list.get(k / 2)) / 2;
        		else result[idx++] = list.get(k / 2);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem480 problem = new Problem480();
		System.out.println(problem.medianSlidingWindow(new int[] {1,4,2,3}, 4));
	}
}
