package com.prep2020.easy;
import java.util.*;
public class Problem349 {
	/**
	 * O(M + N) time
	 * O(M) space
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) return intersection(nums2, nums1);
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) set.add(num);
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
        	if (set.contains(num)) {
        		list.add(num);
        		set.remove(num);
        	}
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) result[i] = list.get(i);
        return result;
    }
}
