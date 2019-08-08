package com.leet.algo;

import java.util.Arrays;

public class Prob703 {
	private int[] arr;
	boolean full = false;
	private int k;
	public Prob703(int k, int[] nums) {
        arr = new int[k];
        full = nums.length >= k;
        Arrays.sort(nums);
        for (int i = 0; i < k && i < nums.length ; i++) {
        	arr[i] = nums[nums.length - i - 1];
        }
        this.k = k;
    }
    
    public int add(int val) {
        if (!full || arr[k - 1] < val) {
        	arr[k - 1] = val;
        	full = true;
        	adjust(arr);
        }
        return arr[k - 1];
    }
    
    private void adjust(int[] arr) {
    	for (int i = arr.length - 1; i > 0; i--) {
    		if (arr[i] > arr[i - 1]) {
    			int temp = arr[i];
    			arr[i] = arr[i - 1];
    			arr[i - 1] = temp;
    		} else break;
    	}
    }
    
}
