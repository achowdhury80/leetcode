package com.prep2020.easy;

import java.util.*;

public class Problem2215 {
	public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        boolean[] arr1 = new boolean[2002], arr2 = new boolean[2001];
        for (int i : nums1)  arr1[i + 1000] = true;
        for (int i : nums2)  arr2[i + 1000] = true;
        List<List<Integer>> result = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (int i = 0 ; i < arr1.length; i++) {
        	if (arr1[i] && !arr2[i]) result.get(0).add(i - 1000);
        }
        for (int i = 0 ; i < arr2.length; i++) {
        	if (arr2[i] && !arr1[i]) result.get(1).add(i - 1000);
        }
        return result;
    }
}
