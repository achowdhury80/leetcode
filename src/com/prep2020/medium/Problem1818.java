package com.prep2020.medium;
import java.util.*;
public class Problem1818 {
	public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long result = 0l;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums1.length; i++) {
        	result += Math.abs(nums1[i] - nums2[i]);
        	treeSet.add(nums1[i]);
        }
        int savings = 0;
        for (int i = 0; i < nums1.length; i++) {
        	int curDiff = Math.abs(nums1[i] - nums2[i]);
        	Integer floor = treeSet.floor(nums2[i]), ceil = treeSet.ceiling(nums2[i]);
        	int newDiff = Math.min(floor == null ? Integer.MAX_VALUE : nums2[i] - floor, ceil == null ? Integer.MAX_VALUE : ceil - nums2[i]);
        	savings = Math.max(savings, curDiff - newDiff);
        }
        result -= savings;
        return (int)(result % (long)(1e9 + 7));
    }
	
	public static void main(String[] args) {
		Problem1818 problem = new Problem1818();
		System.out.println(problem.minAbsoluteSumDiff(new int[] {1, 7, 5}, new int[] {2, 3, 5}));
	}
}
