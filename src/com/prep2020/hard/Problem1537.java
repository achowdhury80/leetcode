package com.prep2020.hard;

public class Problem1537 {
	public int maxSum(int[] nums1, int[] nums2) {
        int i = nums1.length - 1, j = nums2.length - 1;
        long sum1 = 0, sum2 = 0, mod = (long)(1e9 + 7);
        while(i > -1 && j > -1) {
        	if (nums1[i] == nums2[j]) {
        		sum1 += nums1[i];
            	sum2 += nums2[j];
            	sum1 = Math.max(sum1, sum2);
        		sum2 = sum1;
        		i--;
        		j--;
        	} else if (nums1[i] > nums2[j]) {
        		sum1 += nums1[i];
        		i--;
        	} else {
        		sum2 += nums2[j];
        		j--;
        	}
        }
        while(i > -1) sum1 += nums1[i--];
        while(j > -1) sum2 += nums2[j--];
        return (int)(Math.max(sum1, sum2) % mod);
    }
	
	public static void main(String[] args) {
		Problem1537 problem = new Problem1537();
		System.out.println(problem.maxSum(new int[] {1, 3, 5, 7, 9}, new int[] {3, 5, 100}));
	}
}
